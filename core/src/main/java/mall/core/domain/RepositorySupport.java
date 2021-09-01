package mall.core.domain;

import lombok.AccessLevel;
import lombok.Getter;
import mall.common.exception.BusinessException;
import mall.core.domain.query.PageQuery;
import mall.core.domain.query.PageQueryResult;
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
public abstract class RepositorySupport<ID extends Serializable, E extends Entity<ID>, PO> implements Repository<ID, E> {

    private final ObjectTransformer objectTransformer;
    private final Class<E> entityClass;
    private final Class<PO> poClass;

    protected RepositorySupport(ObjectTransformer objectTransformer) {
        this.objectTransformer = objectTransformer;
        Class<?>[] generics = ClassUtils.resolveGenericTypes(getClass(), RepositorySupport.class);
        this.entityClass = (Class<E>) generics[1];
        this.poClass = (Class<PO>) generics[2];
    }

    @Override
    public void save(E entity) {
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
    public E get(ID id) {
        return getIfPresent(id)
                .orElseThrow(() -> {
                            String message = MessageFormat.format("There is no {0} with id ''{1}'' exist!", entityClass.getSimpleName(), id);
                            return new BusinessException(message);
                        }
                );
    }

    @Override
    public Optional<E> getIfPresent(ID id) {
        return doGetIfPresent(id).map(po -> this.objectTransformer.map(po, entityClass));
    }

    protected abstract Optional<PO> doGetIfPresent(ID id);

    @Override
    public PageQueryResult<E> findAll(PageQuery<E> query) {
        if (query.getPageIndex() < 0) {
            throw new IllegalArgumentException("pageIndex must greater than or equal to 0");
        }

        if (query.getPageSize() <= 0) {
            throw new IllegalArgumentException("pageSize must greater than 0");
        }

        return doPageQuery(query);
    }

    protected abstract PageQueryResult<E> doPageQuery(PageQuery<E> query);

    @Override
    public List<E> findAll(SimpleQuery<E> query) {

        if (query.getLimit() <= 0) {
            throw new IllegalArgumentException("limit must greater than 0");
        }

        return doSimpleQuery(query);
    }

    protected abstract List<E> doSimpleQuery(SimpleQuery<E> query);

    protected List<E> convert(List<PO> poList) {
        return getObjectTransformer().mapList(poList, getEntityClass());
    }

}
