package mall.web.service.api.exception;

import mall.web.service.api.result.ApiError;
import mall.web.service.api.result.ApiStatus;

/**
 * @author walter
 */
public class BusinessException extends ApiException {

    public BusinessException(String message) {
        super(ApiStatus.BUSINESS_ERROR, message);
    }

    public BusinessException(String message, ApiError error) {
        super(ApiStatus.BUSINESS_ERROR, message, error);
    }
}