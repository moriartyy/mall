package mall.dictionary.service.domain;

import lombok.Getter;
import lombok.Setter;
import mall.common.enums.Activity;
import mall.core.domain.AuditableEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author walter
 */
@Getter
@Setter
public class Dictionary extends AuditableEntity<Integer> {

    private String code;
    private String description;
    private Activity activity;
    private List<DictionaryItem> items;

    public Dictionary() {
        this.items = new ArrayList<>();
    }

    public void addItem(String title, String value) {
        this.items.add(new DictionaryItem(title, value));
    }
}
