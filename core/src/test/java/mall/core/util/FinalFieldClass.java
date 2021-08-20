package mall.core.util;

import lombok.Getter;

/**
 * @author walter
 */
@Getter
public class FinalFieldClass {
    private Integer f1;
    private String f2;

    public FinalFieldClass(Integer f1, String f2) {
        this.f1 = f1;
        this.f2 = f2;
        System.out.println("here");
    }

    private FinalFieldClass() {
    }
}
