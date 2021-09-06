package mall.system.service.infrastructure.jpa;

import mall.infrastructure.repository.jpa.JpaRepositorySupport;
import mall.service.transformation.ObjectTransformer;
import mall.system.service.domain.user.User;
import mall.system.service.domain.user.UserRepository;
import mall.system.service.infrastructure.jpa.dao.JpaUserDao;
import org.springframework.stereotype.Component;

/**
 * @author walter
 */
@Component
public class JpaUserRepository extends JpaRepositorySupport<Integer, User, User> implements UserRepository {

    public JpaUserRepository(JpaUserDao userDao, ObjectTransformer objectTransformer) {
        super(userDao, objectTransformer);
    }
}
