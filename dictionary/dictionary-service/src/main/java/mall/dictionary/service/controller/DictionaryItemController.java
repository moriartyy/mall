package mall.dictionary.service.controller;

import lombok.RequiredArgsConstructor;
import mall.dictionary.api.dto.*;
import mall.dictionary.api.service.DictionaryItemService;
import mall.webservice.api.Acknowledgement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author walter
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DictionaryItemController implements DictionaryItemService {

    private final DictionaryItemService dictionaryItemService;

    @Override
    public Acknowledgement save(DictionaryItemSaveParams dictionaryItemSaveParams) {
        return dictionaryItemService.save(dictionaryItemSaveParams);
    }

    @Override
    public Acknowledgement batchSave(List<DictionaryItemSaveParams> dictionarySaveParamsList) {
        return dictionaryItemService.batchSave(dictionarySaveParamsList);
    }

    @Override
    public DictionaryItemInfo get(DictionaryItemGetParams dictionaryItemGetParams) {
        return dictionaryItemService.get(dictionaryItemGetParams);
    }

    @Override
    public Acknowledgement delete(DictionaryItemDeleteParams dictionaryItemDeleteParams) {
        return dictionaryItemService.delete(dictionaryItemDeleteParams);
    }

    @Override
    public List<DictionaryItemInfo> query(DictionaryItemQueryParams dictionaryItemQueryParams) {
        return dictionaryItemService.query(dictionaryItemQueryParams);
    }
}
