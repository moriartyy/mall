package mall.web.service.api.result;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author walter
 */
@Getter
@RequiredArgsConstructor
public enum WebApiStatus {
    OK(200, "OK"),
    UNAUTHORIZED(300, "UNAUTHORIZED"),
    BAD_REQUEST(400, "BAD_REQUEST"),
    MISSING_PARAMETER(401, "MISSING_PARAMETER"),
    INVALID_PARAMETER(402, "INVALID_PARAMETER_TYPE"),
    INVALID_PARAMETER_FORMAT(403, "INVALID_PARAMETER_FORMAT"),
    INVALID_PARAMETER_TYPE(404, "INVALID_PARAMETER_TYPE"),
    BUSINESS_ERROR(500, "BUSINESS_ERROR"),
    SYSTEM_ERROR(600, "SYSTEM_ERROR"),
    UNKNOWN_ERROR(700, "UNKNOWN_ERROR"),
    ;

    @JsonValue
    private final Integer code;
    private final String description;

}
