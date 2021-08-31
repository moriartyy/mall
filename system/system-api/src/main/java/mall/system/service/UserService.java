package mall.system.service;

import mall.system.service.dto.GetUserParams;
import mall.system.service.dto.UserInfo;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author walter
 */
public interface UserService {

    @RequestMapping(path = "orderMgmt/order/get")
    UserInfo get(GetUserParams getUserParams);
}
