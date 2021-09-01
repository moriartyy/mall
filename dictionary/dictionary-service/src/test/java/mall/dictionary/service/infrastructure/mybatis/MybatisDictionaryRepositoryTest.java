package mall.dictionary.service.infrastructure.mybatis;

import mall.common.enums.Activity;
import mall.dictionary.api.enums.SortOrder;
import mall.dictionary.service.DictionaryServiceApplication;
import mall.dictionary.service.domain.Dictionary;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * @author walter
 */
@SpringBootTest(classes = DictionaryServiceApplication.class)
class MybatisDictionaryRepositoryTest {

    @Autowired
    private MybatisDictionaryRepository mybatisDictionaryRepository;

    @Test
    void test() {
        Random random = new Random();
        Dictionary orderTypeDic = new Dictionary();
        orderTypeDic.setCode("order-type-" + random.nextInt(100000));
        orderTypeDic.setDescription("Order Type");
        orderTypeDic.setActivity(Activity.ACTIVATED);
        orderTypeDic.setSortOrder(SortOrder.NATURAL);
        this.mybatisDictionaryRepository.save(orderTypeDic);
        Dictionary orderTypeDic2 = this.mybatisDictionaryRepository.get(orderTypeDic.getId());
        assertEquals(orderTypeDic.getActivity(), orderTypeDic2.getActivity());

        this.mybatisDictionaryRepository.delete(orderTypeDic.getId());
        assertFalse(this.mybatisDictionaryRepository.exist(orderTypeDic.getId()));
    }
}