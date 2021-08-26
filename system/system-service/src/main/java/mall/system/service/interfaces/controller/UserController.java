package mall.system.service.interfaces.controller;

import lombok.RequiredArgsConstructor;
import mall.system.service.api.UserService;
import mall.system.service.api.dto.UserGetParams;
import mall.system.service.api.dto.UserInfo;
import mall.web.service.annotation.RequestParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author walter
 */
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RestController
public class UserController implements UserService {

    private final UserService userService;

    @Override
    public UserInfo get(@RequestParams UserGetParams userGetParams) {
        return userService.get(userGetParams);
    }

}
