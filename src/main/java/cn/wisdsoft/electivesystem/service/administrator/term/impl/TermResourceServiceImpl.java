package cn.wisdsoft.electivesystem.service.administrator.term.impl;

import cn.wisdsoft.electivesystem.mapper.CourseMapper;
import cn.wisdsoft.electivesystem.mapper.TermResourceMapper;
import cn.wisdsoft.electivesystem.pojo.TermResource;
import cn.wisdsoft.electivesystem.pojo.TermResourceExample;
import cn.wisdsoft.electivesystem.pojo.TermResourceExample.Criteria;
import cn.wisdsoft.electivesystem.pojo.VO.Teacher;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemConfig;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult;
import cn.wisdsoft.electivesystem.pojo.utils.PageResult;
import cn.wisdsoft.electivesystem.service.administrator.term.TermResourceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>ClassName: TermResourceServiceImpl</p>
 * <p>Description:</p>
 *
 * @author 刘玉龙
 * @version 1.0
 * @date 2019/1/8 15:12
 */
@Service
public class TermResourceServiceImpl implements TermResourceService {

	
	private final TermResourceMapper termResourceMapper;
	
	private final CourseMapper courseMapper;
	
	private final HttpServletRequest request;
	
	@Autowired
    public TermResourceServiceImpl(TermResourceMapper termResourceMapper, CourseMapper courseMapper, HttpServletRequest request) {
		this.termResourceMapper = termResourceMapper;
		this.courseMapper = courseMapper;
		this.request = request;
    }

	@Override
	public ElectiveSystemResult insertTermResource(TermResource termResource) {
		HttpSession session = request.getSession();
		Teacher teacher = (Teacher) session.getAttribute("key");
		termResource.setCollege(ElectiveSystemConfig.map.get(teacher.getTeaPower()));
		termResourceMapper.insert(termResource);
		return ElectiveSystemResult.ok();
	}

	@Override
	public ElectiveSystemResult updateTermResource(TermResource termResource) {
		if(termResource.getStatus() == 1) {
			HttpSession session = request.getSession();
			Teacher teacher = (Teacher) session.getAttribute("key");
			courseMapper.deleteCourseNotUse(ElectiveSystemConfig.map.get(teacher.getTeaPower()));
//			CourseExample example = new CourseExample();
//			cn.wisdsoft.electivesystem.pojo.CourseExample.Criteria criteria = example.createCriteria();
//			criteria.andIdIn(list);
//			courseMapper.deleteByExample(example);
		}
		termResourceMapper.updateByPrimaryKey(termResource);
		return ElectiveSystemResult.ok();
	}

	@Override
	public ElectiveSystemResult deleteTermResource(Integer termResource) {
	
		termResourceMapper.deleteByPrimaryKey(termResource);
		return ElectiveSystemResult.ok();
	}

	@Override
	public ElectiveSystemResult statusTermResource(String college) {
		TermResourceExample example = new TermResourceExample();
		Criteria criteria = example.createCriteria();
		criteria.andCollegeEqualTo(college);
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(3);
		criteria.andStatusIn(list);
		List<TermResource> rermResources = termResourceMapper.selectByExample(example);
		return rermResources == null || rermResources.size()==0 ? ElectiveSystemResult.ok(false) : ElectiveSystemResult.ok(true);
	}

	@Override
	public PageResult<TermResource> findAll() {
		HttpSession session = request.getSession();
		Teacher teacher = (Teacher) session.getAttribute("key");
		PageHelper.startPage(1, 1000,"id desc");
//		TermResourceExample example = new TermResourceExample();
//		example.setOrderByClause("id desc");
//		Criteria criteria = example.createCriteria();
//		criteria.andCollegeEqualTo("软件学院");
//		List<TermResource> termResources = termResourceMapper.selectByExample(example);
		List<TermResource> termResources = termResourceMapper.selectByCollege(ElectiveSystemConfig.map.get(teacher.getTeaPower()));
		PageInfo<TermResource> pageinfo = new PageInfo<>(termResources);
		return PageResult.ok(termResources, pageinfo.getTotal());
	}

	@Override
	public TermResource seleTermById(Integer id) {
		TermResource termResource = termResourceMapper.selectByPrimaryKey(id);
		return termResource;
	}
	

}
