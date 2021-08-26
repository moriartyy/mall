package mall.system.service.infrastructure.hibernate;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author walter
 */
public class RolePO {
    private Integer id;
    private String name;
    private String code;
    private String description;
    private Timestamp createdAt;
    private String createdBy;
    private Timestamp updatedAt;
    private String updatedBy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

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
