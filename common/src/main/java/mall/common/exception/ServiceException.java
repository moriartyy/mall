package mall.common.exception;

import lombok.Getter;

/**
 * @author walter
 */
@Getter
public abstract class ServiceException extends RuntimeException {

    private int errorCode;

    protected ServiceException(String message) {
        super(message);
    }

    protected ServiceException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
}
