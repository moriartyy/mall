package mall.common.util;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author walter
 */
@Getter
@RequiredArgsConstructor(staticName = "of")
public class Tuple<A, B> {
    private final A v1;
    private final B v2;
}
