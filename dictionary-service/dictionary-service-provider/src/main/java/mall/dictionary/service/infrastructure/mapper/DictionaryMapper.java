package mall.dictionary.service.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import mall.dictionary.service.domain.Dictionary;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

/**
 * @author walter
 */
public interface DictionaryMapper extends BaseMapper<Dictionary> {

    Dictionary selectOneByCode(@Param("code") String code);

    default Optional<Dictionary> findById(Integer id) {
        return Optional.ofNullable(selectById(id));
    }

    default Optional<Dictionary> findByCode(String code) {
        return Optional.ofNullable(selectOneByCode(code));
    }

    default void save(Dictionary dictionary) {
        if (dictionary.getId() == null) {
            insert(dictionary);
        } else {
            updateById(dictionary);
        }
    }
}




