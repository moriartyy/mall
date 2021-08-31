package mall.system.service.application;

import mall.system.service.UserService;
import mall.system.service.dto.GetUserParams;
import mall.system.service.dto.UserInfo;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

/**
 * @author walter
 */
@RestController
public class UserServiceImpl implements UserService {

    @Override
    public UserInfo get(GetUserParams getUserParams) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(getUserParams.getId());
        userInfo.setAmount(100);
        userInfo.setBuyer("tom");
        userInfo.setWhenPlaced(LocalDateTime.now());


        return userInfo;
    }

}
