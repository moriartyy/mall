package mall.data.dictionary.service.infrastructure.mysql.mapper;

import mall.core.util.JsonUtils;
import mall.data.dictionary.service.infrastructure.mysql.entity.DictionaryPO;
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
//        DictionaryPO dicOrderType = new DictionaryPO();
//        dicOrderType.setCode("order-type");
//        dicOrderType.setDescription("Order Type");
//
//        this.dictionaryMapper.insert(dicOrderType);
//        System.out.println(dicOrderType.getId());
//
//        DictionaryPO dicSex = new DictionaryPO();
//        dicSex.setCode("sex");
//        dicSex.setDescription("Sex");
//
//        this.dictionaryMapper.insert(dicSex);
//        System.out.println(dicSex.getId());

        DictionaryPO dictionaryPO = this.dictionaryMapper.selectOneByCreatedBy("张三");
        System.out.println(JsonUtils.serializeToString(dictionaryPO));

    }
}