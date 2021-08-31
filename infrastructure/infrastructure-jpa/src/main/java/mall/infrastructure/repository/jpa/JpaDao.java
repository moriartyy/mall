package mall.infrastructure.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author walter
 */
public interface JpaDao<ID, T> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {
}
