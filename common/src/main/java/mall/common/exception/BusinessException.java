package mall.common.exception;


import mall.common.model.Error;

/**
 * @author walter
 */
public class BusinessException extends ServiceException {

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Error error) {
        super(message, error);
    }
}