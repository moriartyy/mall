package mall.dictionary.service.infrastructure.mybatis;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import mall.dictionary.service.domain.Dictionary;
import mall.dictionary.service.domain.DictionaryRepository;
import mall.infrastructure.repository.mybatis.MybatisRepositorySupport;
import mall.service.transformation.ObjectTransformer;
import org.springframework.stereotype.Component;

/**
 * @author walter
 */
@Component
public class MybatisDictionaryRepository extends MybatisRepositorySupport<Integer, Dictionary, Dictionary> implements DictionaryRepository {

    protected MybatisDictionaryRepository(BaseMapper<Dictionary> mapper, ObjectTransformer objectTransformer) {
        super(mapper, objectTransformer);
    }
}
