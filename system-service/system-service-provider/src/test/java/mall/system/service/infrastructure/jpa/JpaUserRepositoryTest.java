package mall.system.service.infrastructure.jpa;

import mall.common.enums.Activity;
import mall.common.util.JsonUtils;
import mall.system.service.domain.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * @author walter
 */
@SpringBootTest()
class JpaUserRepositoryTest {

    @Autowired
    private JpaUserRepository repository;

    @Test
    void test() {
        Random random = new Random();
        User user = new User()
                .setName("Peter" + random.nextInt(1000000))
                .setRealName("Peter Smith")
                .setActivity(Activity.ACTIVATED)
                .addRole(3)
                .addRole(6);
        print(user);
        this.repository.save(user);
        User user2 = this.repository.get(user.getId());
        print(user2);
        assertEquals(user.getName(), user2.getName());
        assertEquals(user.getActivity(), user2.getActivity());
        assertEquals(user.getRoles().size(), user2.getRoles().size());

        User user2_1 = new User();
        user2_1.setId(user2.getId());
        user2_1.setName("Tome");
        this.repository.save(user2_1);
        print(this.repository.get(user.getId()));

        this.repository.delete(user2.getId());
        assertFalse(this.repository.exist(user2.getId()));
    }

    private void print(Object obj) {
        System.out.println(JsonUtils.serializeToString(obj));
    }

}