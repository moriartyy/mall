package mall.data.dictionary.service.infrastructure.mysql.translator;

import mall.core.translator.Translator;
import mall.core.util.ObjectUtils;
import mall.core.util.Tuple;
import mall.data.dictionary.service.domain.Dictionary;
import mall.data.dictionary.service.domain.DictionaryItem;
import mall.data.dictionary.service.infrastructure.mysql.entity.DictionaryItemPO;
import mall.data.dictionary.service.infrastructure.mysql.entity.DictionaryPO;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author walter
 */
public class DictionaryTranslator implements Translator<Dictionary, Tuple<DictionaryPO, List<DictionaryItemPO>>> {

    @Override
    public Tuple<DictionaryPO, List<DictionaryItemPO>> forward(Dictionary dictionary) {
        DictionaryPO dictionaryPO = ObjectUtils.createInstanceOf(DictionaryPO.class, dictionary);
        List<DictionaryItemPO> dictionaryItemPOList = dictionary.getItems()
                .stream()
                .map(i -> ObjectUtils.createInstanceOf(DictionaryItemPO.class, i))
                .collect(Collectors.toList());
        return Tuple.of(dictionaryPO, dictionaryItemPOList);
    }

    @Override
    public Dictionary backward(Tuple<DictionaryPO, List<DictionaryItemPO>> tuple) {
        Dictionary dictionary = ObjectUtils.createInstanceOf(Dictionary.class, tuple.getV1());
        dictionary.setItems(
                tuple.getV2()
                        .stream()
                        .map(ipo -> ObjectUtils.createInstanceOf(DictionaryItem.class, ipo))
                        .collect(Collectors.toList())
        );
        return dictionary;
    }
}
