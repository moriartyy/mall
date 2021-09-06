package mall.dictionary.service.infrastructure.mybatis;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import mall.dictionary.service.domain.DictionaryItem;
import mall.dictionary.service.domain.DictionaryItemRepository;
import mall.infrastructure.repository.mybatis.MybatisRepositorySupport;
import mall.service.transformation.ObjectTransformer;
import org.springframework.stereotype.Component;

/**
 * @author walter
 */
@Component
public class MybatisDictionaryItemRepository extends MybatisRepositorySupport<Integer, DictionaryItem, DictionaryItem> implements DictionaryItemRepository {

    protected MybatisDictionaryItemRepository(BaseMapper<DictionaryItem> mapper, ObjectTransformer objectTransformer) {
        super(mapper, objectTransformer);
    }
}
