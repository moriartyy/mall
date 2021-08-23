package mall.data.dictionary.service.infrastructure.mysql.repository;

import mall.core.util.ObjectUtils;
import mall.core.util.Tuple;
import mall.data.dictionary.service.domain.Dictionary;
import mall.data.dictionary.service.domain.DictionaryItem;
import mall.data.dictionary.service.domain.DictionaryRepository;
import mall.data.dictionary.service.infrastructure.mysql.entity.DictionaryItemPO;
import mall.data.dictionary.service.infrastructure.mysql.entity.DictionaryPO;
import mall.data.dictionary.service.infrastructure.mysql.mapper.DictionaryItemMapper;
import mall.data.dictionary.service.infrastructure.mysql.mapper.DictionaryMapper;
import mall.data.dictionary.service.infrastructure.mysql.translator.DictionaryTranslator;
import mall.infrastructure.mybatis.MybatisRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;


/**
 * @author Walter
 */
@Component
public class MysqlDictionaryRepository extends MybatisRepository<Integer, Dictionary, DictionaryPO> implements DictionaryRepository {

    private final DictionaryTranslator dictionaryTranslator;
    private final DictionaryItemMapper dictionaryItemMapper;
    private final DictionaryMapper dictionaryMapper;

    protected MysqlDictionaryRepository(DictionaryMapper dictionaryMapper, DictionaryItemMapper dictionaryItemMapper) {
        super(dictionaryMapper);
        this.dictionaryMapper = dictionaryMapper;
        this.dictionaryItemMapper = dictionaryItemMapper;
        this.dictionaryTranslator = new DictionaryTranslator();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void save(Dictionary dictionary) {
        Tuple<DictionaryPO, List<DictionaryItemPO>> tuple = dictionaryTranslator.forward(dictionary);
        DictionaryPO dictionaryPO = tuple.getV1();
        List<DictionaryItemPO> dictionaryItemPOList = tuple.getV2();

        Function<DictionaryPO, Integer> saveDictionary;
        Function<DictionaryItemPO, Integer> saveDictionaryItem;

        if (dictionary.getId() == null) {
            saveDictionary = this.dictionaryMapper::insert;
            saveDictionaryItem = this.dictionaryItemMapper::insert;
        } else {
            saveDictionary = this.dictionaryMapper::updateById;
            saveDictionaryItem = this.dictionaryItemMapper::updateById;
        }
        saveDictionary.apply(dictionaryPO);
        ObjectUtils.copyProperties(dictionaryPO, dictionary);
        dictionaryItemPOList.forEach(saveDictionaryItem::apply);
        dictionary.setItems(
                dictionaryItemPOList.stream()
                        .map(i -> ObjectUtils.createInstanceOf(DictionaryItem.class, i))
                        .collect(Collectors.toList())
        );
    }

    @Override
    public Optional<Dictionary> getIfPresent(Integer id) {
        return Optional.ofNullable(this.dictionaryMapper.selectById(id)).map(this::getDictionary);
    }

    @Override
    public void delete(Integer id) {
        DictionaryPO dictionaryPO = this.dictionaryMapper.selectById(id);
        if (dictionaryPO != null) {
            this.dictionaryItemMapper.deleteByDictionaryCode(dictionaryPO.getCode());
            this.dictionaryMapper.deleteById(id);
        }
    }

    public Optional<Dictionary> getIfPresentByCode(String code) {
        return Optional.ofNullable(this.dictionaryMapper.selectOneByCode(code)).map(this::getDictionary);
    }

    private Dictionary getDictionary(DictionaryPO dictionaryPO) {
        List<DictionaryItemPO> dictionaryItemPOList = this.dictionaryItemMapper.selectByDictionaryCode(dictionaryPO.getCode());
        return this.dictionaryTranslator.backward(Tuple.of(dictionaryPO, dictionaryItemPOList));
    }
}




