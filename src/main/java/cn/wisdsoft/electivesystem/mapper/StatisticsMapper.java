package cn.wisdsoft.electivesystem.mapper;

import cn.wisdsoft.electivesystem.pojo.Statistics;
import cn.wisdsoft.electivesystem.pojo.TermResource;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface StatisticsMapper {
	/**
	 * 根据学期，学院统计选课情况
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

}
