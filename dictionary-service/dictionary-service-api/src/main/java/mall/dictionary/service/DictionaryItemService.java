package mall.dictionary.service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import mall.dictionary.service.dto.*;
import mall.webservice.dto.Acknowledgement;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author walter
 */
@Api("dictionary-item-service")
@FeignClient(name = "dictionary-item-service")
public interface DictionaryItemService {

    @ApiOperation(value = "save")
    @PostMapping(path = "dictionary/item/save")
    Acknowledgement save(DictionaryItemSaveParams dictionaryItemSaveParams);

    @ApiOperation(value = "batch-save")
    @PostMapping(path = "dictionary/item/batch-save")
    Acknowledgement batchSave(List<DictionaryItemSaveParams> dictionarySaveParamsList);

    @ApiOperation(value = "get")
    @PostMapping(path = "dictionary/item/get")
    DictionaryItemInfo get(DictionaryItemGetParams dictionaryItemGetParams);

    @ApiOperation(value = "delete")
    @PostMapping(path = "dictionary/item/delete")
    Acknowledgement delete(DictionaryItemDeleteParams dictionaryItemDeleteParams);

    @ApiOperation(value = "query")
    @PostMapping(path = "dictionary/item/query")
    List<DictionaryItemInfo> query(DictionaryItemQueryParams dictionaryItemQueryParams);
}
