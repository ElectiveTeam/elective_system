package cn.wisdsoft.electivesystem.controller.teacher;

import cn.wisdsoft.electivesystem.mapper.CourseMapper;
import cn.wisdsoft.electivesystem.mapper.CurriculumMapper;
import cn.wisdsoft.electivesystem.pojo.Course;
import cn.wisdsoft.electivesystem.pojo.Curriculum;
import cn.wisdsoft.electivesystem.pojo.CurriculumFu;
import cn.wisdsoft.electivesystem.pojo.TermResource;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemConfig;
import cn.wisdsoft.electivesystem.pojo.utils.PageResult;
import cn.wisdsoft.electivesystem.service.teacher.TeacherService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 闫亮
 * @version 1.0
 * @date 2018/1/9 10:48
 */
@Controller
@RequestMapping(value = ElectiveSystemConfig.TEACHER_MAPPING)
public class TeacherController {
	@Autowired
	TeacherService ts;
	@Autowired
	CurriculumMapper clm;
	@Autowired
	CourseMapper cm;

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @RequestMapping(value="/courseAdd",method=RequestMethod.GET)
    public String courseAdd(Model model) {
    	//查询当前时间内处于申请状态的学院
    	List<TermResource> termlist=ts.selectBytimetype();
    	model.addAttribute("termlist",termlist);
		return "teacher/courseAdd";
    }

    //测试
    @RequestMapping(value="/index",method=RequestMethod.GET)
    public String Index(Model model) {
		return "home_page/index";
    }

    @RequestMapping(value="/selectCourse",method=RequestMethod.POST)
    @ResponseBody
    public List<Course> selectCourse(String course_name,String term_id) {
    	System.out.println("course_name:"+course_name+"term_id:"+term_id);
    	//根据课程名称模糊查询相似课组名称且学期资源外键相同
    	List<Course> courseList=ts.selectByName(course_name,term_id);
    	System.out.println(courseList.get(0).getCourseName());
		return courseList;
    }

    @RequestMapping(value="/addCurriculum",method=RequestMethod.POST)
    @ResponseBody
    public String addCurriculum(@RequestBody CurriculumFu cf) {
    	Curriculum cl= new Curriculum();
    	cl.setCuName(cf.getCuName());
		cl.setTeacherId(cf.getTeacherId());
		cl.setClassHour(cf.getClassHour());
		cl.setCredit(cf.getCredit());
		cl.setDescribe(cf.getDescribe());
		cl.setGrade(cf.getGrade());
		cl.setStatus(cf.getStatus());
		cl.setCouId(cf.getCouId());
		System.out.println("*******************************************************************");
		System.out.println("cl.getCuName():"+cl.getCuName()+"cl.getTeacherId()"+cl.getTeacherId()+"cl.getClassHour()"+cl.getClassHour()+"cl.getCredit():"+cl.getCredit()+"cl.getDescribe():"+cl.getDescribe()+"cl.getGrade():"+cl.getGrade()+"cl.getStatus():"+cl.getStatus()+"cl.getCouId():"+cl.getCouId());
		//如果选择了课组
    	if(cl.getCouId() != 0) {
    		int ofn = clm.insertSelective(cl);
    		if(ofn>0) {
    			return "ok";
    		}
    	}else {
    		Course course= new Course();
    		course.setCourseName(cf.getCuName()+"教师姓名");
    		course.setTrId(cf.getTermId());
    		cm.insertSelective(course);//返回新增的课组主键,主键值已经赋值到领域模型实体的id中
    		System.out.println("课组主键"+course.getId());
    		cl.setCouId(course.getId());
    		//插入课程表
    		int ofn = clm.insertSelective(cl);
    		if(ofn>0) {
    			return "ok";
    		}
    	}
    	return "no";
    }

    //根据教师id,申请状态,学期名称查询申请信息
    //http://localhost:8080/teacher/selectCurriculumPage?teacherId=1&status=0&termName=2013-2014学年第1学期
    @RequestMapping(value="/selectCurriculumPage",method=RequestMethod.GET)
    @ResponseBody
    public PageResult selectCurriculumPage(String teacherId,
										    		Integer status,
										    		String termName,
										            @RequestParam(value = "page",defaultValue = "1") int pageNum,
										            @RequestParam(value = "limit",defaultValue = "10") int pageSize){
		return ts.selectCurriculumPage(teacherId, status, termName,pageSize,pageNum);
    }
}
