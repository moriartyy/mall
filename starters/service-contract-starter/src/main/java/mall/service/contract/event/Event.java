package mall.service.contract.event;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

/**
 * @author walter
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class Event {
    private String id;
    private String version;
    private LocalDateTime whenCreated;

    protected Event(boolean autoInit) {
        if (autoInit) {
            this.id = UUID.randomUUID().toString();
            this.version = "1.0";
            this.whenCreated = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
        }
    }
}
