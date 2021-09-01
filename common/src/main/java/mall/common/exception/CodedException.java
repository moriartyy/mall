package mall.common.exception;

import lombok.Getter;

/**
 * @author walter
 */
@Getter
public abstract class CodedException extends RuntimeException {

    private int errorCode;

    protected CodedException(String message) {
        super(message);
    }

    protected CodedException(String message, Throwable cause) {
        super(message, cause);
    }

    protected CodedException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    protected CodedException(int errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }
}
