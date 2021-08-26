package mall.system.service.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author walter
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
