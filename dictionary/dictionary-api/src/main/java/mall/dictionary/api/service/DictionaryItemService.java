package mall.dictionary.api.service;

import mall.dictionary.api.dto.*;
import mall.webservice.api.Acknowledgement;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author walter
 */
@FeignClient(name = "dictionary-service")
public interface DictionaryItemService {

    @RequestMapping(path = "dictionary/item/save")
    Acknowledgement save(DictionaryItemSaveParams dictionaryItemSaveParams);

    @RequestMapping(path = "dictionary/item/get")
    DictionaryItemInfo get(DictionaryItemGetParams dictionaryItemGetParams);

    @RequestMapping(path = "dictionary/item/delete")
    Acknowledgement delete(DictionaryItemDeleteParams dictionaryItemDeleteParams);

    @RequestMapping(path = "dictionary/item/query")
    List<DictionaryItemInfo> query(DictionaryItemQueryParams dictionaryItemQueryParams);
}
