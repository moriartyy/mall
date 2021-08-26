package mall.dictionary.service.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * @author walter
 */
@Getter
@Setter
public class DictionaryItem {
    private String title;
    private String value;
    private String link;
    private Integer sort;

    public DictionaryItem() {
    }

    public DictionaryItem(String title, String value) {
        this.title = title;
        this.value = value;
    }
}
