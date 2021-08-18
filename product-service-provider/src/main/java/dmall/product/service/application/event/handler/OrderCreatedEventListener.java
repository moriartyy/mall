//package dmall.product.service.application.event.handler;
//
//import dmall.order.service.contract.event.OrderCreatedEvent;
//import dmall.product.service.application.MessageManager;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
//import org.apache.rocketmq.spring.core.RocketMQListener;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
///**
// * @author walter
// */
//@Slf4j
//@Component
//@RocketMQMessageListener(topic = OrderCreatedEvent.TOPIC, consumerGroup = "product_service_c_" + OrderCreatedEvent.TOPIC)
//@RequiredArgsConstructor(onConstructor = @__(@Autowired))
//public class OrderCreatedEventListener implements RocketMQListener<OrderCreatedEvent> {
//
//    private final MessageManager messageManager;
//
//    @Override
//    public void onMessage(OrderCreatedEvent event) {
//        messageManager.offer(event);
//    }
//
//}
