package mall.data.dictionary.service.infrastructure.mysql.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Dictionary
 *
 * @TableName dictionary
 */
@TableName(value = "dictionary")
@Data
public class DictionaryPO implements Serializable {
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * Code
     */
    @TableField(value = "code")
    private String code;

    /**
     * Description
     */
    @TableField(value = "description")
    private String description;

    /**
     * Created at when
     */
    @TableField(value = "created_at", fill = FieldFill.INSERT)
    private LocalDateTime createdAt;

    /**
     * Created by who
     */
    @TableField(value = "created_by", fill = FieldFill.INSERT)
    private String createdBy;

    /**
     * Updated at when
     */
    @TableField(value = "updated_at", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedAt;

    /**
     * Updated by who
     */
    @TableField(value = "updated_by", fill = FieldFill.INSERT_UPDATE)
    private String updatedBy;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}