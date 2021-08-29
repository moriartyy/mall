package mall.system.service.interfaces.controller;

import lombok.RequiredArgsConstructor;
import mall.system.api.dto.UserGetParams;
import mall.system.api.dto.UserInfo;
import mall.system.api.service.UserService;
import mall.webservice.api.annotation.RequestParams;
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
