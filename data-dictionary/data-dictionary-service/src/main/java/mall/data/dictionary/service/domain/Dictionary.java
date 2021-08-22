package mall.data.dictionary.service.domain;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author walter
 */
@Getter
public class Dictionary {
    private Integer id;
    private String code;
    private List<DictionaryItem> items;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;

}
