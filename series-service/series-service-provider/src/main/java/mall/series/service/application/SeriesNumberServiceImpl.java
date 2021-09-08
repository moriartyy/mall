package mall.series.service.application;

import lombok.RequiredArgsConstructor;
import mall.series.service.SeriesNumberService;
import mall.series.service.domain.*;
import mall.service.domain.query.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author walter
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SeriesNumberServiceImpl implements SeriesNumberService {

    private final SeriesRepository seriesRepository;
    private final SequenceRepository sequenceRepository;

    @Override
    public String getNextOne(String seriesCode) {
        return getSeriesNumberSegment(seriesCode, 1).get(0);
    }

    @Override
    public List<String> getNextBatch(String seriesCode, Integer count) {
        return getSeriesNumberSegment(seriesCode, count);
    }

    private List<String> getSeriesNumberSegment(String seriesCode, Integer count) {
        Series series = this.seriesRepository.findOne(Criteria.equalTo("code", seriesCode))
                .orElseThrow(() -> new RuntimeException("Series Not exist!"));

        SequenceId sequenceId = series.getLongSequenceId();
        SequenceSegment sequenceSegment = this.sequenceRepository.getSegment(sequenceId, count);
        return series.getSeriesNumbers(sequenceSegment);
    }
}
