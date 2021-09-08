package mall.series.service.infrastructure;

import mall.series.service.domain.SequenceId;
import mall.series.service.domain.SequenceSegment;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * @author walter
 */
@SpringBootTest
class SequenceRepositoryAdapterTest {

    @Autowired
    private SequenceRepositoryAdapter sequenceRepositoryAdapter;

    @Test
    void getSegment() {
        SequenceId sequenceId = new SequenceId(1, 10000);
        SequenceSegment segment = this.sequenceRepositoryAdapter.getSegment(sequenceId, 3);
        assertEquals(sequenceId, segment.getSequenceId());
        assertEquals(1, segment.getStart());
        assertEquals(3, segment.getEnd());
        segment = this.sequenceRepositoryAdapter.getSegment(sequenceId, 1);
        assertEquals(4, segment.getStart());
        assertEquals(4, segment.getEnd());
        this.sequenceRepositoryAdapter.delete(sequenceId);
    }

    @Test
    void createSequence() {
        SequenceId sequenceId = new SequenceId(1, 10000);
        Optional<Long> value = this.sequenceRepositoryAdapter.create(sequenceId, 3);
        assertEquals(3, value.orElseGet(() -> null));
        value = this.sequenceRepositoryAdapter.create(sequenceId, 3);
        assertFalse(value.isPresent());
        this.sequenceRepositoryAdapter.delete(sequenceId);
    }
}
