package cn.wisdsoft.electivesystem.controller.administrator.application;

import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemConfig;
import cn.wisdsoft.electivesystem.service.administrator.applicatiom.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>ClassName: ApplicationController</p>
 * <p>Description:管理员申请模块</p>
 *
 * @author 刘玉龙
 * @version 1.0
 * @date 2019/1/8 14:18
 */
@Controller
@RequestMapping(value = ElectiveSystemConfig.APPLICATION_MAPPING)
public class ApplicationController {

    private final ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }
}
