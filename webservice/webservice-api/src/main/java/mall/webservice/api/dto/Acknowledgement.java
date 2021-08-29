package mall.webservice.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

/**
 * @author hongmiao.yu
 */
@ApiModel(description = "Acknowledgement")
@Getter
public class Acknowledgement {

    @ApiModelProperty(value = "Acknowledged")
    private final String acknowledged;

    private Acknowledgement(String acknowledged) {
        this.acknowledged = acknowledged;
    }

    public static final Acknowledgement YES = new Acknowledgement("yes");
    public static final Acknowledgement NO = new Acknowledgement("no");

    public Acknowledgement merge(Acknowledgement anotherAcknowledgement) {
        return (Boolean.parseBoolean(this.acknowledged) && Boolean.parseBoolean(anotherAcknowledgement.acknowledged)) ? YES : NO;
    }
}
