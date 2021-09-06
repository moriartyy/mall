package mall.service.util;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author walter
 */
@EqualsAndHashCode
@Getter
@RequiredArgsConstructor(staticName = "of")
public class Tuple<A, B> {
    private final A v1;
    private final B v2;
}
