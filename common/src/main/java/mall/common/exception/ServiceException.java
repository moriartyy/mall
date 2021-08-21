package mall.common.exception;

import lombok.Getter;
import mall.common.model.Error;

/**
 * @author walter
 */
@Getter
public abstract class ServiceException extends RuntimeException {

    private Error error;

    protected ServiceException(String message) {
        super(message);
    }

    protected ServiceException(String message, Error error) {
        super(message);
        this.error = error;
    }
}
