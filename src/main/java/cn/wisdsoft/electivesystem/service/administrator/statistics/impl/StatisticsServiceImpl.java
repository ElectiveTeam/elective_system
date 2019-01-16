package cn.wisdsoft.electivesystem.service.administrator.statistics.impl;

import cn.wisdsoft.electivesystem.mapper.StatisticsMapper;
import cn.wisdsoft.electivesystem.pojo.Relationship;
import cn.wisdsoft.electivesystem.pojo.Statistics;
import cn.wisdsoft.electivesystem.pojo.TermResource;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult;
import cn.wisdsoft.electivesystem.pojo.utils.PageResult;
import cn.wisdsoft.electivesystem.service.administrator.statistics.StatisticsService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>ClassName: StatisticsServiceImpl</p>
 * <p>Description:</p>
 *
 * @author 刘玉龙
 * @version 1.0
 * @date 2019/1/8 15:26
 */
@Service
public class StatisticsServiceImpl implements StatisticsService {

    public StatisticsServiceImpl() {

    }
    
    @Autowired
    private StatisticsMapper statisticsMapper;

	/**
	 * 查询所有选课结束后的学期
	 * @return
	 */
	@Override
	public ElectiveSystemResult findTerm() {
		List<TermResource> TermList = statisticsMapper.findTerm();
		if (TermList != null){
			return ElectiveSystemResult.ok(TermList);
		}else{
			return ElectiveSystemResult.build(420,"没有查到数据");
		}

	}

	/**
	 * 根据学期、学院统计选课情况表格
	 * @param page
	 * @param limit
	 * @param college
	 * @param termName
	 * @return
	 */
	@Override
	public PageResult<Statistics> findElective(int page,int limit,String college, String termName) {
		PageHelper pageHelper = new PageHelper();
		String colleges = null;
		if(college.equals("1") ) {
			colleges = "校选";
		}else if(college.equals("HGXY0001")) {
			colleges = "软件学院";
		}else if(college.equals("HGXY0002")) {
			colleges = "建筑学院";
		}else if(college.equals("HGXY0003")) {
			colleges = "工程管理学院";
		}else if(college.equals("HGXY0004")) {
			colleges = "经济管理学院";
		}else if(college.equals("HGXY0005")) {
			colleges = "信息技术学院";
		}else if(college.equals("HGXY0006")) {
			colleges = "人文学院";
		}else if(college.equals("HGXY0007")) {
			colleges = "土木工程学院";
		}else if(college.equals("HGXY0008")) {
			colleges = "会计学院";
		}
		List<Statistics> electiveList = statisticsMapper.findElective(colleges, termName);
		/*System.out.println(electiveList);*/
		if(electiveList != null) {
			return PageResult.ok(electiveList,electiveList.size());
		}else {
			return PageResult.build(420, "没查到数据");
		}
		
	}

	/**
	 * 统计选课人数图表
	 * @param college
	 * @param termName
	 * @param teacherName
	 * @return
	 */
	@Override
	public ElectiveSystemResult findEleciveEcharts(String college, String termName, String teacherName) {
		String colleges = null;
		if(college.equals("1") ) {
			colleges = "校选";
		}else if(college.equals("HGXY0001")) {
			colleges = "软件学院";
		}else if(college.equals("HGXY0002")) {
			colleges = "建筑学院";
		}else if(college.equals("HGXY0003")) {
			colleges = "工程管理学院";
		}else if(college.equals("HGXY0004")) {
			colleges = "经济管理学院";
		}else if(college.equals("HGXY0005")) {
			colleges = "信息技术学院";
		}else if(college.equals("HGXY0006")) {
			colleges = "人文学院";
		}else if(college.equals("HGXY0007")) {
			colleges = "土木工程学院";
		}else if(college.equals("HGXY0008")) {
			colleges = "会计学院";
		}
		List<Statistics> electiveEchartsList = statisticsMapper.findElectiveEcharts(colleges,termName,teacherName);
		if (electiveEchartsList!=null){
			return ElectiveSystemResult.ok(electiveEchartsList);
		}else{
			return ElectiveSystemResult.build(420, "没查到数据");
		}
	}

	/**
	 * 查询某门课具体选课学生
	 * @param page
	 * @param limit
	 * @param selectid
	 * @return
	 */
	public PageResult<Relationship> findStu(int page,int limit,int selectid){
		List<Relationship> stuList = statisticsMapper.findStu(selectid);
		if(stuList != null){
			return PageResult.ok(stuList,stuList.size());
		}else{
			return PageResult.build(420, "没查到数据");
		}
	}

}
