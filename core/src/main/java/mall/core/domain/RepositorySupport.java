package mall.core.domain;

import lombok.AccessLevel;
import lombok.Getter;
import mall.common.exception.BusinessException;
import mall.core.domain.query.Query;
import mall.core.domain.query.QueryResult;
import mall.core.domain.query.SimpleQuery;
import mall.core.transformation.ObjectTransformer;
import mall.core.util.ClassUtils;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;

/**
 * @author walter
 */
@Getter(AccessLevel.PUBLIC)
@SuppressWarnings("unchecked")
public abstract class RepositorySupport<ID extends Serializable, T extends Entity<ID>, PO> implements Repository<ID, T> {

    private final ObjectTransformer objectTransformer;
    private final Class<T> entityClass;
    private final Class<PO> poClass;

    protected RepositorySupport(ObjectTransformer objectTransformer) {
        this.objectTransformer = objectTransformer;
        Class<?>[] generics = ClassUtils.resolveGenericTypes(getClass(), RepositorySupport.class);
        this.entityClass = (Class<T>) generics[1];
        this.poClass = (Class<PO>) generics[2];
    }

    @Override
    public void save(T entity) {
        PO po = this.objectTransformer.map(entity, poClass);
        if (entity.isNew()) {
            doInsert(po);
        } else {
            doUpdate(po);
        }
    }

    protected abstract void doUpdate(PO po);

    protected abstract void doInsert(PO po);


    @Override
    public T get(ID id) {
        return getIfPresent(id)
                .orElseThrow(() -> {
                            String message = MessageFormat.format("There is no {0} with id ''{1}'' exist!", entityClass.getSimpleName(), id);
                            return new BusinessException(message);
                        }
                );
    }

    @Override
    public Optional<T> getIfPresent(ID id) {
        return doGetIfPresent(id).map(po -> this.objectTransformer.map(po, entityClass));
    }

    protected abstract Optional<PO> doGetIfPresent(ID id);

    @Override
    public QueryResult<T> query(Query<T> query) {
        assert query instanceof SimpleQuery;

        SimpleQuery<T> sq = (SimpleQuery<T>) query;

        if (sq.getOffset() < 0) {
            throw new IllegalArgumentException("offset must greater than or equal to 0");
        }

        if (sq.getLimit() <= 0) {
            throw new IllegalArgumentException("limit must greater than 0");
        }

        return doSimpleQuery(sq);
    }

    protected abstract QueryResult<T> doSimpleQuery(SimpleQuery<T> query);

    protected QueryResult<T> buildQueryResult(List<PO> poList, long total) {
        return QueryResult.<T>builder()
                .items(getObjectTransformer().mapList(poList, getEntityClass()))
                .total(total)
                .build();
    }
}
