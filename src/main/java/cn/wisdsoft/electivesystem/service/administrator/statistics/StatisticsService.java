package cn.wisdsoft.electivesystem.service.administrator.statistics;

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
	 * 统计选课情况
	 * @param college
	 * @param termName
	 * @return
	 */
	PageResult<Statistics> findElective(int page,int limit,String college,String termName);
}
