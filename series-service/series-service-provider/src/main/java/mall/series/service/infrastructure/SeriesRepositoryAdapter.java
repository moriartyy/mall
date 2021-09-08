package mall.series.service.infrastructure;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import mall.infrastructure.repository.mybatis.MybatisRepositorySupport;
import mall.series.service.domain.Series;
import mall.series.service.domain.SeriesRepository;
import mall.service.transformation.ObjectTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author walter
 */
@Component
public class SeriesRepositoryAdapter extends MybatisRepositorySupport<Integer, Series, Series> implements SeriesRepository {

    @Autowired
    public SeriesRepositoryAdapter(BaseMapper<Series> mapper, ObjectTransformer objectTransformer) {
        super(mapper, objectTransformer);
    }
}
