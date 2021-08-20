package mall.product.service.interfaces.controller;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import mall.common.model.Event;
import mall.product.service.application.MessageManager;
import mall.web.service.api.result.ApiResult;
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
