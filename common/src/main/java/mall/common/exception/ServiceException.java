package mall.common.exception;

import lombok.Getter;

/**
 * @author walter
 */
@Getter
public abstract class ServiceException extends RuntimeException {

    private Integer errorCode;

    protected ServiceException(String message) {
        super(message);
    }

    protected ServiceException(Integer errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }
}
