package mall.system.service.domain.resouce;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author Walter
 */
@Getter
@Setter
public class Resource {

    private Integer id;
    private String name;
    private String code;
    private String description;
    private String route;
    private Integer moduleId;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;

}
