package dmall.ddd.event;

import lombok.*;

import java.lang.reflect.ParameterizedType;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author walter
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Event<T> {
    private final String id;
    private final String version;
    private final String type;
    private final LocalDateTime whenCreated;

    @SuppressWarnings("unchecked")
    protected Event() {
        this.id = UUID.randomUUID().toString();
        Class<T> supperClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        this.type = EventUtils.resolveEventType(supperClass);
        this.version = "1.0";
        this.whenCreated = LocalDateTime.now();
    }
}
