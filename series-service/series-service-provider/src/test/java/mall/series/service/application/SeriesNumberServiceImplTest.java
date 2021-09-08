package mall.series.service.application;

import mall.series.service.SeriesNumberService;
import mall.series.service.domain.Series;
import mall.series.service.domain.SeriesRepository;
import mall.series.service.infrastructure.SequenceRepositoryAdapter;
import mall.service.util.JsonUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author walter
 */
@SpringBootTest
class SeriesNumberServiceImplTest {

    @Autowired
    private SeriesNumberService seriesNumberService;
    @Autowired
    private SeriesRepository seriesRepository;
    @Autowired
    private SequenceRepositoryAdapter sequenceRepositoryAdapter;

    @Test
    void getNextOne() {
        Series series0 = new Series();
        series0.setCode("series0");
        series0.setName("Sales Order ID");
        series0.setNumberEpochPattern("yyyyMMdd");
        series0.setNumberPrefix("SO");
        series0.setNumberLength(18);
        seriesRepository.save(series0);

        String sn = seriesNumberService.getNextOne("series0");
        assertEquals(18, sn.length());
        assertEquals(DateTimeFormatter.ofPattern("yyyyMMdd").format(LocalDate.now()), sn.substring(2, 10));
        String sn1 = seriesNumberService.getNextOne("series0");
        assertEquals(Long.parseLong(sn.substring(11)) + 1, Long.parseLong(sn1.substring(11)));

        seriesRepository.delete(series0.getId());
        sequenceRepositoryAdapter.deleteAllBySeriesId(series0.getId());
    }

    @Test
    void getNextBatch() {

        Series series1 = new Series();
        series1.setCode("series1");
        series1.setName("Invoice ID");
        series1.setNumberLength(10);
        seriesRepository.save(series1);

        List<String> sns = seriesNumberService.getNextBatch("series1", 3);
        print(sns);
        assertEquals(3, sns.size());
        assertEquals(10, sns.get(0).length());

        seriesRepository.delete(series1.getId());
        sequenceRepositoryAdapter.deleteAllBySeriesId(series1.getId());
    }

    private void print(Object obj) {
        System.out.println(JsonUtils.serializeToString(obj));
        ;
    }
}
