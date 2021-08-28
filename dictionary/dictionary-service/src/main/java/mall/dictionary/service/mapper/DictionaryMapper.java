package mall.dictionary.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import mall.dictionary.service.entity.DictionaryEntity;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;

/**
 * @author walter
 */
public interface DictionaryMapper extends BaseMapper<DictionaryEntity> {

    DictionaryEntity selectOneByCode(@Param("code") String code);

    default Optional<DictionaryEntity> findById(Integer id) {
        return Optional.ofNullable(selectById(id));
    }

    default Optional<DictionaryEntity> findByCode(String code) {
        return Optional.ofNullable(selectOneByCode(code));
    }

    default void save(DictionaryEntity dictionary) {
        if (dictionary.getId() == null) {
            insert(dictionary);
        } else {
            updateById(dictionary);
        }
    }
}




