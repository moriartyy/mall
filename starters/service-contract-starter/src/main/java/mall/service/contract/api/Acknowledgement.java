package mall.service.contract.api;

import lombok.Getter;

/**
 * @author hongmiao.yu
 */
@Getter
public class Acknowledgement {

    private final String acknowledged;

    private Acknowledgement(String acknowledged) {
        this.acknowledged = acknowledged;
    }

    public static final Acknowledgement YES = new Acknowledgement("yes");
    public static final Acknowledgement NO = new Acknowledgement("no");
}
