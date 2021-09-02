package mall.system.service.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * User
 *
 * @TableName user
 */
@TableName(value = "user")
@Data
public class UserEntity implements Serializable {
    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * Name
     */
    private String name;

    /**
     * Real Name
     */
    private String realName;

    /**
     * Activity
     */
    private String activity;

    /**
     * Created at when
     */
    private LocalDateTime createdAt;

    /**
     * Created by who
     */
    private String createdBy;

    /**
     * Updated at when
     */
    private LocalDateTime updatedAt;

    /**
     * Updated by who
     */
    private String updatedBy;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}