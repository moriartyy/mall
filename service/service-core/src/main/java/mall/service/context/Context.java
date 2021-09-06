package mall.service.context;

import lombok.Getter;
import lombok.Setter;
import mall.service.security.User;

/**
 * @author walter
 */
@Getter
@Setter
public class Context {

    public static Context getCurrent() {
        return new Context();
    }

    private User user = User.ANONYMOUS;
}
