package mall.system.service.infrastructure.jpa.dao;

import mall.infrastructure.repository.jpa.JpaDao;
import mall.system.service.domain.user.User;
import org.springframework.stereotype.Repository;

/**
 * @author walter
 */
@Repository
public interface JpaUserDao extends JpaDao<Integer, User> {
}
