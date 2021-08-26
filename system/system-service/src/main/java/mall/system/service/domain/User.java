package mall.system.service.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * @author walter
 */
@Getter
@Setter
@Entity
@Table(name = "user0", schema = "system")
@org.hibernate.annotations.Table(appliesTo = "user0", comment = "用户表")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic
    @Column(name = "name", nullable = false, length = 45, columnDefinition = "varchar(100) default '' comment '用户名'")
    private String name;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<UserRoleRelation> roles;


}
