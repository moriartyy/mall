package mall.service.exception;


/**
 * @author walter
 */
public class BusinessException extends CodedException {

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Integer errorCode, String message) {
        super(errorCode, message);
    }
}
