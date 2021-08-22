package mall.data.dictionary.service.infrastructure.mysql.entity;

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
    @TableField(value = "created_at")
    private LocalDateTime created_at;

    /**
     *
     */
    @TableField(value = "created_by")
    private String created_by;

    /**
     * Updated at when
     */
    @TableField(value = "updated_at")
    private LocalDateTime updated_at;

    /**
     * Updated by who
     */
    @TableField(value = "updated_by")
    private String updated_by;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}