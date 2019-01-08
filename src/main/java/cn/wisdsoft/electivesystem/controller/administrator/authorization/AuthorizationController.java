package cn.wisdsoft.electivesystem.controller.administrator.authorization;

import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemConfig;
import cn.wisdsoft.electivesystem.service.administrator.authorization.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>ClassName: AuthorizationController</p>
 * <p>Description:授权模块</p>
 *
 * @author 刘玉龙
 * @version 1.0
 * @date 2019/1/8 14:27
 */
@Controller
@RequestMapping(value = ElectiveSystemConfig.AUTHORIZATION_MAPPING)
public class AuthorizationController {

    private final AuthorizationService authorizationService;

    @Autowired
    public AuthorizationController(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }
}
