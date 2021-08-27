package mall.dictionary.service.api;

import mall.dictionary.service.api.dto.DictionaryDeleteParams;
import mall.dictionary.service.api.dto.DictionaryGetParams;
import mall.dictionary.service.api.dto.DictionaryInfo;
import mall.dictionary.service.api.dto.DictionarySaveParams;
import mall.web.service.api.Acknowledgement;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author walter
 */
@FeignClient(name = "dictionary-service")
public interface DictionaryService {

    @RequestMapping(path = "dictionary/save")
    Acknowledgement save(DictionarySaveParams orderCreateParams);

    @RequestMapping(path = "dictionary/get")
    DictionaryInfo get(DictionaryGetParams orderGetParams);

    @RequestMapping(path = "dictionary/delete")
    Acknowledgement delete(DictionaryDeleteParams orderDeleteParams);
}
