package mall.data.dictionary.service.infrastructure.mysql.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @TableName DictionaryItem
 */
@TableName(value = "DictionaryItem")
@Data
public class DictionaryItemPO implements Serializable {
    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * DictionaryID
     */
    private Integer dictionaryId;

    /**
     * Title
     */
    private String title;

    /**
     * Value
     */
    private String value;

    /**
     * Sort
     */
    private Short sort;

    /**
     * Link
     */
    private String link;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}