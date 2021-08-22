package mall.data.dictionary.service.api;

import mall.data.dictionary.service.api.dto.DictionaryGetParams;
import mall.data.dictionary.service.api.dto.DictionaryInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author walter
 */
@FeignClient(name = "data-dictionary-service")
public interface DataDictionaryService {

    @RequestMapping(value = "dictionary/get", method = {RequestMethod.GET, RequestMethod.POST})
    DictionaryInfo get(DictionaryGetParams dictionaryGetParams);
}
