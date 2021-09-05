package mall.system.service.domain.role;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author walter
 */
@SpringBootTest
class RoleRepositoryTest {

    @Autowired
    private RoleRepository repository;

    @Test
    public void test() {
        Random random = new Random();
        Role role = new Role();
        role.setName("admin" + random.nextInt(1000000)).setDescription("admin");
        repository.save(role);
        assertTrue(role.getId() != null);
    }

}