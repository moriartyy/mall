package mall.service.domain;

import lombok.AccessLevel;
import lombok.Getter;
import mall.service.domain.query.PageQuery;
import mall.service.domain.query.PageQueryResult;
import mall.service.domain.query.SimpleQuery;
import mall.service.exception.BusinessException;
import mall.service.transformation.ObjectTransformer;
import mall.service.util.ClassUtils;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author walter
 */
@Getter(AccessLevel.PUBLIC)
@SuppressWarnings("unchecked")
public abstract class RepositorySupport<ID extends Serializable, E extends Entity<ID>, PO> implements Repository<ID, E> {

    private final ObjectTransformer objectTransformer;
    private final Class<E> entityClass;
    private final Class<PO> poClass;
    private final boolean isPoMappingNeeded;

    protected RepositorySupport(ObjectTransformer objectTransformer) {
        this.objectTransformer = objectTransformer;
        Class<?>[] generics = ClassUtils.resolveGenericTypes(getClass(), RepositorySupport.class);
        this.entityClass = (Class<E>) generics[1];
        this.poClass = (Class<PO>) generics[2];
        this.isPoMappingNeeded = poClass != entityClass;
    }

    @Override
    public void save(E entity) {
        PO po = convertToPO(entity);
        if (entity.isNew()) {
            doInsert(po);
        } else {
            doUpdate(po);
        }
    }

    private PO convertToPO(E entity) {
        return isPoMappingNeeded ? this.objectTransformer.map(entity, poClass) : (PO) entity;
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
        return doGetIfPresent(id).map(this::convertToEntity);
    }

    private E convertToEntity(PO po) {
        return isPoMappingNeeded ? this.objectTransformer.map(po, entityClass) : (E) po;
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
        return poList.stream().map(this::convertToEntity).collect(Collectors.toList());
    }

}
