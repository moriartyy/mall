package mall.dictionary.service.controller;

import lombok.RequiredArgsConstructor;
import mall.common.dto.PageInfo;
import mall.dictionary.service.api.DictionaryService;
import mall.dictionary.service.api.dto.*;
import mall.web.service.annotation.RequestParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author walter
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DictionaryController implements DictionaryService {

    private final DictionaryService dictionaryService;

    @Override
    public DictionaryInfo create(DictionaryCreateParams orderCreateParams) {
        return null;
    }

    @Override
    public DictionaryInfo update(DictionaryUpdateParams orderUpdateParams) {
        return null;
    }

    @Override
    public DictionaryInfo get(@RequestParams DictionaryGetParams dictionaryGetParams) {
        return dictionaryService.get(dictionaryGetParams);
    }

    @Override
    public PageInfo<DictionaryInfo> query(DictionaryQueryParams orderQueryParams) {
        return null;
    }

    @Override
    public void delete(DictionaryDeleteParams orderDeleteParams) {

    }
}
