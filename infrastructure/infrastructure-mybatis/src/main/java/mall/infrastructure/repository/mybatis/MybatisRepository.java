package mall.infrastructure.repository.mybatis;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.TableFieldInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfoHelper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Getter;
import mall.core.domain.Entity;
import mall.core.domain.RepositorySupport;
import mall.core.domain.query.QueryResult;
import mall.core.domain.query.SimpleQuery;
import mall.core.transformation.ObjectTransformer;
import mall.core.util.ClassUtils;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author walter
 */
@Getter
public class MybatisRepository<ID extends Serializable, E extends Entity<ID>, PO> extends RepositorySupport<ID, E, PO> {

    private final BaseMapper<PO> mapper;
    private final Map<String, String> propertyToColumnMap;

    @SuppressWarnings("unchecked")
    protected MybatisRepository(BaseMapper<PO> mapper, ObjectTransformer objectTransformer) {
        super(objectTransformer);
        this.mapper = mapper;
        this.propertyToColumnMap = TableInfoHelper.getTableInfo(ClassUtils.resolveGenericType(getClass(), 3))
                .getFieldList()
                .stream()
                .collect(Collectors.toMap(TableFieldInfo::getProperty, TableFieldInfo::getColumn));
    }

    @Override
    public void delete(ID id) {
        this.mapper.deleteById(id);
    }

    @Override
    protected void doUpdate(PO po) {
        this.mapper.updateById(po);
    }

    @Override
    protected void doInsert(PO po) {
        this.mapper.insert(po);
    }

    @Override
    protected Optional<PO> doGetIfPresent(ID id) {
        return Optional.ofNullable(this.mapper.selectById(id));
    }

    @Override
    protected QueryResult<E> doSimpleQuery(SimpleQuery<E> query) {
        QueryWrapper<PO> queryWrapper = new QueryWrapper<>();
        MybatisUtils.fillWithQuery(queryWrapper, query, propertyToColumnMap);
        if (query.getLimit() == NO_LIMIT && query.getOffset() == 0) {
            List<PO> poList = this.mapper.selectList(queryWrapper);
            return buildQueryResult(poList, poList.size());
        } else {
            Page<PO> paging = new Page<>(query.getOffset() / query.getLimit(), query.getLimit());
            Page<PO> page = this.mapper.selectPage(paging, queryWrapper);
            return buildQueryResult(page.getRecords(), page.getTotal());
        }
    }
}
