package mall.common.enums;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author walter
 */
@ApiModel(description = "Activity")
@Getter
@RequiredArgsConstructor
public enum Activity implements EnumPlus {
    ACTIVATED("已启用", 1), FORBIDDEN("已禁用", 0);

    private final String title;
    private final Integer value;

}
