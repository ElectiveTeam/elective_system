package cn.wisdsoft.electivesystem.controller.administrator.application;

import cn.wisdsoft.electivesystem.pojo.Curriculum;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemConfig;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult;
import cn.wisdsoft.electivesystem.pojo.utils.PageResult;
import cn.wisdsoft.electivesystem.service.administrator.applicatiom.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 作用:
     *
     * @param page 页数
     * @param limit 行数
     * @param key 个人身份验证token
     * @return cn.wisdsoft.electivesystem.pojo.utils.PageResult<Curriculum>
     * @date 9:11 2019/1/9
     */
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    @ResponseBody
    public PageResult<Curriculum> findAllByPage(Integer page, Integer limit, String key) {
        return applicationService.findAllByPage(page, limit, key);
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

    /**
     * 作用:跳转显示页面
     *
     * @return java.lang.String
     * @date 22:25 2019/1/10
     */
    @RequestMapping(value = "/toPage", method = RequestMethod.GET)
    public String toPage() {
        return "curriculum/curriculum_list";
    }

    /**
     * 作用:跳转详情页面
     *
     * @param id 课程编号
     * @return java.lang.String
     * @date 22:53 2019/1/10
     */
    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    public String toReview(@PathVariable Integer id, Model model) {
        Curriculum curriculum = applicationService.findCurriculumById(id);
        model.addAttribute(curriculum);
        return "curriculum/curriculum_info";
    }
}
