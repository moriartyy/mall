package mall.product.service.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author walter
 */
@ApiModel(description = "Product Info")
@Data
public class ProductInfo {
    /**
     * ID
     */
    @ApiModelProperty(value = "产品ID", position = 3)
    private Integer id;
    /**
     * Serial Number
     */
    @ApiModelProperty(value = "SN", position = 2)
    private String sn;
    /**
     * Name
     */
    @ApiModelProperty(value = "产品名称", position = 1)
    private String name;
}
