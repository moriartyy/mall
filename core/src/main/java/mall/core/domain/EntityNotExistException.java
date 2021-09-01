package mall.core.domain;

import mall.common.exception.BusinessException;

/**
 * @author walter
 */
public class EntityNotExistException extends BusinessException {

    public EntityNotExistException(Class<?> entityClass, Object id) {
        this(0, entityClass, id);
    }

    public EntityNotExistException(Integer errorCode, Class<?> entityClass, Object id) {
        super(errorCode, entityClass.getSimpleName() + "with id " + id + " not exist");
    }
}
