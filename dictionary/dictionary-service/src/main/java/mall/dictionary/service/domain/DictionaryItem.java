package mall.dictionary.service.domain;

import lombok.Getter;
import lombok.Setter;
import mall.core.domain.Entity;


/**
 * @author Walter
 */
@Getter
@Setter
public class DictionaryItem extends Entity<Integer> {

    private String name;
    private String value;
    private Short order;
    private String link;
    private String dictionaryCode;

}
