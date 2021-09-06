package mall.service.util;

import mall.service.eventing.EventHandler;

/**
 * @author walter
 */
public class DummyEventHandler implements EventHandler<DummyEvent> {

    @Override
    public void handle(DummyEvent event) {

    }
}
