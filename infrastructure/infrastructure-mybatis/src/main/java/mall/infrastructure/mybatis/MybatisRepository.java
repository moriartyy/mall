package mall.infrastructure.mybatis;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import lombok.Getter;
import mall.core.domain.Entity;
import mall.core.domain.Repository;
import mall.core.infrastructure.Translator;

import java.util.Optional;

/**
 * @author walter
 */
@Getter
public abstract class MybatisRepository<ID, E extends Entity<ID>, PO> implements Repository<ID, E> {

    private final BaseMapper<PO> mapper;
    private final Translator<E, PO> translator;

    protected MybatisRepository(BaseMapper<PO> mapper, Translator<E, PO> translator) {
        this.mapper = mapper;
        this.translator = translator;
    }

    public void save(E entity) {
        if (entity.getId() == null) {
            this.mapper.insert(translator.forward(entity));
        } else {
            this.mapper.updateById(translator.forward(entity));
        }
    }

    public Optional<E> getIfPresent(Integer id) {
        return Optional.ofNullable(this.mapper.selectById(id)).map(translator::backward);
    }

    public boolean exist(Integer id) {
        return getIfPresent(id).isPresent();
    }

    public boolean delete(Integer id) {
        return this.mapper.deleteById(id) > 0;
    }
}
