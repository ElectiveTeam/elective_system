package cn.wisdsoft.electivesystem.service.teacher;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.wisdsoft.electivesystem.pojo.Course;
import cn.wisdsoft.electivesystem.pojo.Curriculum;
import cn.wisdsoft.electivesystem.pojo.CurriculumPage;
import cn.wisdsoft.electivesystem.pojo.Relationship;
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
	
	//查询学期资源表中当前学期处于申请状态的学院
	public List<TermResource> selectBytimetype();
	//查询学期资源表中学院名称去重
	public List<String> selectTermName();
	//根据学院查询课组
	public List<Course> selectByName(String term_id);
	//入参教师id,申请状态，学期名称
	public PageResult selectCurriculumPage(@Param("teacherId") String teacherId,@Param("status") Integer status,@Param("termName") String termName, int pageSize, int pageNum); 
	//更改申请状态由待申请转为未提交    1->0
	public int updateStatus (Curriculum record);
	//最新学期名称
	public String selectNew();
	//根据curriculum表的id查询当前学生的学号和姓名-----闫亮
	public List<Relationship> selectBycurriculumID (int curId);
	//王禹嘉----------
	public List<Curriculum> selectByTeacherId( int status,String teacherId);

}
