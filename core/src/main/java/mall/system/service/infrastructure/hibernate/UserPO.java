package mall.system.service.infrastructure.hibernate;

import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author walter
 */
public class UserPO {
    private Integer id;
    private String name;
    private String realName;
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

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
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
        UserPO userPO = (UserPO) o;
        return Objects.equals(id, userPO.id) && Objects.equals(name, userPO.name) && Objects.equals(realName, userPO.realName) && Objects.equals(createdAt, userPO.createdAt) && Objects.equals(createdBy, userPO.createdBy) && Objects.equals(updatedAt, userPO.updatedAt) && Objects.equals(updatedBy, userPO.updatedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, realName, createdAt, createdBy, updatedAt, updatedBy);
    }
}
