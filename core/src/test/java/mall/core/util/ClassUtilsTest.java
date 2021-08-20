package mall.core.util;

import mall.common.model.Event;
import mall.core.eventing.EventHandler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author walter
 */
class ClassUtilsTest {

    @Test
    void resolveGenericType() {
        DummyEventHandler h = new DummyEventHandler();
        assertEquals(DummyEvent.class, ClassUtils.resolveGenericType(h.getClass()));
        assertEquals(DummyEvent.class, h.getEventType());
    }

    public static class DummyEvent extends Event {

        protected DummyEvent() {
            super(true);
        }
    }

    public static class DummyEventHandler implements EventHandler<DummyEvent> {

        @Override
        public void handle(DummyEvent event) {

        }
    }

}