package mall.dictionary.service.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import mall.dictionary.api.enums.OrderType;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Dictionary
 *
 * @TableName dictionary
 */
@TableName(value = "dictionary")
@Data
public class DictionaryEntity implements Serializable {
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
     * Activity
     */
    @TableField(value = "activity")
    private Integer activity;

    /**
     * SortOrder
     */
    @TableField(value = "sort_order")
    private OrderType orderType;

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