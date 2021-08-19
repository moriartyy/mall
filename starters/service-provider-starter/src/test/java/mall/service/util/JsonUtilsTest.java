package mall.service.util;


import lombok.Getter;
import mall.service.contract.event.Event;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author walter
 */
public class JsonUtilsTest {

    @Test
    public void serialize() {
//        String s = JsonUtil.serializeToString(new FinalFieldClass(2, "abc"));
//        System.out.println(s);
//        FinalFieldClass ffc = JsonUtil.deserializeFromString(s, FinalFieldClass.class);
//        assertEquals(2, ffc.getF1());
//        assertEquals("abc", ffc.getF2());

        System.out.println(JsonUtils.serializeToString(LocalDate.now()));
        System.out.println(JsonUtils.serializeToString(LocalTime.now()));

        TempEvent e = new TempEvent("sold");
        String s2 = JsonUtils.serializeToString(e);
        System.out.println(s2);
        TempEvent e2 = JsonUtils.deserializeFromString(s2, TempEvent.class);
        assertEquals(e.getId(), e2.getId());
        assertEquals(e.getWhenCreated(), e2.getWhenCreated());
        assertEquals(e.getTrigger(), e2.getTrigger());
    }


    @Getter
    public static class TempEvent extends Event {
        private String trigger;

        public TempEvent(String trigger) {
            super(true);
            this.trigger = trigger;
        }

        private TempEvent() {
            super(false);
        }
    }
}