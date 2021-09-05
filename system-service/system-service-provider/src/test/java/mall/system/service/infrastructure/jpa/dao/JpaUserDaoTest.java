package mall.system.service.infrastructure.jpa.dao;

import mall.system.service.domain.user.User;
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
class JpaUserDaoTest {


    @Autowired
    private JpaUserDao userDao;

    @Test
    void test() {

        User user = new User();
        user.setName("Peter");
        this.userDao.save(user);
        this.userDao.flush();
        Optional<User> r1 = this.userDao.findById(user.getId());
        assertTrue(r1.isPresent());
        System.out.println(r1);
        this.userDao.delete(r1.get());
        this.userDao.flush();
        Optional<User> r2 = this.userDao.findById(user.getId());
        assertFalse(r2.isPresent());
    }

    @Test
    void testEmbedded() {
        User user = new User();
        user.setName("Smith");
        user.addRole(3);
        user.addRole(5);
        this.userDao.saveAndFlush(user);
        System.out.println("-------user1--------");
        System.out.println(user);

        User user2 = this.userDao.getOne(user.getId());
        System.out.println("-------user2--------");
        System.out.println(user2);
        user2.removeRole(3);
        user2.addRole(7);
        this.userDao.saveAndFlush(user2);

        User user3 = this.userDao.getOne(user.getId());
        System.out.println("-------user3--------");
        System.out.println(user3);
    }

}