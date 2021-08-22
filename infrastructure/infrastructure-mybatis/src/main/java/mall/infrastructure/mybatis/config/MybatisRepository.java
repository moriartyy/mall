package mall.infrastructure.mybatis.config;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import mall.core.domain.Entity;
import mall.core.domain.Repository;

import java.util.Optional;

/**
 * @author walter
 */
public interface MybatisRepository<ID, E extends Entity<ID>> extends Repository<ID, E>, BaseMapper<E> {

    default void save(E entity) {
        if (entity.getId() == null) {
            this.insert(entity);
        } else {
            this.updateById(entity);
        }
    }

    default Optional<E> getIfPresent(Integer id) {
        return Optional.ofNullable(selectById(id));
    }

    default boolean exist(Integer id) {
        return getIfPresent(id).isPresent();
    }

    default boolean delete(Integer id) {
        return this.deleteById(id) > 0;
    }

}
