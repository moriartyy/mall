package mall.dictionary.service.api;

import mall.common.model.PageInfo;
import mall.dictionary.service.api.dto.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author walter
 */
@FeignClient(name = "dictionary-service")
public interface DictionaryService {

    @RequestMapping(path = "dictionary/create")
    DictionaryInfo create(DictionaryCreateParams orderCreateParams);

    @RequestMapping(path = "dictionary/update")
    DictionaryInfo update(DictionaryUpdateParams orderUpdateParams);

    @RequestMapping(path = "dictionary/get")
    DictionaryInfo get(DictionaryGetParams orderGetParams);

    @RequestMapping(path = "dictionary/query")
    PageInfo<DictionaryInfo> query(DictionaryQueryParams orderQueryParams);

    @RequestMapping(path = "dictionary/delete")
    void delete(DictionaryDeleteParams orderDeleteParams);
}
