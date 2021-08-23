package mall.common.model;

import lombok.Data;

import java.util.List;

/**
 * @author walter
 */
@Data
public class PageInfo<T> {
    private long total;
    private long number;
    private long count;
    private long size;
    private List<T> items;
}
