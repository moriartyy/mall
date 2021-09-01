package mall.core.domain;

import mall.core.domain.query.*;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * @author walter
 */
public interface Repository<ID extends Serializable, E extends Entity<ID>> {

    int NO_LIMIT = Integer.MAX_VALUE;

    void save(E entity);

    E get(ID id);

    Optional<E> getIfPresent(ID id);

    default boolean exist(ID id) {
        return getIfPresent(id).isPresent();
    }

    void delete(ID id);

    default Optional<E> findOne(Criteria criteria) {
        List<E> all = findAll(criteria, 1);
        return Optional.ofNullable(all.isEmpty() ? null : all.get(0));
    }

    default List<E> findAll(Criteria criteria) {
        return findAll(criteria, NO_LIMIT);
    }

    default List<E> findAll(Criteria criteria, int limit) {
        return findAll(criteria, Sort.NULL, limit);
    }


    default List<E> findAll(Criteria criteria, Sort sort) {
        return findAll(criteria, sort, NO_LIMIT);
    }

    default List<E> findAll(Criteria criteria, Sort sort, int limit) {
        SimpleQuery<E> query = QueryBuilders.<E>simple().criteria(criteria).sort(sort).limit(limit).build();
        return findAll(query);
    }

    List<E> findAll(SimpleQuery<E> query);

    PageQueryResult<E> findAll(PageQuery<E> query);

}
