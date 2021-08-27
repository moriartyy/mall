package mall.dictionary.service.controller;

import lombok.RequiredArgsConstructor;
import mall.dictionary.service.api.DictionaryService;
import mall.dictionary.service.api.dto.DictionaryDeleteParams;
import mall.dictionary.service.api.dto.DictionaryGetParams;
import mall.dictionary.service.api.dto.DictionaryInfo;
import mall.dictionary.service.api.dto.DictionarySaveParams;
import mall.web.service.annotation.RequestParams;
import mall.web.service.api.Acknowledgement;
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
