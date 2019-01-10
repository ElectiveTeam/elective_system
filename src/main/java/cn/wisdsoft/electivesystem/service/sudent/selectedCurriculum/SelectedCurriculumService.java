package cn.wisdsoft.electivesystem.service.sudent.selectedCurriculum;

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
     * @return the elective system result  包含课程信息的JSON数据
     */
    ElectiveSystemResult selectAllCurriculum(String termName);
}
