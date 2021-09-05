package mall.system.service.infrastructure.jpa.dao;

import mall.infrastructure.repository.jpa.JpaDao;
import mall.system.service.domain.role.Role;
import org.springframework.stereotype.Repository;

/**
 * @author walter
 */
@Repository
public interface JpaRoleDao extends JpaDao<Integer, Role> {
}
