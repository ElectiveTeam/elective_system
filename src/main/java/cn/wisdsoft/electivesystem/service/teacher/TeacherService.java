package cn.wisdsoft.electivesystem.service.teacher;

import java.util.List;

import cn.wisdsoft.electivesystem.pojo.Curriculum;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult;
import org.apache.ibatis.annotations.Param;

import cn.wisdsoft.electivesystem.pojo.Course;
import cn.wisdsoft.electivesystem.pojo.CurriculumPage;
import cn.wisdsoft.electivesystem.pojo.TermResource;
import cn.wisdsoft.electivesystem.pojo.utils.PageResult;

/**
 * <p>ClassName: TeacherService</p>
 * <p>Description:</p>
 *
 * @author 刘玉龙
 * @version 1.0
 * @date 2019/1/8 9:17
 */
public interface TeacherService {

	//查询学期资源表中当前时间处于申请状态的学院
	public List<TermResource> selectBytimetype();
	//根据课程名称模糊查询课组
	public List<Course> selectByName(String course_name,String term_id);
	//入参教师id,申请状态，学期名称
	public PageResult selectCurriculumPage(@Param("teacherId") String teacherId,@Param("status") Integer status,@Param("termName") String termName, int pageSize, int pageNum);

	public List<Curriculum> selectByTeacherId( int status,String teacherId);
}
