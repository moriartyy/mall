package dmall.product.service.interfaces.controller;

import dmall.product.service.application.MessageManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author walter
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MessageController {

    private final MessageManager messageManager;

    @RequestMapping(path = "message/check")
    public Object checkMessage() {
        return messageManager.poll();
    }
}
