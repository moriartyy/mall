package mall.product.service.interfaces.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import mall.common.event.Event;
import mall.product.service.application.MessageManager;
import mall.webservice.api.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author walter
 */
@Api("Message")
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class MessageController {

    private final MessageManager messageManager;

    @RequestMapping(path = "message/check", method = {RequestMethod.GET, RequestMethod.POST})
    public Result<Event> checkMessage() {
        return Result.success((Event) messageManager.poll());
    }
}
