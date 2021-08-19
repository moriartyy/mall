package dmall.product.service.interfaces.controller;

import dmall.product.service.application.MessageManager;
import dmall.service.contract.api.ApiResult;
import dmall.service.contract.event.Event;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
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
    public ApiResult<Event> checkMessage() {
        return ApiResult.success((Event) messageManager.poll());
    }
}
