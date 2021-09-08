package mall.series.service;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author walter
 */
public interface SeriesNumberService {

    @RequestMapping(path = "series-number/get-next-one", method = {RequestMethod.GET, RequestMethod.POST})
    String getNextOne(String seriesCode);

    @RequestMapping(path = "series-number/get-next-batch", method = {RequestMethod.GET, RequestMethod.POST})
    List<String> getNextBatch(String seriesCode, Integer count);
}
