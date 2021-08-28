package mall.dictionary.service.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * DictionaryItem
 *
 * @TableName dictionary_item
 */
@TableName(value = "dictionary_item")
@Data
public class DictionaryItemEntity implements Serializable {
    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * DictionaryCode
     */
    @TableField(value = "dictionary_code")
    private String dictionaryCode;

    /**
     * Name
     */
    @TableField(value = "name")
    private String name;

    /**
     * Value
     */
    @TableField(value = "value")
    private String value;

    /**
     * Sort
     */
    @TableField(value = "sort")
    private Short sort;

    /**
     * Link
     */
    @TableField(value = "link")
    private String link;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}