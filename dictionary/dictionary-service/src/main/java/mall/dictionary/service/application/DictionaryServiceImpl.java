//package mall.dictionary.service.application;
//
//import lombok.RequiredArgsConstructor;
//import mall.common.exception.BusinessException;
//import mall.core.transformation.ObjectTransformer;
//import mall.core.util.StringUtils;
//import mall.dictionary.api.dto.DictionaryDeleteParams;
//import mall.dictionary.api.dto.DictionaryGetParams;
//import mall.dictionary.api.dto.DictionaryInfo;
//import mall.dictionary.api.dto.DictionarySaveParams;
//import mall.dictionary.api.service.DictionaryService;
//import mall.dictionary.service.entity.DictionaryEntity;
//import mall.dictionary.service.infrastructure.mapper.DictionaryItemMapper;
//import mall.dictionary.service.infrastructure.mapper.DictionaryMapper;
//import mall.webservice.api.dto.Acknowledgement;
//import mall.webservice.core.exception.MissingParameterException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Optional;
//
//
///**
// * @author walter
// */
//@RestController
//@RequiredArgsConstructor(onConstructor = @__(@Autowired))
//public class DictionaryServiceImpl implements DictionaryService {
//
//    private final DictionaryMapper dictionaryMapper;
//    private final DictionaryItemMapper dictionaryItemMapper;
//    private final ObjectTransformer objectTransformer;
//
//    @Override
//    public Acknowledgement save(DictionarySaveParams dictionarySaveParams) {
//        DictionaryEntity dictionary = objectTransformer.map(dictionarySaveParams, DictionaryEntity.class);
//        this.dictionaryMapper.save(dictionary);
//        return Acknowledgement.YES;
//    }
//
//    @Override
//    public DictionaryInfo get(DictionaryGetParams dictionaryGetParams) {
//        if (dictionaryGetParams.getId() <= 0 && !StringUtils.hasText(dictionaryGetParams.getCode())) {
//            throw new MissingParameterException("id和code不能同时为空！");
//        }
//        Optional<DictionaryEntity> optionalDictionary = dictionaryGetParams.getId() > 0
//                ? dictionaryMapper.findById(dictionaryGetParams.getId()) :
//                dictionaryMapper.findByCode(dictionaryGetParams.getCode());
//        return optionalDictionary.map(d -> objectTransformer.map(d, DictionaryInfo.class))
//                .orElseThrow(() -> new BusinessException("Dictionary not exist"));
//    }
//
//    @Transactional
//    @Override
//    public Acknowledgement delete(DictionaryDeleteParams dictionaryDeleteParams) {
//        dictionaryMapper.findById(dictionaryDeleteParams.getId()).ifPresent(d -> {
//            this.dictionaryItemMapper.deleteByDictionaryCode(d.getCode());
//            this.dictionaryMapper.deleteById(d.getId());
//        });
//        return Acknowledgement.NO;
//    }
//
//}
