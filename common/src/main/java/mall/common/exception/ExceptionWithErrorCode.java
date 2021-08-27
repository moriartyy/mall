package mall.common.exception;

import lombok.Getter;

/**
 * @author walter
 */
@Getter
public abstract class ExceptionWithErrorCode extends RuntimeException {

    private int errorCode;

    protected ExceptionWithErrorCode(String message) {
        super(message);
    }

    protected ExceptionWithErrorCode(String message, Throwable cause) {
        super(message, cause);
    }

    protected ExceptionWithErrorCode(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    protected ExceptionWithErrorCode(int errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }
}
