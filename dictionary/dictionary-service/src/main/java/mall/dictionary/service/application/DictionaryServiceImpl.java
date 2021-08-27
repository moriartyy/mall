package mall.dictionary.service.application;

import lombok.RequiredArgsConstructor;
import mall.common.exception.BusinessException;
import mall.core.util.StringUtils;
import mall.dictionary.api.dto.DictionaryDeleteParams;
import mall.dictionary.api.dto.DictionaryGetParams;
import mall.dictionary.api.dto.DictionaryInfo;
import mall.dictionary.api.dto.DictionarySaveParams;
import mall.dictionary.api.service.DictionaryService;
import mall.dictionary.service.domain.Dictionary;
import mall.dictionary.service.domain.DictionaryRepository;
import mall.webservice.api.Acknowledgement;
import mall.webservice.core.exception.MissingParameterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


/**
 * @author walter
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DictionaryServiceImpl implements DictionaryService {

    private DictionaryRepository dictionaryRepository;

    @Override
    public Acknowledgement save(DictionarySaveParams dictionarySaveParams) {

        return Acknowledgement.YES;
    }

    @Override
    public DictionaryInfo get(DictionaryGetParams dictionaryGetParams) {
        if (dictionaryGetParams.getId() <= 0 && !StringUtils.hasText(dictionaryGetParams.getCode())) {
            throw new MissingParameterException("id和code不能同时为空！");
        }
        Optional<Dictionary> dict = dictionaryGetParams.getId() > 0
                ? dictionaryRepository.getIfPresent(dictionaryGetParams.getId()) :
                dictionaryRepository.findByCode(dictionaryGetParams.getCode());
        return dict.map(this::assembly)
                .orElseThrow(() -> new BusinessException("Dictionary not exist, code: " + dictionaryGetParams.getCode()));
    }

    @Override
    public Acknowledgement delete(DictionaryDeleteParams dictionaryDeleteParams) {
        return Acknowledgement.YES;
    }

    private DictionaryInfo assembly(Dictionary dictionary) {
        return null;
    }

}
