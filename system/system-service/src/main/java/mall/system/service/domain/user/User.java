package mall.system.service.domain.user;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import mall.common.enums.Activity;
import mall.core.domain.AuditableEntity;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Walter
 */
@Entity
@Getter
@Setter
@Accessors(chain = true)
public class User extends AuditableEntity<Integer> {

    private String name;
    private String realName;
    private Activity activity;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<UserRole> roles = new ArrayList<>();

    public User addRole(int roleId) {
        this.roles.add(new UserRole().setRoleId(roleId));
        return this;
    }

    public User removeRole(int roleId) {
        this.roles = this.roles.stream().filter(r -> r.getRoleId() != roleId).collect(Collectors.toList());
        return this;
    }
}
