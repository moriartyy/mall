package mall.web.service.api.exception;

import lombok.Getter;
import mall.web.service.api.result.ApiError;
import mall.web.service.api.result.ApiStatus;

/**
 * @author walter
 */
@Getter
public class ApiException extends RuntimeException {

    private ApiStatus status;
    private ApiError error;

    public ApiException(ApiStatus status) {
        super(status.getDescription());
        this.status = status;
    }

    public ApiException(ApiStatus status, String message) {
        super(message);
        this.status = status;
    }

    public ApiException(ApiStatus status, String message, ApiError error) {
        super(message);
        this.status = status;
        this.error = error;
    }
}
