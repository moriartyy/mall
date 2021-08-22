package mall.data.dictionary.service.infrastructure.mysql.repository;

import lombok.RequiredArgsConstructor;
import mall.data.dictionary.service.domain.Dictionary;
import mall.data.dictionary.service.domain.DictionaryRepository;
import mall.data.dictionary.service.infrastructure.mysql.entity.DictionaryPO;
import mall.data.dictionary.service.infrastructure.mysql.mapper.DictionaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


/**
 * @author Walter
 */
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MysqlDictionaryRepository implements DictionaryRepository {

    private final DictionaryMapper dictionaryMapper;

    @Override
    public void save(Dictionary dictionary) {
        DictionaryPO dictionaryPO = toPO(dictionary);
        if (dictionary.getId() == null) {
            this.dictionaryMapper.insert(dictionaryPO);
        } else {
            this.dictionaryMapper.updateById(dictionaryPO);
        }
    }

    @Override
    public Optional<Dictionary> getIfPresent(Integer id) {
        return Optional.ofNullable(this.dictionaryMapper.selectById(id)).map(this::fromPO);
    }

    @Override
    public boolean exist(Integer id) {
        return getIfPresent(id).isPresent();
    }

    @Override
    public boolean delete(Integer id) {
        return this.dictionaryMapper.deleteById(id) > 0;
    }

    private DictionaryPO toPO(Dictionary dictionary) {
        throw new UnsupportedOperationException();
    }

    private Dictionary fromPO(DictionaryPO dictionaryPO) {
        throw new UnsupportedOperationException();
    }
}




