package mall.data.dictionary.service.infrastructure.mysql;

import lombok.RequiredArgsConstructor;
import mall.data.dictionary.service.domain.Dictionary;
import mall.data.dictionary.service.domain.DictionaryRepository;
import mall.data.dictionary.service.infrastructure.mysql.entity.DictionaryPO;
import mall.data.dictionary.service.infrastructure.mysql.mapper.DictionaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @author Walter
 */
@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MysqlDictionaryRepository implements DictionaryRepository {

    private final DictionaryMapper dictionaryMapper;

    @Override
    public Dictionary getByCode(String code) {
        DictionaryPO dictionaryPO = this.dictionaryMapper.selectOneByCode(code);

        return null;
    }
}




