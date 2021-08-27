package mall.webservice.core.exception;

/**
 * @author walter
 */
public class MissingParameterException extends RuntimeException {

    public MissingParameterException(String message) {
        super(message);
    }

    public MissingParameterException(String message, Throwable cause) {
        super(message, cause);
    }
}
