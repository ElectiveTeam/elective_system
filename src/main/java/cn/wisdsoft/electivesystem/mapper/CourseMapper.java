package cn.wisdsoft.electivesystem.mapper;

import cn.wisdsoft.electivesystem.pojo.Course;
import cn.wisdsoft.electivesystem.pojo.CourseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseMapper {
    long countByExample(CourseExample example);

    int deleteByExample(CourseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Course record);

    int insertSelective(Course record);

    List<Course> selectByExample(CourseExample example);
    //根据课程名称模糊查询课组
    List<Course> selectByName(@Param("course_name") String course_name, @Param("tr_id")String term_id);

    Course selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Course record, @Param("example") CourseExample example);

    int updateByExample(@Param("record") Course record, @Param("example") CourseExample example);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);

    /**
     * 无条件查询所有的分组
     * @return
     */
    List<Course> SelectCource();

    int deleteCourseNotUse(@Param("college") String college);

    List<Integer> findCourseCount();
}