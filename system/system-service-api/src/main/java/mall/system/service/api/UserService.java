package mall.system.service.api;

import mall.system.service.api.dto.UserGetParams;
import mall.system.service.api.dto.UserInfo;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author walter
 */
public interface UserService {

    @RequestMapping(path = "orderMgmt/order/get")
    UserInfo get(UserGetParams userGetParams);
}
