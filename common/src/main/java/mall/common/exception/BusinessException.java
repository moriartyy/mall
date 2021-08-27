package mall.common.exception;


/**
 * @author walter
 */
public class BusinessException extends ExceptionWithErrorCode {

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Integer errorCode, String message) {
        super(errorCode, message);
    }
}