package cn.wisdsoft.electivesystem.controller.student.selectedCurriculum;

import cn.wisdsoft.electivesystem.pojo.Relationship;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemConfig;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult;
import cn.wisdsoft.electivesystem.service.sudent.selectedCurriculum.SelectedCurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName SelectedCurriculumController
 * @Description
 * @Author LIZEYU
 * @Date 2019/1/8 16:55
 * @Version 1.0
 **/

@Controller
@RequestMapping(value = ElectiveSystemConfig.SELECTED_CURRICULUM_MAPPING)
public class SelectedCurriculumController {

    private final SelectedCurriculumService selectedCurriculumService;

    /**
     * @Author 李泽宇
     * @Description 注入业务层
     * @Date 2019/1/10 14:55
     * @Param
     * @return
     **/
    @Autowired
    public SelectedCurriculumController(SelectedCurriculumService selectedCurriculumService) {
        this.selectedCurriculumService = selectedCurriculumService;
    }

    /**
     * @Author 李泽宇
     * @Description 学生选课
     * @Date 2019/1/10 15:02
     * @Param
     * @return
     **/
    @RequestMapping(value = "/insertRelation",method = RequestMethod.GET)
    @ResponseBody
    public ElectiveSystemResult insertRelation(Relationship relationship) {
        ElectiveSystemResult electiveSystemResult = selectedCurriculumService.insertRelation(relationship);
        return electiveSystemResult;
    //如果已经选择该课程则无法选课
    //如果已经选择了相同课程组的其他一门课程则无法选课
    //如果系选课大于3门或院选课大于1门则无法选课
    //如果选课人数大于等于课程最大人数则无法选课
    }

}
