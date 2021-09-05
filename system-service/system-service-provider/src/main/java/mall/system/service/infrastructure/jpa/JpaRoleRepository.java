package mall.system.service.infrastructure.jpa;

import mall.core.transformation.ObjectTransformer;
import mall.infrastructure.repository.jpa.JpaRepositorySupport;
import mall.system.service.domain.role.Role;
import mall.system.service.domain.role.RoleRepository;
import mall.system.service.infrastructure.jpa.dao.JpaRoleDao;
import org.springframework.stereotype.Component;

/**
 * @author walter
 */
@Component
public class JpaRoleRepository extends JpaRepositorySupport<Integer, Role, Role> implements RoleRepository {

    public JpaRoleRepository(JpaRoleDao roleDao, ObjectTransformer objectTransformer) {
        super(roleDao, objectTransformer);
    }
}
