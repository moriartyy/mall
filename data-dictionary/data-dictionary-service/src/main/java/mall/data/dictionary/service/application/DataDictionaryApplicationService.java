package mall.data.dictionary.service.application;

import lombok.RequiredArgsConstructor;
import mall.common.exception.BusinessException;
import mall.data.dictionary.service.api.DataDictionaryService;
import mall.data.dictionary.service.api.dto.DictionaryGetParams;
import mall.data.dictionary.service.api.dto.DictionaryInfo;
import mall.data.dictionary.service.domain.Dictionary;
import mall.data.dictionary.service.domain.DictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author walter
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DataDictionaryApplicationService implements DataDictionaryService {

    private DictionaryRepository dictionaryRepository;

    @Override
    public DictionaryInfo get(DictionaryGetParams dictionaryGetParams) {
        return Optional.ofNullable(dictionaryRepository.getByCode(dictionaryGetParams.getCode()))
                .map(this::assembly)
                .orElseThrow(() -> new BusinessException("Dictionary not exist, code: " + dictionaryGetParams.getCode()));
    }

    private DictionaryInfo assembly(Dictionary dictionary) {
        return null;
    }

}
