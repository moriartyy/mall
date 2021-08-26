package mall.dictionary.service.api;

import mall.dictionary.service.api.dto.DictionaryGetParams;
import mall.dictionary.service.api.dto.DictionaryInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author walter
 */
@FeignClient(name = "dictionary-service")
public interface DictionaryService {

    @RequestMapping(value = "dictionary/get", method = {RequestMethod.GET, RequestMethod.POST})
    DictionaryInfo get(DictionaryGetParams dictionaryGetParams);
}
