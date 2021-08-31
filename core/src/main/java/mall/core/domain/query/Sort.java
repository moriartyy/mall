package mall.core.domain.query;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author hongmiao.yu
 */
@Getter
public class Sort {

    private final List<Order> orders = new ArrayList<>();

    public void forEach(Consumer<Order> action) {
        this.orders.forEach(action);
    }

    private Sort() {
    }

    public boolean isEmpty() {
        return this.orders.isEmpty();
    }

    public Sort add(Order order) {
        this.orders.add(order);
        return this;
    }

    public static Sort of(String fieldName, Direction direction) {
        return new Sort().add(new Order(fieldName, direction));
    }

    public static Sort of() {
        return new Sort();
    }

    public static final Sort NULL = new Sort() {

        @Override
        public Sort add(Order order) {
            throw new UnsupportedOperationException();
        }
    };

    public enum Direction {
        ASC, DESC
    }

    @RequiredArgsConstructor
    @Getter
    public static class Order {
        private final String fieldName;
        private final Direction direction;

        public boolean isAsc() {
            return direction == Direction.ASC;
        }

        public boolean isDesc() {
            return direction == Direction.DESC;
        }
    }
}
