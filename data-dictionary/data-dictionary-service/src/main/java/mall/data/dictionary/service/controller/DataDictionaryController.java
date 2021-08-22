package mall.data.dictionary.service.controller;

import lombok.RequiredArgsConstructor;
import mall.data.dictionary.service.api.DataDictionaryService;
import mall.data.dictionary.service.api.dto.DictionaryGetParams;
import mall.data.dictionary.service.api.dto.DictionaryInfo;
import mall.web.service.annotation.RequestParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author walter
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DataDictionaryController implements DataDictionaryService {

    private final DataDictionaryService dictionaryService;

    @Override
    public DictionaryInfo get(@RequestParams DictionaryGetParams dictionaryGetParams) {
        return dictionaryService.get(dictionaryGetParams);
    }
}
