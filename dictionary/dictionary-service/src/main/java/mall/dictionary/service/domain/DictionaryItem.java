package mall.dictionary.service.domain;

import lombok.Getter;
import lombok.Setter;
import mall.core.domain.Entity;

/**
 * @author walter
 */
@Getter
@Setter
public class DictionaryItem extends Entity<Integer> {
    private String title;
    private String value;
    private String link;
    private Integer sort;
    private Dictionary dictionary;

    public DictionaryItem() {
    }

    public DictionaryItem(String title, String value) {
        this.title = title;
        this.value = value;
    }
}
