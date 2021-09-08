package mall.series.service.domain;

/**
 * @author walter
 */
public interface SequenceRepository {
    SequenceSegment getSegment(SequenceId sequenceId, Integer count);
}
