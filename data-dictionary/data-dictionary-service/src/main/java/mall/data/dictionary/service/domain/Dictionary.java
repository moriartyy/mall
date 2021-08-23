package mall.data.dictionary.service.domain;

import lombok.Getter;
import lombok.Setter;
import mall.core.domain.Entity;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author walter
 */
@Getter
@Setter
public class Dictionary implements Entity<Integer> {
    private Integer id;
    private String code;
    private List<DictionaryItem> items;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;

}
