package mall.dictionary.service.enums;

import lombok.Getter;
import mall.common.enums.EnumPlus;

/**
 * @author walter
 */
@Getter
public enum SortOrder implements EnumPlus {
    NATURAL("自然排序", 1), SPECIFIED("指定排序", 2);

    private final String title;
    private final Integer value;

    SortOrder(String title, int value) {
        this.title = title;
        this.value = value;
    }
}
