package mall.system.service.infrastructure.hibernate;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author walter
 */
@Getter
@Setter
@Entity
@Table(name = "user", schema = "system", catalog = "")
public class UserPO {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "name", nullable = false, length = 45)
    private String name;
    @Column(name = "real_name", nullable = false, length = 45)
    private String realName;
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
    @Column(name = "created_by", nullable = false, length = 45)
    private String createdBy;
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;
    @Column(name = "updated_by", nullable = false, length = 45)
    private String updatedBy;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPO userPO = (UserPO) o;
        return Objects.equals(id, userPO.id) && Objects.equals(name, userPO.name) && Objects.equals(realName, userPO.realName) && Objects.equals(createdAt, userPO.createdAt) && Objects.equals(createdBy, userPO.createdBy) && Objects.equals(updatedAt, userPO.updatedAt) && Objects.equals(updatedBy, userPO.updatedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, realName, createdAt, createdBy, updatedAt, updatedBy);
    }
}
