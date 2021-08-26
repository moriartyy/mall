package mall.system.service.domain;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author walter
 */
@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void test() {

        User user = new User();
        user.setName("Peter");
        this.userRepository.save(user);
        this.userRepository.flush();
        Optional<User> r1 = this.userRepository.findById(user.getId());
        assertTrue(r1.isPresent());
        System.out.println(r1);
        this.userRepository.delete(r1.get());
        this.userRepository.flush();
        Optional<User> r2 = this.userRepository.findById(user.getId());
        assertFalse(r2.isPresent());
    }

    @Test
    void testCascade() {
        User user = new User();
        user.setName("Smith");
        user.setRoles(ImmutableList.of(new UserRoleRelation(user, 3), new UserRoleRelation(user, 7)));
        this.userRepository.saveAndFlush(user);

    }

}