package mall.service.security;

import lombok.Getter;
import lombok.Setter;

/**
 * @author walter
 */
@Getter
@Setter
public class User {
    private String name;
    private String realName;

    public User() {
    }

    public User(String name, String realName) {
        this.name = name;
        this.realName = realName;
    }

    public static final User ANONYMOUS = new User("guest", "unknown");
}
