package mall.series.service.domain;

import lombok.Getter;
import lombok.Setter;
import mall.service.domain.AuditableEntity;
import mall.service.util.StringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author walter
 */
@Getter
@Setter
public class Series extends AuditableEntity<Integer> {
    private String name;
    private String code;
    private String numberPrefix;
    /**
     * Date Time Pattern
     * yyyy
     * yyyyMM
     * yyyyMMdd
     */
    private String numberEpochPattern;
    private Integer numberLength;

    public int getEpoch() {
        return getEpoch(LocalDateTime.now());
    }

    public int getEpoch(LocalDateTime dateTime) {
        if (StringUtils.hasLength(numberEpochPattern)) {
            return Integer.parseInt(DateTimeFormatter.ofPattern(this.numberEpochPattern).format(dateTime));
        } else {
            return 0;
        }
    }

    public SequenceId getLongSequenceId() {
        return getLongSequenceId(LocalDateTime.now());
    }

    private SequenceId getLongSequenceId(LocalDateTime dateTime) {
        return new SequenceId(this.getId(), getEpoch(dateTime));
    }

    public List<String> getSeriesNumbers(SequenceSegment sequenceSegment) {
        List<String> seriesNumbers = new ArrayList<>(sequenceSegment.getCount());
        for (long i = sequenceSegment.getStart(); i <= sequenceSegment.getEnd(); i++) {
            seriesNumbers.add(buildSeriesNumber(sequenceSegment.getSequenceId().getEpoch(), i));
        }
        return seriesNumbers;
    }

    private String buildSeriesNumber(int epoch, long sequenceValue) {
        StringBuilder builder = new StringBuilder();
        if (StringUtils.hasLength(numberPrefix)) {
            builder.append(numberPrefix);
        }
        if (epoch > 0) {
            builder.append(epoch);
        }
        int paddedLength = numberLength - builder.length();
        builder.append(StringUtils.padLeft(sequenceValue, paddedLength, '0'));
        return builder.toString();
    }
}
