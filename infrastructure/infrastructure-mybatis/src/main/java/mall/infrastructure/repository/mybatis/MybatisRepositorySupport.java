package mall.infrastructure.repository.mybatis;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.TableFieldInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfoHelper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Getter;
import mall.service.domain.Entity;
import mall.service.domain.RepositorySupport;
import mall.service.domain.query.Criteria;
import mall.service.domain.query.PageQuery;
import mall.service.domain.query.PageQueryResult;
import mall.service.domain.query.SimpleQuery;
import mall.service.transformation.ObjectTransformer;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author walter
 */
@Getter
public abstract class MybatisRepositorySupport<ID extends Serializable, E extends Entity<ID>, PO> extends RepositorySupport<ID, E, PO> {

    private final BaseMapper<PO> mapper;
    private final Map<String, String> propertyToColumnMap;

    protected MybatisRepositorySupport(BaseMapper<PO> mapper, ObjectTransformer objectTransformer) {
        super(objectTransformer);
        this.mapper = mapper;
        this.propertyToColumnMap = TableInfoHelper.getTableInfo(getPoClass())
                .getFieldList()
                .stream()
                .collect(Collectors.toMap(TableFieldInfo::getProperty, TableFieldInfo::getColumn));
    }

    @Override
    public void delete(ID id) {
        this.mapper.deleteById(id);
    }

    @Override
    public void deleteAll(Criteria criteria) {
        QueryWrapper<PO> queryWrapper = new QueryWrapper<>();
        MybatisUtils.fillWithCriteria(queryWrapper, criteria, propertyToColumnMap);
        this.mapper.delete(queryWrapper);
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
    protected List<E> doSimpleQuery(SimpleQuery<E> query) {
        QueryWrapper<PO> queryWrapper = new QueryWrapper<>();
        MybatisUtils.fillWithCriteria(queryWrapper, query.getCriteria(), propertyToColumnMap);
        MybatisUtils.fillSort(queryWrapper, query.getSort(), propertyToColumnMap);
        if (query.getLimit() == NO_LIMIT) {
            List<PO> poList = this.mapper.selectList(queryWrapper);
            return convert(poList);
        } else {
            Page<PO> paging = new Page<>(0, query.getLimit());
            Page<PO> page = this.mapper.selectPage(paging, queryWrapper);
            return convert(page.getRecords());
        }
    }

    @Override
    protected PageQueryResult<E> doPageQuery(PageQuery<E> query) {
        QueryWrapper<PO> queryWrapper = new QueryWrapper<>();
        MybatisUtils.fillWithCriteria(queryWrapper, query.getCriteria(), propertyToColumnMap);
        MybatisUtils.fillSort(queryWrapper, query.getSort(), propertyToColumnMap);
        Page<PO> paging = new Page<>(query.getPageIndex() + 1, query.getPageSize());
        Page<PO> page = this.mapper.selectPage(paging, queryWrapper);
        return query.createResult()
                .totalPages(page.getPages())
                .totalItems(page.getTotal())
                .items(convert(page.getRecords()))
                .build();

    }

}
