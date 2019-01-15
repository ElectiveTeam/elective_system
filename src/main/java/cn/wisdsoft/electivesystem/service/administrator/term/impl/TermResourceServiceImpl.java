package cn.wisdsoft.electivesystem.service.administrator.term.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.wisdsoft.electivesystem.mapper.CourseMapper;
import cn.wisdsoft.electivesystem.mapper.TermResourceMapper;
import cn.wisdsoft.electivesystem.pojo.CourseExample;
import cn.wisdsoft.electivesystem.pojo.TermResource;
import cn.wisdsoft.electivesystem.pojo.TermResourceExample;
import cn.wisdsoft.electivesystem.pojo.TermResourceExample.Criteria;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult;
import cn.wisdsoft.electivesystem.pojo.utils.PageResult;
import cn.wisdsoft.electivesystem.service.administrator.term.TermResourceService;

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
	
	@Autowired
    public TermResourceServiceImpl(TermResourceMapper termResourceMapper, CourseMapper courseMapper) {
		this.termResourceMapper = termResourceMapper;
		this.courseMapper = courseMapper;
    }

	@Override
	public ElectiveSystemResult insertTermResource(TermResource termResource) {
		termResourceMapper.insert(termResource);
		return ElectiveSystemResult.ok();
	}

	@Override
	public ElectiveSystemResult updateTermResource(TermResource termResource) {
		if(termResource.getStatus() == 1) {
			courseMapper.deleteCourseNotUse("软件学院");
//			CourseExample example = new CourseExample();
//			cn.wisdsoft.electivesystem.pojo.CourseExample.Criteria criteria = example.createCriteria();
//			criteria.andIdIn(list);
//			courseMapper.deleteByExample(example);
		}
		termResourceMapper.updateByPrimaryKey(termResource);
		return ElectiveSystemResult.ok();
	}

	@Override
	public ElectiveSystemResult deleteTermResource(TermResource termResource) {
		Integer id = 1;
		termResourceMapper.deleteByPrimaryKey(id);
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
		// TODO 自动生成的方法存根
		PageHelper.startPage(1, 1000);
		TermResourceExample example = new TermResourceExample();
		example.setOrderByClause("id desc");
		Criteria criteria = example.createCriteria();
		List<TermResource> termResources = termResourceMapper.selectByExample(example);
		PageInfo<TermResource> pageinfo = new PageInfo<>(termResources);
		return PageResult.ok(termResources, pageinfo.getTotal());
	}

	@Override
	public TermResource seleTermById(Integer id) {
		TermResource termResource = termResourceMapper.selectByPrimaryKey(id);
		return termResource;
	}
	

}
