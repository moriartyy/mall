package mall.system.service.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName role_privileges
 */
@TableName(value = "role_privileges")
@Data
public class RolePrivilegesEntity implements Serializable {
    /**
     *
     */
    private Integer roleId;

    /**
     *
     */
    private Integer privilegeId;

    /**
     * Privilege Code
     */
    private String privilegeCode;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}