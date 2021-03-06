package cn.wisdsoft.electivesystem.service.administrator.course;

import cn.wisdsoft.electivesystem.pojo.Course;
import cn.wisdsoft.electivesystem.pojo.CourseVo;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult;
import cn.wisdsoft.electivesystem.pojo.utils.PageResult;

import java.util.List;

/**
 * <p>ClassName: CourseService</p>
 * <p>Description:课程组模块</p>
 *
 * @author 刘玉龙
 * @version 1.0
 * @date 2019/1/8 15:09
 */
public interface CourseService {

    PageResult SelectCourceByCollege( String college);

    ElectiveSystemResult deleteCourseNotUse(String college) ;

    ElectiveSystemResult insertCourse(Course course);

    ElectiveSystemResult updateCource(Course course);

    List<CourseVo> SelectAllCourse(String college);
}
