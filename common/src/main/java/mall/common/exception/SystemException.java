package mall.common.exception;

import mall.common.model.Error;

/**
 * @author walter
 */
public class SystemException extends ServiceException {

    public SystemException(String message) {
        super(message);
    }

    public SystemException(String message, Error error) {
        super(message, error);
    }
}
