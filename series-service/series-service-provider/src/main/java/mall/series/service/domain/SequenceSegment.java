package mall.series.service.domain;

import lombok.Getter;

/**
 * @author walter
 */
@Getter
public class SequenceSegment {
    private final SequenceId sequenceId;
    private final Long start;
    private final Long end;
    private final Integer count;

    public SequenceSegment(SequenceId sequenceId, Integer count, Long end) {
        this.sequenceId = sequenceId;
        this.count = count;
        this.end = end;
        this.start = end - count + 1;
    }

}
