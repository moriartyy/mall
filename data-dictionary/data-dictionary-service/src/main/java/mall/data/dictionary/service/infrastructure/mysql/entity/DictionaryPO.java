package mall.data.dictionary.service.infrastructure.mysql.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @TableName Dictionary
 */
@TableName(value = "Dictionary")
@Data
public class DictionaryPO implements Serializable {
    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * Code
     */
    private String code;

    /**
     * Description
     */
    private String description;

    /**
     * Created at when
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createdAt;

    /**
     *
     */
    @TableField(fill = FieldFill.INSERT)
    private String createdBy;

    /**
     * Updated at when
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedAt;

    /**
     * Updated by who
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updatedBy;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}