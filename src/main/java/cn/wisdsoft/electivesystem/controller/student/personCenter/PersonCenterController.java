package cn.wisdsoft.electivesystem.controller.student.personCenter;

import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemConfig;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult;
import cn.wisdsoft.electivesystem.service.sudent.personCenter.PersonCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * The type Person center controller.
 *
 * @ClassName PersonCenterController
 * @Description
 * @Author LIZEYU
 * @Date 2019 /1/8 16:53
 * @Version 1.0
 */
@Controller
@RequestMapping(value = ElectiveSystemConfig.PERSON_CENTER_MAPPING)
public class PersonCenterController {
    private final PersonCenterService personCenterService;

    /**
     * Instantiates a new Person center controller.
     * 将业务层注入到控制层
     *
     * @param personCenterService the person center service
     */
    @Autowired
    public PersonCenterController(PersonCenterService personCenterService) {
        this.personCenterService = personCenterService;
    }

    /**
     * Select user curriculum elective system result.
     * 查询学生已选课程
     * 测试完成
     *
     * @param stuId the stu id  学生ID（学号）
     *
     * @return the elective system result  包含课程信息的JSON数据
     */
    @RequestMapping(value = "/selectUserCurriculum",method = RequestMethod.GET)
    @ResponseBody
    public ElectiveSystemResult selectUserCurriculum(String stuId) {
        return personCenterService.selectUserCurriculum(stuId);
    }

    /**
     * @Author 李泽宇
     * @Description 学生退课
     * 测试成功
     * @Date 2019/1/10 14:27
     * @Param
     * @return
     **/
    @RequestMapping(value = "/delRelationByStuIdAndSelectId",method = RequestMethod.GET)
    @ResponseBody
    public ElectiveSystemResult delRelationByStuIdAndSelectId(String stuId,int selectId) {
        return personCenterService.delRelationByStuIdAndSelectId(stuId,selectId);
    }
}
