package mall.common.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author walter
 */
@Getter
@RequiredArgsConstructor
public enum Sex implements EnumPlus {
    MALE("男", 1), FEMALE("女", 2);

    private final String displayName;
    private final Integer value;

}
