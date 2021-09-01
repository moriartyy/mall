package mall.system.service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import mall.common.dto.PageInfo;
import mall.system.service.dto.*;
import mall.webservice.api.dto.Acknowledgement;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author walter
 */
@Api("user-service")
@FeignClient(name = "user-service")
public interface UserService {

    @ApiOperation(value = "save")
    @PostMapping(path = "user/save")
    Acknowledgement save(UserSaveParams userSaveParams);

    @ApiOperation(value = "get")
    @RequestMapping(path = "user/get", method = {RequestMethod.GET, RequestMethod.POST})
    UserInfo get(UserGetParams userGetParams);

    @ApiOperation(value = "delete")
    @PostMapping(path = "user/delete")
    Acknowledgement delete(UserDeleteParams userDeleteParams);

    @ApiOperation(value = "query")
    @PostMapping(path = "user/query")
    PageInfo<UserInfo> query(UserQueryParams userQueryParams);
}
