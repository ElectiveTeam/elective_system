package cn.wisdsoft.electivesystem.service.sudent.selectedCurriculum;

import cn.wisdsoft.electivesystem.pojo.Relationship;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult;

/**
 * @ClassName SelectedCurriculumService
 * @Description
 * @Author LIZEYU
 * @Date 2019/1/9 7:55
 * @Version 1.0
 **/
public interface SelectedCurriculumService {

    /**
     * @Author 李泽宇
     * @Description 学生选课
     * @Date 2019/1/10 14:48
     * @Param
     * @return
     **/
    ElectiveSystemResult insertRelation(Relationship relationship);


}
