package cn.wisdsoft.electivesystem.controller.administrator.application;

import cn.wisdsoft.electivesystem.pojo.Curriculum;
import cn.wisdsoft.electivesystem.pojo.Selection;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemConfig;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult;
import cn.wisdsoft.electivesystem.service.administrator.applicatiom.ApplicationService;
import cn.wisdsoft.electivesystem.service.administrator.applicatiom.SelectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>ClassName: SelectionController</p>
 * <p>Description:</p>
 *
 * @author 刘玉龙
 * @version 1.0
 * @date 2019/1/10 23:38
 */
@Controller
@RequestMapping(value = ElectiveSystemConfig.APPLICATION_MAPPING)
public class SelectionController {

    private final SelectionService selectionService;

    private final ApplicationService applicationService;

    private final HttpServletRequest request;

    @Autowired
    public SelectionController(SelectionService selectionService, ApplicationService applicationService, HttpServletRequest request) {
        this.selectionService = selectionService;
        this.applicationService = applicationService;
        this.request = request;
    }

    /**
     * 作用:添加选课，当data等于0时插入失败，否则成功
     *
     * @param selection 选课对象
     * @return cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult
     * @date 23:49 2019/1/10
     */
    @RequestMapping(value = "/insertSelection", method = RequestMethod.POST)
    @ResponseBody
    public ElectiveSystemResult insertSelection(Selection selection) {
        return ElectiveSystemResult.ok(selectionService.insertSelection(selection));
    }

    /**
     * 作用:跳转添加选课页面
     *
     * @param id 课程编号
     * @return java.lang.String
     * @date 23:54 2019/1/10
     */
    @RequestMapping(value = "/insertSelection/{id}", method = RequestMethod.GET)
    public String toInsertSelection(@PathVariable Integer id, Model model) {
        Curriculum curriculum = applicationService.findCurriculumById(id);
        model.addAttribute(curriculum);
        return "curriculum/selection_info";
    }
}
