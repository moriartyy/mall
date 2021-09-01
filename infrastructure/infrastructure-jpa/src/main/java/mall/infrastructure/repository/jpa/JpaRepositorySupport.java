package mall.infrastructure.repository.jpa;

import mall.core.domain.Entity;
import mall.core.domain.EntityNotExistException;
import mall.core.domain.Persistable;
import mall.core.domain.RepositorySupport;
import mall.core.domain.query.PageQuery;
import mall.core.domain.query.PageQueryResult;
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
    protected List<T> doSimpleQuery(SimpleQuery<T> query) {
        Specification<P> spec = JpaUtils.toSpecification(query.getCriteria());
        if (query.getLimit() == NO_LIMIT) {
            List<P> poList = this.dao.findAll(spec);
            return convert(poList);
        } else {
            Pageable pageable = PageRequest.of(0, query.getLimit(), JpaUtils.toJpaSort(query.getSort()));
            Page<P> page = this.dao.findAll(spec, pageable);
            return convert(page.getContent());
        }
    }

    @Override
    protected PageQueryResult<T> doPageQuery(PageQuery<T> query) {
        Specification<P> spec = JpaUtils.toSpecification(query.getCriteria());
        Pageable pageable = PageRequest.of(query.getPageIndex(), query.getPageSize(), JpaUtils.toJpaSort(query.getSort()));
        Page<P> page = this.dao.findAll(spec, pageable);
        return query.createResult()
                .totalPages(page.getTotalPages())
                .totalItems(page.getTotalElements())
                .items(convert(page.getContent()))
                .build();
    }

}
