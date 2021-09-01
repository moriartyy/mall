package mall.system.service.application;

import lombok.RequiredArgsConstructor;
import mall.common.dto.PageInfo;
import mall.core.domain.query.Criteria;
import mall.core.domain.query.PageQuery;
import mall.core.domain.query.PageQueryResult;
import mall.core.domain.query.QueryHelper;
import mall.core.transformation.ObjectTransformer;
import mall.core.util.CollectionUtils;
import mall.system.service.UserService;
import mall.system.service.domain.role.Role;
import mall.system.service.domain.role.RoleRepository;
import mall.system.service.domain.user.User;
import mall.system.service.domain.user.UserRepository;
import mall.system.service.dto.*;
import mall.webservice.api.dto.Acknowledgement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author walter
 */
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final ObjectTransformer objectTransformer;

    @Override
    public Acknowledgement save(UserSaveParams userSaveParams) {
        User user = objectTransformer.map(userSaveParams, User.class);
        this.userRepository.save(user);
        return Acknowledgement.YES;
    }

    @Override
    public UserInfo get(UserGetParams userGetParams) {
        User user = this.userRepository.get(userGetParams.getId());
        return assembleUserInfo(user);
    }

    private UserInfo assembleUserInfo(User user) {
        UserInfo userInfo = new UserInfo();
        objectTransformer.map(user, userInfo);
        List<Role> roles = this.roleRepository.findAll(Criteria.in("id", user.getRoles()));
        userInfo.setRoles(CollectionUtils.map(roles, r -> new UserRoleInfo().setRoleId(r.getId()).setRoleName(r.getName())));
        return userInfo;
    }

    @Override
    public Acknowledgement delete(UserDeleteParams userDeleteParams) {
        this.userRepository.delete(userDeleteParams.getId());
        return Acknowledgement.YES;
    }

    @Override
    public PageInfo<UserInfo> query(UserQueryParams userQueryParams) {
        PageQuery<User> query = QueryHelper.toPageQuery(userQueryParams);
        PageQueryResult<User> queryResult = this.userRepository.findAll(query);
        return PageInfo.<UserInfo>builder()
                .pageIndex(queryResult.getPageIndex())
                .pageSize(queryResult.getPageSize())
                .totalPages(queryResult.getTotalPages())
                .items(CollectionUtils.map(queryResult.getItems(), this::assembleUserInfo))
                .build();

    }

}
