package cn.wisdsoft.electivesystem.mapper;

import cn.wisdsoft.electivesystem.pojo.Relationship;
import cn.wisdsoft.electivesystem.pojo.Statistics;
import cn.wisdsoft.electivesystem.pojo.TermResource;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface StatisticsMapper {
	/**
	 * 根据学期，学院统计选课情况统计表格
	 * @param college
	 * @param termName
	 * @return
	 */
	List<Statistics> findElective(@Param("college") String college,@Param("termName") String termName);

	/**
	 * 查询选课结束后的所有学期
	 * @return
	 */
	List<TermResource> findTerm();

	/**
	 * 根据学期，教师姓名，学院统计图表
	 * @param college
	 * @param termName
	 * @param teacherName
	 * @return
	 */
	List<Statistics> findElectiveEcharts(@Param("college") String college,@Param("termName") String termName,@Param("teacherName") String teacherName);

	/**
	 * 根据选课id查询所有选课的学生
	 * @param selectid
	 * @return
	 */
	List<Relationship> findStu(@Param("selectid") int selectid);
}
