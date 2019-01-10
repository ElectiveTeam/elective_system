package cn.wisdsoft.electivesystem.controller.administrator.application;

import cn.wisdsoft.electivesystem.pojo.Curriculum;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemConfig;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult;
import cn.wisdsoft.electivesystem.pojo.utils.PageResult;
import cn.wisdsoft.electivesystem.service.administrator.applicatiom.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

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

    private final HttpServletRequest request;

    private final ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService, HttpServletRequest request) {
        this.applicationService = applicationService;
        this.request = request;
    }

    /**
     * 作用:
     *
     * @param page 页数
     * @param limit 行数
     * @return cn.wisdsoft.electivesystem.pojo.utils.PageResult<Curriculum>
     * @date 9:11 2019/1/9
     */
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    @ResponseBody
    public PageResult<Curriculum> findAllByPage(Integer page, Integer limit) {
        return applicationService.findAllByPage(page, limit);
    }

    /**
     * 作用:提交审核
     *
     * @param curriculum 课程基本信息对象
     * @return cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult
     * @date 9:56 2019/1/9
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public ElectiveSystemResult  insertCurriculum(Curriculum curriculum) {
        applicationService.insertCurriculum(curriculum);
        return ElectiveSystemResult.ok();
    }

    /**
     * 作用:进行审核
     *
     * @param id 课程编号
     * @param status 审核结果
     * @param reason 拒绝原因
     * @return cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult
     * @date 10:12 2019/1/9
     */
    @RequestMapping(value = "/review", method = RequestMethod.POST)
    @ResponseBody
    public ElectiveSystemResult reviewCurriculum(Integer id, Integer status,
                                                 @RequestParam(required = false) String reason) {
        applicationService.updateCurriculum(id, status, reason);
        return ElectiveSystemResult.ok();
    }
}
