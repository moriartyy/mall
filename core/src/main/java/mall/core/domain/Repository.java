package mall.core.domain;

import mall.common.exception.BusinessException;
import mall.core.util.ClassUtils;

import java.text.MessageFormat;
import java.util.Optional;

/**
 * @author walter
 */
public interface Repository<ID, E extends Entity<ID>> {

    /**
     * Get entity type
     *
     * @return entity type
     */
    default Class<E> getEntityType() {
        return ClassUtils.resolveGenericType(getClass(), 1);
    }

    /**
     * Get id type
     *
     * @return id type
     */
    default Class<ID> getIdType() {
        return ClassUtils.resolveGenericType(getClass(), 0);
    }

    /**
     * Save entity
     *
     * @param entity Entity to be saved
     */
    void save(E entity);

    /**
     * Get entity
     *
     * @param id entity id
     * @return entity with the given id
     * @throws BusinessException if entity not exist
     */
    default E get(ID id) {
        return getIfPresent(id)
                .orElseThrow(() -> {
                            String message = MessageFormat.format("{0} with id ''{1}'' is not exist", getEntityType().getSimpleName(), id);
                            return new BusinessException(message);
                        }
                );
    }

    /**
     * Get entity if present
     *
     * @param id entity id
     * @return Optional value contains instance entity or null
     */
    Optional<E> getIfPresent(ID id);

    /**
     * Check if entity exist with the given id
     *
     * @param id entity id
     * @return <code>true</code> if exist, otherwise <code>false</code>
     */
    boolean exist(ID id);

    /**
     * Delete entity with the given id
     *
     * @param id entity id
     * @return <code>true</code> if deleted, otherwise <code>false</code>
     */
    boolean delete(ID id);
}
