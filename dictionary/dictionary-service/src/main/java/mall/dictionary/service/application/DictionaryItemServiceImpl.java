//package mall.dictionary.service.application;
//
//import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
//import lombok.RequiredArgsConstructor;
//import mall.common.exception.BusinessException;
//import mall.core.transformation.ObjectTransformer;
//import mall.dictionary.api.dto.*;
//import mall.dictionary.api.service.DictionaryItemService;
//import mall.dictionary.service.entity.DictionaryEntity;
//import mall.dictionary.service.entity.DictionaryItemEntity;
//import mall.dictionary.service.infrastructure.mapper.DictionaryItemMapper;
//import mall.dictionary.service.infrastructure.mapper.DictionaryMapper;
//import mall.webservice.api.dto.Acknowledgement;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Collections;
//import java.util.List;
//import java.util.Optional;
//
///**
// * @author walter
// */
//@RestController
//@RequiredArgsConstructor(onConstructor = @__(@Autowired))
//public class DictionaryItemServiceImpl implements DictionaryItemService {
//    private final DictionaryMapper dictionaryMapper;
//    private final DictionaryItemMapper dictionaryItemMapper;
//    private final ObjectTransformer objectTransformer;
//
//    @Override
//    public Acknowledgement save(DictionaryItemSaveParams dictionaryItemSaveParams) {
//        int r = this.dictionaryItemMapper.save(objectTransformer.map(dictionaryItemSaveParams, DictionaryItemEntity.class));
//        return (r > 0) ? Acknowledgement.YES : Acknowledgement.NO;
//    }
//
//    @Transactional
//    @Override
//    public Acknowledgement batchSave(List<DictionaryItemSaveParams> dictionarySaveParamsList) {
//        return dictionarySaveParamsList.stream()
//                .map(this::save)
//                .reduce(Acknowledgement::merge)
//                .orElse(Acknowledgement.NO);
//    }
//
//    @Override
//    public DictionaryItemInfo get(DictionaryItemGetParams dictionaryItemGetParams) {
//        return this.dictionaryItemMapper.findById(dictionaryItemGetParams.getId())
//                .map(item -> objectTransformer.map(item, DictionaryItemInfo.class))
//                .orElseThrow(() -> new BusinessException("DictionaryItemInfo not exist!"));
//    }
//
//    @Override
//    public Acknowledgement delete(DictionaryItemDeleteParams dictionaryItemDeleteParams) {
//        int r = this.dictionaryItemMapper.deleteById(dictionaryItemDeleteParams.getId());
//        return (r > 0) ? Acknowledgement.YES : Acknowledgement.NO;
//    }
//
//    @Override
//    public List<DictionaryItemInfo> query(DictionaryItemQueryParams dictionaryItemQueryParams) {
//        Optional<DictionaryEntity> optionalDictionary = this.dictionaryMapper.findByCode(dictionaryItemQueryParams.getDictionaryCode());
//        if (optionalDictionary.isPresent()) {
//            QueryWrapper<DictionaryItemEntity> q = new QueryWrapper<>();
//            q.eq("dictionaryCode", dictionaryItemQueryParams.getDictionaryCode())
//                    .eq(dictionaryItemQueryParams.getId() != null, "id", dictionaryItemQueryParams.getId())
//                    .like(dictionaryItemQueryParams.getName() != null, "name", dictionaryItemQueryParams.getName())
//                    .like(dictionaryItemQueryParams.getValue() != null, "name", dictionaryItemQueryParams.getValue());
//            List<DictionaryItemEntity> itemEntityList = this.dictionaryItemMapper.selectList(q);
//            return this.objectTransformer.mapList(itemEntityList, DictionaryItemInfo.class);
//        }
//        return Collections.emptyList();
//    }
//}
