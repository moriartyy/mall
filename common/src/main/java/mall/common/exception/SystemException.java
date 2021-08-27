package mall.common.exception;

/**
 * @author walter
 */
public class SystemException extends ExceptionWithErrorCode {

    public SystemException(String message) {
        super(message);
    }

    public SystemException(Integer errorCode, String message) {
        super(errorCode, message);
    }
}
