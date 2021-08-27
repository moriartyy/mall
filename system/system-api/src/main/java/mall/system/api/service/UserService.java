package mall.system.api.service;

import mall.system.api.dto.UserGetParams;
import mall.system.api.dto.UserInfo;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author walter
 */
public interface UserService {

    @RequestMapping(path = "orderMgmt/order/get")
    UserInfo get(UserGetParams userGetParams);
}
