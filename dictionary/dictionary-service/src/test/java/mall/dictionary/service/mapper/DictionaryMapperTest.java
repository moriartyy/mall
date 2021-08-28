package mall.dictionary.service.mapper;

import mall.dictionary.service.entity.DictionaryEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author walter
 */
@SpringBootTest
class DictionaryMapperTest {

    @Autowired
    private DictionaryMapper dictionaryMapper;

    @Test
    void selectOneByCode() {
        DictionaryEntity dicOrderType = new DictionaryEntity();
        dicOrderType.setCode("order-type");
        dicOrderType.setDescription("Order Type");

        this.dictionaryMapper.insert(dicOrderType);
        System.out.println(dicOrderType.getId());

        DictionaryEntity dicSex = new DictionaryEntity();
        dicSex.setCode("sex");
        dicSex.setDescription("Sex");

        this.dictionaryMapper.insert(dicSex);
        System.out.println(dicSex.getId());

    }
}