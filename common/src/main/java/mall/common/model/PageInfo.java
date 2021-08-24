package mall.common.model;

import lombok.Data;

import java.util.List;

/**
 * @author walter
 */
@Data
public class PageInfo<T> {
    private long pageNo;
    private long pageSize;
    private long totalPages;
    private long totalItems;
    private List<T> items;
}
