package mall.system.service.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName user_roles
 */
@TableName(value = "user_roles")
@Data
public class UserRolesEntity implements Serializable {
    /**
     * User ID
     */
    private Integer userId;

    /**
     * Role ID
     */
    private Integer roleId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}