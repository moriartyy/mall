package mall.dictionary.service.application;

import lombok.RequiredArgsConstructor;
import mall.common.exception.BusinessException;
import mall.core.transformation.ObjectTransformer;
import mall.core.util.StringUtils;
import mall.dictionary.service.DictionaryService;
import mall.dictionary.service.domain.Dictionary;
import mall.dictionary.service.dto.DictionaryDeleteParams;
import mall.dictionary.service.dto.DictionaryGetParams;
import mall.dictionary.service.dto.DictionaryInfo;
import mall.dictionary.service.dto.DictionarySaveParams;
import mall.dictionary.service.infrastructure.mapper.DictionaryItemMapper;
import mall.dictionary.service.infrastructure.mapper.DictionaryMapper;
import mall.webservice.dto.Acknowledgement;
import mall.webservice.exception.MissingParameterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


/**
 * @author walter
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DictionaryServiceImpl implements DictionaryService {

    private final DictionaryMapper dictionaryMapper;
    private final DictionaryItemMapper dictionaryItemMapper;
    private final ObjectTransformer objectTransformer;

    @Override
    public Acknowledgement save(DictionarySaveParams dictionarySaveParams) {
        Dictionary dictionary = objectTransformer.map(dictionarySaveParams, Dictionary.class);
        this.dictionaryMapper.save(dictionary);
        return Acknowledgement.YES;
    }

    @Override
    public DictionaryInfo get(DictionaryGetParams dictionaryGetParams) {
        if (dictionaryGetParams.getId() <= 0 && !StringUtils.hasText(dictionaryGetParams.getCode())) {
            throw new MissingParameterException("id和code不能同时为空！");
        }
        Optional<Dictionary> optionalDictionary = dictionaryGetParams.getId() > 0
                ? dictionaryMapper.findById(dictionaryGetParams.getId()) :
                dictionaryMapper.findByCode(dictionaryGetParams.getCode());
        return optionalDictionary.map(d -> objectTransformer.map(d, DictionaryInfo.class))
                .orElseThrow(() -> new BusinessException("Dictionary not exist"));
    }

    @Transactional
    @Override
    public Acknowledgement delete(DictionaryDeleteParams dictionaryDeleteParams) {
        dictionaryMapper.findById(dictionaryDeleteParams.getId()).ifPresent(d -> {
            this.dictionaryItemMapper.deleteByDictionaryCode(d.getCode());
            this.dictionaryMapper.deleteById(d.getId());
        });
        return Acknowledgement.NO;
    }

}
