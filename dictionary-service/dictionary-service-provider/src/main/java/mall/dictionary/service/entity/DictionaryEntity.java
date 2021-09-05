package mall.dictionary.service.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
public class DictionaryEntity implements Serializable {
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
     *
     */
    private String activity;

    /**
     *
     */
    private String itemSortedBy;

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
