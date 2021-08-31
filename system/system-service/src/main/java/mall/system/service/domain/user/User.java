package mall.system.service.domain.user;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import mall.core.domain.AuditableEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Walter
 */
@Getter
@Setter
@Accessors(chain = true)
public class User extends AuditableEntity<Integer> {

    private String name;
    private String realName;
    private List<UserRole> roles = new ArrayList<>();

    public void addRole(int roleId) {
        this.roles.add(new UserRole().setRoleId(roleId));
    }

    public void removeRole(int roleId) {
        this.roles = this.roles.stream().filter(r -> r.getRoleId() != roleId).collect(Collectors.toList());
    }
}
