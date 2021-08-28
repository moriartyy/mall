package mall.dictionary.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import mall.dictionary.service.entity.DictionaryItemEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

/**
 * @author walter
 */
public interface DictionaryItemMapper extends BaseMapper<DictionaryItemEntity> {

    List<DictionaryItemEntity> selectByDictionaryCode(@Param("dictionary_code") String dictionaryCode);

    int deleteByDictionaryCode(@Param("dictionary_code") String dictionaryCode);

    default int save(DictionaryItemEntity dictionaryItem) {
        if (dictionaryItem.getId() == null) {
            return insert(dictionaryItem);
        } else {
            return updateById(dictionaryItem);
        }
    }

    default Optional<DictionaryItemEntity> findById(Integer id) {
        return Optional.ofNullable(selectById(id));
    }
}




