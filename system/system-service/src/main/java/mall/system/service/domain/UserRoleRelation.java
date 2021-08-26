package mall.system.service.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author walter
 */
@Getter
@Setter
@Entity
@Embeddable
@Table(name = "user_role_relation0", schema = "system", catalog = "")
public class UserRoleRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @ManyToOne
    private User user;
    @Basic
    @Column(name = "role_id", nullable = false)
    private Integer roleId;


    public UserRoleRelation() {
    }

    public UserRoleRelation(User user, Integer roleId) {
        this.user = user;
        this.roleId = roleId;
    }
}
