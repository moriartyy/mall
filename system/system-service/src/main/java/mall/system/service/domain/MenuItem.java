package mall.system.service.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author Walter
 */
@Getter
@Setter
public class MenuItem {

    private Integer id;
    private String name;
    private Integer parentId;
    private Integer resourceId;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;

}
