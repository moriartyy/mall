package mall.dictionary.service.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import mall.dictionary.api.dto.*;
import mall.dictionary.api.service.DictionaryItemService;
import mall.webservice.api.annotation.RequestParams;
import mall.webservice.api.dto.Acknowledgement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author walter
 */
@Api("dictionary-item-service")
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DictionaryItemController implements DictionaryItemService {

    private final DictionaryItemService dictionaryItemService;

    @Override
    public Acknowledgement save(@RequestParams DictionaryItemSaveParams dictionaryItemSaveParams) {
        return dictionaryItemService.save(dictionaryItemSaveParams);
    }

    @Override
    public Acknowledgement batchSave(@RequestParams List<DictionaryItemSaveParams> dictionarySaveParamsList) {
        return dictionaryItemService.batchSave(dictionarySaveParamsList);
    }

    @Override
    public DictionaryItemInfo get(@RequestParams DictionaryItemGetParams dictionaryItemGetParams) {
        return dictionaryItemService.get(dictionaryItemGetParams);
    }

    @Override
    public Acknowledgement delete(@RequestParams DictionaryItemDeleteParams dictionaryItemDeleteParams) {
        return dictionaryItemService.delete(dictionaryItemDeleteParams);
    }

    @Override
    public List<DictionaryItemInfo> query(@RequestParams DictionaryItemQueryParams dictionaryItemQueryParams) {
        return dictionaryItemService.query(dictionaryItemQueryParams);
    }
}
