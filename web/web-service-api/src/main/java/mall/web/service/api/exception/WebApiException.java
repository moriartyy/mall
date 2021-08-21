package mall.web.service.api.exception;

import lombok.Getter;
import mall.web.service.api.result.WebApiError;
import mall.web.service.api.result.WebApiStatus;

/**
 * @author walter
 */
@Getter
public class WebApiException extends RuntimeException {

    private WebApiStatus status;
    private WebApiError error;

    public WebApiException(WebApiStatus status) {
        super(status.getDescription());
        this.status = status;
    }

    public WebApiException(WebApiStatus status, String message) {
        super(message);
        this.status = status;
    }

    public WebApiException(WebApiStatus status, String message, WebApiError error) {
        super(message);
        this.status = status;
        this.error = error;
    }
}
