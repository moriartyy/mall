package mall.series.service.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author walter
 */
@SpringBootTest
class SeriesRepositoryTest {

    @Autowired
    private SeriesRepository repository;

    @Test
    public void test() {
        Series salesOrderIdSeries = new Series();
        salesOrderIdSeries.setCode("sales-order-id");
        salesOrderIdSeries.setName("Sales Order ID");
        salesOrderIdSeries.setNumberEpochPattern("yyyyMMdd");
        salesOrderIdSeries.setNumberPrefix("SO");
        salesOrderIdSeries.setNumberLength(18);
        repository.save(salesOrderIdSeries);

        Series series = new Series();
        series.setCode("invoice-id");
        series.setName("Invoice ID");
        series.setNumberLength(10);
        repository.save(series);
    }

}
