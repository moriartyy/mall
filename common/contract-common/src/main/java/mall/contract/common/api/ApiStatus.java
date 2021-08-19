package mall.contract.common.api;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author walter
 */
@Getter
@RequiredArgsConstructor
public enum ApiStatus {
    OK(200, "OK"),
    UNAUTHORIZED(300, "UNAUTHORIZED"),
    BAD_REQUEST(400, "BAD_REQUEST"),
    MISSING_PARAMETER(401, "MISSING_PARAMETER"),
    INVALID_PARAMETER(402, "INVALID_PARAMETER_TYPE"),
    INVALID_PARAMETER_FORMAT(403, "INVALID_PARAMETER_FORMAT"),
    INVALID_PARAMETER_TYPE(404, "INVALID_PARAMETER_TYPE"),
    INTERNAL_ERROR(500, "INTERNAL_ERROR"),
    ;

    @JsonValue
    private final Integer code;
    private final String description;

}
