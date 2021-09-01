package mall.system.service.domain.user;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Embeddable;

/**
 * @author Walter
 */
@Getter
@Setter
@Accessors(chain = true)
@Embeddable
public class UserRole {

    private Integer roleId;

}
