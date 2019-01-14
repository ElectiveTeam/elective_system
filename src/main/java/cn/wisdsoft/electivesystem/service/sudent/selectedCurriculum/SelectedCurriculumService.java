package cn.wisdsoft.electivesystem.service.sudent.selectedCurriculum;

import cn.wisdsoft.electivesystem.pojo.Relationship;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult;

import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult;

/**
 * The interface Selected curriculum service.
 *
 * @ClassName SelectedCurriculumService
 * @Description
 * @Author LIZEYU
 * @Date 2019 /1/9 7:55
 * @Version 1.0
 */
public interface SelectedCurriculumService {

    /**
     * Insert relation elective system result.
     * 插入选课信息
     *
     * @param stuId        the stu id  学生ID
     * @param stuName      the stu name  学生名称
     * @param curriculumId the curriculum id  课程ID
     * @param yard         the yard
     * @return the elective system result
     */
    ElectiveSystemResult insertRelation(String stuId,String stuName,int curriculumId,String yard);


    /**
     * Select curriculum elective system result.
     * 根据课程ID查询课程信息
     *
     * @param CurriculumId the curriculum id  课程ID
     * @return the elective system result  包含课程信息的JSON数据
     */
    ElectiveSystemResult selectCurriculum(int CurriculumId);

    /**
     * Select all curriculum list.
     * 查询当前学期所有课程信息
     *
     * @param termName the term name  学期名称
     * @param category the category  课程类别
     * @return the elective system result  包含课程信息的JSON数据
     */
    ElectiveSystemResult selectAllCurriculum(String termName,String category);

    /**
     * Choose status elective system result.
     * 判断学生时候可以选课
     *
     * @param category the category  课程类别
     * @return the elective system result  包含数据条数的JSON数据
     */
    ElectiveSystemResult selectStatus(String category);

    /**
     * Select curriculum now elective system result.
     * 查询学生当前学期已选课程
     *
     * @param stuId   the stu id  学生ID
     * @param college the college  学院名称
     * @return the elective system result  包含选课信息的JSON数据
     */
    ElectiveSystemResult selectCurriculumNow(String stuId,String college);
}
