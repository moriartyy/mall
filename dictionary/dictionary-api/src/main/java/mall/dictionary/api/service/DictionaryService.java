package mall.dictionary.api.service;

import mall.dictionary.api.dto.DictionaryDeleteParams;
import mall.dictionary.api.dto.DictionaryGetParams;
import mall.dictionary.api.dto.DictionaryInfo;
import mall.dictionary.api.dto.DictionarySaveParams;
import mall.webservice.api.Acknowledgement;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author walter
 */
@FeignClient(name = "dictionary-service")
public interface DictionaryService {

    @RequestMapping(path = "dictionary/save")
    Acknowledgement save(DictionarySaveParams dictionarySaveParams);

    @RequestMapping(path = "dictionary/get")
    DictionaryInfo get(DictionaryGetParams dictionaryGetParams);

    @RequestMapping(path = "dictionary/delete")
    Acknowledgement delete(DictionaryDeleteParams dictionaryDeleteParams);
}
