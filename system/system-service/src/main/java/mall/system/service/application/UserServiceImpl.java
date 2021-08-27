package mall.system.service.application;

import mall.system.api.dto.UserGetParams;
import mall.system.api.dto.UserInfo;
import mall.system.api.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * @author walter
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserInfo get(UserGetParams userGetParams) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(userGetParams.getId());
        userInfo.setAmount(100);
        userInfo.setBuyer("tom");
        userInfo.setWhenPlaced(LocalDateTime.now());


        return userInfo;
    }

}
