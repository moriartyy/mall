package mall.dictionary.service.infrastructure.mapper;

import mall.common.enums.Activity;
import mall.dictionary.service.DictionaryServiceApplication;
import mall.dictionary.service.domain.Dictionary;
import mall.dictionary.service.enums.SortOrder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author walter
 */

@SpringBootTest(classes = DictionaryServiceApplication.class)
class DictionaryMapperTest {

    @Autowired
    private DictionaryMapper dictionaryMapper;

    @Test
    void selectOneByCode() {
        Dictionary orderTypeDic = new Dictionary();
        orderTypeDic.setCode("order-type");
        orderTypeDic.setDescription("Order Type");
        orderTypeDic.setActivity(Activity.ACTIVATED);
        orderTypeDic.setSortOrder(SortOrder.NATURAL);
        this.dictionaryMapper.insert(orderTypeDic);
        Dictionary orderTypeDic2 = this.dictionaryMapper.findById(orderTypeDic.getId()).get();
        assertEquals(orderTypeDic.getActivity(), orderTypeDic2.getActivity());
    }
}