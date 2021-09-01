package mall.infrastructure.repository.jpa;

import mall.core.domain.Entity;
import mall.core.domain.EntityNotExistException;
import mall.core.domain.Persistable;
import mall.core.domain.RepositorySupport;
import mall.core.domain.query.QueryResult;
import mall.core.domain.query.SimpleQuery;
import mall.core.transformation.ObjectTransformer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * @author walter
 */
public abstract class JpaRepositorySupport<ID extends Serializable, T extends Entity<ID>, P extends Persistable<ID>> extends RepositorySupport<ID, T, P> {

    private final JpaDao<ID, P> dao;

    public JpaRepositorySupport(JpaDao<ID, P> dao, ObjectTransformer objectTransformer) {
        super(objectTransformer);
        this.dao = dao;
    }

    @Override
    protected void doInsert(P persistable) {
        this.dao.saveAndFlush(persistable);
    }

    @Override
    protected void doUpdate(P persistable) {
        P base = this.dao.findById(persistable.getId()).orElseThrow(() -> new EntityNotExistException(getEntityClass(), persistable.getId()));
        getObjectTransformer().map(persistable, base);
        this.dao.saveAndFlush(base);
    }

    @Override
    protected Optional<P> doGetIfPresent(ID id) {
        return this.dao.findById(id);
    }

    @Override
    public boolean exist(ID id) {
        return this.dao.existsById(id);
    }

    @Override
    public void delete(ID id) {
        this.dao.deleteById(id);
        this.dao.flush();
    }

    @Override
    protected QueryResult<T> doSimpleQuery(SimpleQuery<T> query) {
        Specification<P> spec = JpaUtils.resolveSpecification(query);
        if (query.getLimit() == NO_LIMIT) {
            List<P> entityList = this.dao.findAll(spec);
            return buildQueryResult(entityList, entityList.size());
        } else {
            Pageable pageable = PageRequest.of(query.getOffset() / query.getLimit(), query.getLimit(), JpaUtils.resolveSort(query));
            Page<P> page = this.dao.findAll(spec, pageable);
            return buildQueryResult(page.getContent(), page.getTotalElements());
        }
    }

}
