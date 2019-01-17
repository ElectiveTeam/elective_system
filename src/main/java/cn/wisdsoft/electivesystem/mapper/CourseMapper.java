package cn.wisdsoft.electivesystem.mapper;

import cn.wisdsoft.electivesystem.pojo.Course;
import cn.wisdsoft.electivesystem.pojo.CourseExample;
import cn.wisdsoft.electivesystem.pojo.CourseVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CourseMapper {
    long countByExample(CourseExample example);

    int deleteByExample(CourseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Course record);

    int insertSelective(Course record);

    List<Course> selectByExample(CourseExample example);
    //根据学院查询课组，学院下的课组
    List<Course> selectByName(@Param("tr_id")String term_id);

    Course selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Course record, @Param("example") CourseExample example);

    int updateByExample(@Param("record") Course record, @Param("example") CourseExample example);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);

    /**
     * 查询本学期，该学院下，的所有的分组
     * @return
     */
    List<CourseVo> SelectCourceByCollege(@Param("college") String college);

    int deleteCourseNotUse(@Param("college") String college);

    List<Integer> findCourseCount();
}