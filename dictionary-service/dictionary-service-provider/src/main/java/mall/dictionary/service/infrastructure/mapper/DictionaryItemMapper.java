package mall.dictionary.service.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import mall.dictionary.service.domain.DictionaryItem;
import mall.dictionary.service.entity.DictionaryItemEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

/**
 * @author walter
 */
public interface DictionaryItemMapper extends BaseMapper<DictionaryItem> {

    List<DictionaryItemEntity> selectByDictionaryCode(@Param("dictionary_code") String dictionaryCode);

    int deleteByDictionaryCode(@Param("dictionary_code") String dictionaryCode);

    default int save(DictionaryItem dictionaryItem) {
        if (dictionaryItem.getId() == null) {
            return insert(dictionaryItem);
        } else {
            return updateById(dictionaryItem);
        }
    }

    default Optional<DictionaryItem> findById(Integer id) {
        return Optional.ofNullable(selectById(id));
    }
}




