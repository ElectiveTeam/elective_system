package cn.wisdsoft.electivesystem.service.sudent.personCenter;

import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult;

/**
 * The interface Person center service.
 *
 * @ClassName PersonCenterService
 * @Description
 * @Author LIZEYU
 * @Date 2019 /1/8 17:01
 * @Version 1.0
 */
public interface PersonCenterService {
    /**
     * Select user curriculum elective system result.
     * 查询学生已选课程
     *
     * @param stuId the stu id  学生ID（学号）
     * @return the elective system result
     */
    ElectiveSystemResult selectUserCurriculum(String stuId);

    /**
     * @Author 李泽宇
     * @Description 学生退课
     * @Date 2019/1/10 14:23
     * @Param
     * @return
     **/
    ElectiveSystemResult delRelationByStuIdAndSelectId(String stuId,int selectId);


}
