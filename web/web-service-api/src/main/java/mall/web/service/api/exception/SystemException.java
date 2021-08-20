package mall.web.service.api.exception;

import mall.web.service.api.result.ApiError;
import mall.web.service.api.result.ApiStatus;

/**
 * @author walter
 */
public class SystemException extends ApiException {

    public SystemException(String message) {
        super(ApiStatus.SYSTEM_ERROR, message);
    }

    public SystemException(String message, ApiError error) {
        super(ApiStatus.SYSTEM_ERROR, message, error);
    }
}
