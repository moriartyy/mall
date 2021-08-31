package mall.core.context;

import lombok.Getter;
import lombok.Setter;
import mall.core.security.User;

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
