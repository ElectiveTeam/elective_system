package cn.wisdsoft.electivesystem.controller.administrator.application;

import cn.wisdsoft.electivesystem.pojo.Curriculum;
import cn.wisdsoft.electivesystem.pojo.CurriculumDo;
import cn.wisdsoft.electivesystem.pojo.Selection;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemConfig;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult;
import cn.wisdsoft.electivesystem.service.administrator.applicatiom.ApplicationService;
import cn.wisdsoft.electivesystem.service.administrator.applicatiom.SelectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    public SelectionController(SelectionService selectionService, ApplicationService applicationService) {
        this.selectionService = selectionService;
        this.applicationService = applicationService;
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
    public ElectiveSystemResult insertSelection(@RequestBody Selection selection) {
        selectionService.insertSelection(selection);
        return ElectiveSystemResult.ok();
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
        return "curriculum/selection_add";
    }

    /**
     * 作用:根据课程编号查询课程信息
     *
     * @param id 课程编号
     * @return java.lang.String
     * @date 14:39 2019/1/14
     */
    @RequestMapping(value = "/selectionInfo/{id}", method = RequestMethod.GET)
    public String toInfo(@PathVariable Integer id, Model model) {
        CurriculumDo curriculumDo = selectionService.findCurriculumDoById(id);
        model.addAttribute("curriculum", curriculumDo);
        return "curriculum/selection_info";
    }

    @RequestMapping(value = "/updateSelection", method = RequestMethod.POST)
    public ElectiveSystemResult updateSelection(@RequestBody Selection selection) {
        selectionService.updateSelection(selection);
        return ElectiveSystemResult.ok();
    }
}
