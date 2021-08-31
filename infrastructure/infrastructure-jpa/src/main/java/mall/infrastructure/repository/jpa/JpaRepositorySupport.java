package mall.infrastructure.repository.jpa;

import mall.core.domain.Entity;
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
public abstract class JpaRepositorySupport<ID extends Serializable, T extends Entity<ID>, PO> extends RepositorySupport<ID, T, PO> {

    private final JpaDao<ID, PO> dao;

    public JpaRepositorySupport(JpaDao<ID, PO> dao, ObjectTransformer objectTransformer) {
        super(objectTransformer);
        this.dao = dao;
    }

    @Override
    protected void doInsert(PO entity) {
        this.dao.saveAndFlush(entity);
    }

    @Override
    protected void doUpdate(PO entity) {
        this.dao.saveAndFlush(entity);
    }

    @Override
    protected Optional<PO> doGetIfPresent(ID id) {
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
        Specification<PO> spec = JpaUtils.resolveSpecification(query);
        if (query.getLimit() == NO_LIMIT) {
            List<PO> entityList = this.dao.findAll(spec);
            return buildQueryResult(entityList, entityList.size());
        } else {
            Pageable pageable = PageRequest.of(query.getOffset() / query.getLimit(), query.getLimit(), JpaUtils.resolveSort(query));
            Page<PO> page = this.dao.findAll(spec, pageable);
            return buildQueryResult(page.getContent(), page.getTotalElements());
        }
    }

}
