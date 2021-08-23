package mall.data.dictionary.service.infrastructure.mysql.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import mall.data.dictionary.service.infrastructure.mysql.entity.DictionaryItemPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author walter
 */
public interface DictionaryItemMapper extends BaseMapper<DictionaryItemPO> {

    List<DictionaryItemPO> selectByDictionaryCode(@Param("dictionary_code") String dictionaryCode);

    int deleteByDictionaryCode(@Param("dictionary_code") String dictionaryCode);
}




