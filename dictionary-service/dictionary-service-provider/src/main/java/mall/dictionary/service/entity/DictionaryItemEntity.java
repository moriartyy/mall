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
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * Name
     */
    private String name;

    /**
     * Value
     */
    private String value;

    /**
     * Order
     */
    private Short order;

    /**
     * Link
     */
    private String link;

    /**
     * Dictionary Code
     */
    private String dictionaryCode;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
