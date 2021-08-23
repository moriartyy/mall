package mall.core.domain;

import mall.common.exception.BusinessException;
import mall.core.domain.query.Criteria;
import mall.core.domain.query.Query;
import mall.core.domain.query.QueryResult;
import mall.core.domain.query.Sort;
import mall.core.util.ClassUtils;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;

/**
 * @author walter
 */
public interface Repository<ID extends Serializable, E extends Entity<ID>> {

    int NO_LIMIT = Integer.MAX_VALUE;

    default Class<E> getEntityType() {
        return ClassUtils.resolveGenericType(getClass(), 1);
    }

    default Class<ID> getIdType() {
        return ClassUtils.resolveGenericType(getClass(), 0);
    }

    void save(E entity);

    default E get(ID id) {
        return getIfPresent(id)
                .orElseThrow(() -> {
                            String message = MessageFormat.format("{0} with id ''{1}'' is not exist!", getEntityType().getSimpleName(), id);
                            return new BusinessException(message);
                        }
                );
    }

    Optional<E> getIfPresent(ID id);

    boolean exist(ID id);

    void delete(ID id);

    default Optional<E> findOne(Criteria criteria) {
        List<E> all = findAll(criteria, 1);
        return Optional.ofNullable(all.isEmpty() ? null : all.get(0));
    }

    default List<E> findAll(Criteria criteria) {
        return findAll(criteria, NO_LIMIT);
    }

    default List<E> findAll(Criteria criteria, int limit) {
        return findAll(criteria, 0, limit);
    }

    default List<E> findAll(Criteria criteria, int offset, int limit) {
        return findAll(criteria, Sort.NULL, offset, limit);
    }

    default List<E> findAll(Criteria criteria, Sort sort) {
        return findAll(criteria, sort, NO_LIMIT);
    }

    default List<E> findAll(Criteria criteria, Sort sort, int limit) {
        return findAll(criteria, sort, 0, limit);
    }

    default List<E> findAll(Criteria criteria, Sort sort, int offset, int limit) {
        Query query = Query.builder().criteria(criteria).sort(sort).offset(offset).limit(limit).build();
        return execute(query).getItems();
    }

    QueryResult<E> execute(Query query);

}
