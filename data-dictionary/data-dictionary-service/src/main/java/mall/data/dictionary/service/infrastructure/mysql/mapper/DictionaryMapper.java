package mall.data.dictionary.service.infrastructure.mysql.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import mall.data.dictionary.service.infrastructure.mysql.entity.DictionaryPO;
import org.apache.ibatis.annotations.Param;

/**
 * @author walter
 */
public interface DictionaryMapper extends BaseMapper<DictionaryPO> {

    DictionaryPO selectOneByCode(@Param("code") String code);
}




