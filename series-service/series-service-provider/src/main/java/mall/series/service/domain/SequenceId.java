package mall.series.service.domain;

import lombok.Value;

/**
 * @author walter
 */
@Value
public class SequenceId {
    Integer seriesId;
    Integer epoch;
}
