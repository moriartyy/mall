package mall.dictionary.service.controller;

import lombok.RequiredArgsConstructor;
import mall.dictionary.api.dto.DictionaryDeleteParams;
import mall.dictionary.api.dto.DictionaryGetParams;
import mall.dictionary.api.dto.DictionaryInfo;
import mall.dictionary.api.dto.DictionarySaveParams;
import mall.dictionary.api.service.DictionaryService;
import mall.webservice.api.Acknowledgement;
import mall.webservice.core.annotation.RequestParams;
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
    public Acknowledgement save(DictionarySaveParams dictionarySaveParams) {
        return dictionaryService.save(dictionarySaveParams);
    }

    @Override
    public DictionaryInfo get(@RequestParams DictionaryGetParams dictionaryGetParams) {
        return dictionaryService.get(dictionaryGetParams);
    }

    @Override
    public Acknowledgement delete(DictionaryDeleteParams dictionaryDeleteParams) {
        return dictionaryService.delete(dictionaryDeleteParams);
    }
}
