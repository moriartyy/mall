package mall.dictionary.api.enums;

import lombok.Getter;
import mall.common.enums.EnumPlus;

/**
 * @author walter
 */
@Getter
public enum OrderType implements EnumPlus {
    NATURAL("自然排序", 1), SPECIFIED("指定排序", 2);

    private final String title;
    private final Integer value;

    OrderType(String title, int value) {
        this.title = title;
        this.value = value;
    }
}
