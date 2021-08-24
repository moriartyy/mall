package mall.common.model;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author walter
 */
@ApiModel(description = "Sex")
@Getter
@RequiredArgsConstructor
public enum Sex implements EnumPlus {
    MALE("男", 1), FEMALE("女", 2);

    private final String displayName;
    private final Integer value;

}
