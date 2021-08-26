package mall.dictionary.service.application;

import lombok.RequiredArgsConstructor;
import mall.common.exception.BusinessException;
import mall.dictionary.service.api.DictionaryService;
import mall.dictionary.service.api.dto.DictionaryGetParams;
import mall.dictionary.service.api.dto.DictionaryInfo;
import mall.dictionary.service.domain.Dictionary;
import mall.dictionary.service.domain.DictionaryRepositoryBake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author walter
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DictionaryApplicationServiceBake implements DictionaryService {

    private DictionaryRepositoryBake dictionaryRepository;

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
