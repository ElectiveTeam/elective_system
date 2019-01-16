package cn.wisdsoft.electivesystem.controller.student.selectedCurriculum;

import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemConfig;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult;
import cn.wisdsoft.electivesystem.service.sudent.selectedCurriculum.SelectedCurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
     *
     * @param selectedCurriculumService the selected curriculum service
     * @Author 李泽宇
     * @Description 注入业务层
     * @Date 2019 /1/10 14:55
     * @Param
     */
    @Autowired
    public SelectedCurriculumController(SelectedCurriculumService selectedCurriculumService) {
        this.selectedCurriculumService = selectedCurriculumService;
    }


    /**
     * Insert relation elective system result.
     * 插入学生选课信息
     * 测试成功
     *
     * @param stuId        the stu id  学生ID
     * @param stuName      the stu name  学生姓名
     * @param curriculumId the curriculum id  课程ID
     * @param yard         the yard  学院名称（除校选外）
     * @return the elective system result
     */
    @RequestMapping(value = "/insertRelation",method = RequestMethod.POST)
    @ResponseBody
    public ElectiveSystemResult insertRelation(String stuId,String stuName,int curriculumId,String yard) {
        //如果已经选择了相同课程组的其他一门课程则无法选课(前端做)
        return selectedCurriculumService.insertRelation(stuId, stuName, curriculumId, yard);
    }


    /**
     * Select details elective system result.
     * 通过课程ID查询课程信息
     * 测试成功
     *
     * @param curriculumId the curriculum id  课程ID
     * @return the elective system result  包含课程信息的JSON数据
     */
    @RequestMapping(value = "/selectDetails",method = RequestMethod.GET)
    @ResponseBody
    public ElectiveSystemResult selectDetails(int curriculumId) {
        return selectedCurriculumService.selectCurriculum(curriculumId);
    }

    /**
     * Select all curriculum elective system result.
     * 查询当前学期所有课程信息
     * 测试成功
     *
     * @param termName the term name  学期名称
     * @param category the category  课程类别
     * @return the elective system result  包含课程信息的JSON数据
     */
    @RequestMapping(value = "/selectAllCurriculum",method = RequestMethod.GET)
    @ResponseBody
    public ElectiveSystemResult selectAllCurriculum(String termName,String category) {
        return selectedCurriculumService.selectAllCurriculum(termName,category);
    }

    /**
     * Choose status elective system result.
     * 判断学生是否可以选课
     * 测试成功
     *
     * @param category the category  课程类别（除校选之外）
     * @return the elective system result  返回包含前台提示信息的JSON数据
     */
    @RequestMapping(value = "/chooseStatus",method = RequestMethod.GET)
    @ResponseBody
    public ElectiveSystemResult chooseStatus(String category) {
        return selectedCurriculumService.selectStatus(category);
    }

    /**
     * Chosen curriculum elective system result.
     * 查询学生当前学期选择课程
     *
     * @param stuId   the stu id  学生ID
     * @param college the college  学院名称
     * @return the elective system result  包含选课信息的JSON数据
     */
    @RequestMapping(value = "/chosenCurriculum",method = RequestMethod.GET)
    @ResponseBody
    public ElectiveSystemResult chosenCurriculum(String stuId,String college) {
        return selectedCurriculumService.selectCurriculumNow(stuId, college);
    }

	/**
     * Check curriculum elective system result.
     * 检查课程（查询学生选所有课程的ID）
     *
     * @param stuId the stu id  学生ID
     * @return the elective system result  返回包含课程组ID的JSON数据
     */
    @RequestMapping(value = "/checkCurriculum",method = RequestMethod.POST)
    @ResponseBody
    public ElectiveSystemResult checkCurriculum(String stuId) {
        return selectedCurriculumService.checkCurriculum(stuId);
    }
	
	
    @RequestMapping(value = "/selectTermName",method = RequestMethod.GET)
    @ResponseBody
    public ElectiveSystemResult selectTermName(String college) {
        return selectedCurriculumService.selectTermName(college);
    }
}
