package mall.core.domain;

import mall.core.domain.query.Criteria;
import mall.core.domain.query.Query;
import mall.core.domain.query.QueryResult;
import mall.core.domain.query.Sort;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * @author walter
 */
public interface Repository<ID extends Serializable, T extends Entity<ID>> {

    int NO_LIMIT = Integer.MAX_VALUE;

    void save(T entity);

    T get(ID id);

    Optional<T> getIfPresent(ID id);

    default boolean exist(ID id) {
        return getIfPresent(id).isPresent();
    }

    void delete(ID id);

    default Optional<T> findOne(Criteria criteria) {
        List<T> all = findAll(criteria, 1);
        return Optional.ofNullable(all.isEmpty() ? null : all.get(0));
    }

    default List<T> findAll(Criteria criteria) {
        return findAll(criteria, NO_LIMIT);
    }

    default List<T> findAll(Criteria criteria, int limit) {
        return findAll(criteria, 0, limit);
    }

    default List<T> findAll(Criteria criteria, int offset, int limit) {
        return findAll(criteria, Sort.NULL, offset, limit);
    }

    default List<T> findAll(Criteria criteria, Sort sort) {
        return findAll(criteria, sort, NO_LIMIT);
    }

    default List<T> findAll(Criteria criteria, Sort sort, int limit) {
        return findAll(criteria, sort, 0, limit);
    }

    default List<T> findAll(Criteria criteria, Sort sort, int offset, int limit) {
        Query<T> query = Query.<T>simple().criteria(criteria).sort(sort).offset(offset).limit(limit).build();
        return query(query).getItems();
    }

    QueryResult<T> query(Query<T> query);

}
