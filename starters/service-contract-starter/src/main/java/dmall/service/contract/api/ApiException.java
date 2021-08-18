package dmall.service.contract.api;

import lombok.Getter;

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

    public ApiException(String message) {
        super(message);
        this.status = ApiStatus.INTERNAL_ERROR;
    }

    public ApiException(String message, ApiError error) {
        super(message);
        this.status = ApiStatus.INTERNAL_ERROR;
        this.error = error;
    }

    public ApiException(ApiStatus status, ApiError error) {
        super(status.getDescription());
        this.status = status;
        this.error = error;
    }
}
