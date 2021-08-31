package mall.system.service.infrastructure.jpa;

import mall.core.transformation.ObjectTransformer;
import mall.infrastructure.repository.jpa.JpaRepositorySupport;
import mall.system.service.domain.user.User;
import mall.system.service.infrastructure.jpa.dao.JpaUserDao;
import org.springframework.stereotype.Component;

/**
 * @author walter
 */
@Component
public class JpaUserRepository extends JpaRepositorySupport<Integer, User, User> {

    public JpaUserRepository(JpaUserDao userDao, ObjectTransformer objectTransformer) {
        super(userDao, objectTransformer);
    }
}
