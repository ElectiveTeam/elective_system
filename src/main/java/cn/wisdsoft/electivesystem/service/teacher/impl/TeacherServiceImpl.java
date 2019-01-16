package cn.wisdsoft.electivesystem.service.teacher.impl;

import cn.wisdsoft.electivesystem.mapper.CourseMapper;
import cn.wisdsoft.electivesystem.mapper.CurriculumMapper;
import cn.wisdsoft.electivesystem.mapper.CurriculumPageMapper;
import cn.wisdsoft.electivesystem.mapper.TermResourceMapper;
import cn.wisdsoft.electivesystem.pojo.Course;
import cn.wisdsoft.electivesystem.pojo.Curriculum;
import cn.wisdsoft.electivesystem.pojo.CurriculumPage;
import cn.wisdsoft.electivesystem.pojo.TermResource;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult;
import cn.wisdsoft.electivesystem.pojo.utils.PageResult;
import cn.wisdsoft.electivesystem.service.teacher.TeacherService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * <p>ClassName: TeacherServiceImpl</p>
 * <p>Description:</p>
 *
 * @author 刘玉龙
 * @version 1.0
 * @date 2019/1/8 9:19
 */
@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	TermResourceMapper trm;
	@Autowired
	CourseMapper cm;
	@Autowired
	CurriculumPageMapper clpm;
	@Autowired
	CurriculumMapper curriculumMapper;

    public TeacherServiceImpl() {

    }

	@Override
	public List<TermResource> selectBytimetype() {
		List<TermResource> termlist=trm.selectBytimetype();
		return termlist;
	}

	@Override
	public List<Course> selectByName(String course_name,String term_id) {
		List<Course> courselist=cm.selectByName(course_name,term_id);
		return courselist;
	}

	@Override
	public PageResult selectCurriculumPage(String teacherId, Integer status, String termName, int pageSize, int pageNum) {
		PageHelper.startPage(pageNum,pageSize);
		//根据教师id,申请状态，学期名称查询申请信息
    	List<CurriculumPage> cpList=clpm.selectCurriculumPage(teacherId, status, termName);
    	//分页
    	PageInfo<CurriculumPage> pageInfo = new PageInfo<>(cpList);
    	return PageResult.ok(cpList,pageInfo.getTotal());
	}

	@Override
	public List<Curriculum> selectByTeacherId(String teacherId) {
		return curriculumMapper.selByTeacherId(teacherId);
	}

}
