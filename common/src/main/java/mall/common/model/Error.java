package mall.common.model;

import lombok.Getter;

/**
 * @author walter
 */
@Getter
public abstract class Error {
    private Integer code;
    private String message;

    protected Error(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    protected Error() {

    }

}
