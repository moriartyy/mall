package mall.system.service.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import mall.common.dto.PagingParams;

import javax.validation.constraints.Size;

/**
 * @author walter
 */

@Getter
@Setter
public class UserQueryParams extends PagingParams {

    @Size(max = 45, message = "编码长度不能超过45")
    @ApiModelProperty("Name")
    private String name;

    @Size(max = 45, message = "编码长度不能超过45")
    @ApiModelProperty("Real Name")
    private String realName;

    @ApiModelProperty("Activity")
    private Integer activity;

}
