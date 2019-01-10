package cn.wisdsoft.electivesystem.controller.student.selectedCurriculum;

import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemConfig;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult;
import cn.wisdsoft.electivesystem.service.sudent.selectedCurriculum.SelectedCurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * The type Selected curriculum controller.
 *
 * @ClassName SelectedCurriculumController
 * @Description
 * @Author LIZEYU
 * @Date 2019 /1/8 16:55
 * @Version 1.0
 */
@Controller
@RequestMapping(value = ElectiveSystemConfig.SELECTED_CURRICULUM_MAPPING)
public class SelectedCurriculumController {
    private final SelectedCurriculumService selectedCurriculumService;

    /**
     * Instantiates a new Selected curriculum controller.
     * 将业务层的类注入到控制层
     *
     * @param selectedCurriculumService the selected curriculum service
     */
    @Autowired
    public SelectedCurriculumController(SelectedCurriculumService selectedCurriculumService) {
        this.selectedCurriculumService = selectedCurriculumService;
    }

    /**
     * Select details elective system result.
     * 通过课程ID查询课程信息
     *
     * @param curriculumId the curriculum id  课程ID
     * @return the elective system result  包含课程信息的JSON数据
     */
    @RequestMapping("/selectDetails")
    @ResponseBody
    public ElectiveSystemResult selectDetails(int curriculumId) {
        return selectedCurriculumService.selectCurriculum(curriculumId);
    }

    /**
     * Select all curriculum elective system result.
     * 查询当前学期所有课程信息
     *
     * @param termName the term name  学期名称
     * @return the elective system result  包含课程信息的JSON数据
     */
    @RequestMapping("/selectAllCurriculum")
    @ResponseBody
    public ElectiveSystemResult selectAllCurriculum(String termName) {
        return selectedCurriculumService.selectAllCurriculum(termName);
    }
}
