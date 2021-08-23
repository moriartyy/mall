package mall.infrastructure.mybatis;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.TableFieldInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfoHelper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Getter;
import mall.core.domain.Entity;
import mall.core.domain.Repository;
import mall.core.domain.query.Query;
import mall.core.domain.query.QueryResult;
import mall.core.translator.DefaultTranslator;
import mall.core.translator.Translator;
import mall.core.util.ClassUtils;
import mall.core.util.ObjectUtils;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author walter
 */
@Getter
public abstract class MybatisRepository<ID extends Serializable, E extends Entity<ID>, PO> implements Repository<ID, E> {

    private final BaseMapper<PO> mapper;
    private final Translator<E, PO> translator;
    private final Map<String, String> propertyToColumnMap;

    protected MybatisRepository(BaseMapper<PO> mapper) {
        this(mapper, new DefaultTranslator<>());
    }

    protected MybatisRepository(BaseMapper<PO> mapper, Translator<E, PO> translator) {
        this.mapper = mapper;
        this.translator = translator;
        this.propertyToColumnMap = TableInfoHelper.getTableInfo(ClassUtils.resolveGenericType(getClass(), 3))
                .getFieldList()
                .stream()
                .collect(Collectors.toMap(TableFieldInfo::getProperty, TableFieldInfo::getColumn));
    }

    @Override
    public void save(E entity) {
        PO po = translator.forward(entity);
        if (entity.getId() == null) {
            this.mapper.insert(po);
        } else {
            this.mapper.updateById(po);
        }
        ObjectUtils.copyProperties(po, entity);
    }

    @Override
    public Optional<E> getIfPresent(ID id) {
        return Optional.ofNullable(this.mapper.selectById(id)).map(translator::backward);
    }

    @Override
    public boolean exist(ID id) {
        return getIfPresent(id).isPresent();
    }

    @Override
    public void delete(ID id) {
        this.mapper.deleteById(id);
    }

    @Override
    public QueryResult<E> execute(Query query) {
        if (query.getOffset() < 0) {
            throw new IllegalArgumentException("offset must greater than or equal to 0");
        }

        if (query.getLimit() <= 0) {
            throw new IllegalArgumentException("limit must greater than 0");
        }

        Page<PO> paging = new Page<>(query.getOffset(), query.getLimit());
        QueryWrapper<PO> queryWrapper = new QueryWrapper<>();
        MybatisUtils.fillWithQuery(queryWrapper, query, propertyToColumnMap);
        if (query.getLimit() == NO_LIMIT && query.getOffset() == 0) {
            List<PO> poList = this.mapper.selectList(queryWrapper);
            return toQueryResult(poList.size(), poList);
        } else {
            Page<PO> page = this.mapper.selectPage(paging, queryWrapper);
            return toQueryResult(page.getTotal(), page.getRecords());
        }
    }

    protected QueryResult<E> toQueryResult(long total, List<PO> poList) {
        return QueryResult.<E>builder()
                .total(total)
                .items(poList.stream()
                        .map(this.translator::backward)
                        .collect(Collectors.toList()))
                .build();
    }
}
