package mall.system.service.infrastructure.hibernate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author walter
 */
@Entity
@Table(name = "role", schema = "system", catalog = "")
public class RolePO {
    private Integer id;
    private String name;
    private String code;
    private String description;
    private Timestamp createdAt;
    private String createdBy;
    private Timestamp updatedAt;
    private String updatedBy;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "code", nullable = false, length = 45)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Basic
    @Column(name = "description", nullable = false, length = 300)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "created_at", nullable = false)
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Basic
    @Column(name = "created_by", nullable = false, length = 45)
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Basic
    @Column(name = "updated_at", nullable = false)
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Basic
    @Column(name = "updated_by", nullable = false, length = 45)
    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RolePO rolePO = (RolePO) o;
        return Objects.equals(id, rolePO.id) && Objects.equals(name, rolePO.name) && Objects.equals(code, rolePO.code) && Objects.equals(description, rolePO.description) && Objects.equals(createdAt, rolePO.createdAt) && Objects.equals(createdBy, rolePO.createdBy) && Objects.equals(updatedAt, rolePO.updatedAt) && Objects.equals(updatedBy, rolePO.updatedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, code, description, createdAt, createdBy, updatedAt, updatedBy);
    }
}
