package mall.dictionary.service.domain;

import lombok.Getter;
import lombok.Setter;
import mall.core.domain.Entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author walter
 */
@Getter
@Setter
public class Dictionary implements Entity<Integer> {
    private Integer id;
    private String code;
    private String description;
    private List<DictionaryItem> items;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;

    public Dictionary() {
        this.items = new ArrayList<>();
    }

    public void addItem(String title, String value) {
        this.items.add(new DictionaryItem(title, value));
    }
}
