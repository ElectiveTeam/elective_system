package cn.wisdsoft.electivesystem.service.administrator.statistics;

import cn.wisdsoft.electivesystem.pojo.Relationship;
import cn.wisdsoft.electivesystem.pojo.Statistics;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult;
import cn.wisdsoft.electivesystem.pojo.utils.PageResult;

/**
 * <p>ClassName: StatisticsService</p>
 * <p>Description:统计模块</p>
 *
 * @author 刘玉龙
 * @version 1.0
 * @date 2019/1/8 15:26
 */
public interface StatisticsService {

	/**
	 * 查询所有学期
	 * @return
	 */
	ElectiveSystemResult findTerm();

	/**
	 * 统计选课情况表格
	 * @param college
	 * @param termName
	 * @return
	 */
	PageResult<Statistics> findElective(int page,int limit,String college,String termName);

	/**
	 * 统计选课人数图表
	 * @param college
	 * @param termName
	 * @param teacherName
	 * @return
	 */
	ElectiveSystemResult findEleciveEcharts(String college,String termName,String teacherName);

	/**
	 * 查询某门课选课的学生信息
	 * @param page
	 * @param limit
	 * @param selectid
	 * @return
	 */
	PageResult<Relationship> findStu(int page,int limit,int selectid);

	/**
	 * 根据id删除选课表和选课关系表
	 * @param selectid
	 * @return
	 */
	ElectiveSystemResult delSelection(Integer selectid);


}
