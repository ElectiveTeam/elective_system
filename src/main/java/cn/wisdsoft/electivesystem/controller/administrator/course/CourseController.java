package cn.wisdsoft.electivesystem.controller.administrator.course;

import cn.wisdsoft.electivesystem.pojo.CourseVo;
import cn.wisdsoft.electivesystem.pojo.VO.Teacher;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemConfig;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult;
import cn.wisdsoft.electivesystem.pojo.utils.PageResult;
import cn.wisdsoft.electivesystem.service.administrator.course.CourseService;
import cn.wisdsoft.electivesystem.service.administrator.curriculum.CurriculumService;
import cn.wisdsoft.electivesystem.service.administrator.term.TermResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>ClassName: CourseController</p>
 * <p>Description:课程组模块</p>
 *
 * @author 刘玉龙
 * @version 1.0
 * @date 2019/1/8 14:19
 */
@Controller
@RequestMapping(value = ElectiveSystemConfig.COURSE_MAPPING)
public class CourseController {

    private final CourseService courseService;

    private final TermResourceService termResourceService;

    private final CurriculumService curriculumService;
    @Autowired
    public CourseController(CourseService courseService, TermResourceService termResourceService, CurriculumService curriculumService) {
        this.courseService = courseService;
        this.termResourceService = termResourceService;
        this.curriculumService = curriculumService;
    }


    /**
    * @Description: 查询所有分组
    * @return: cn.wisdsoft.electivesystem.pojo.utils.PageResult
    * @Author:  SongJunWei
    * @CreateDate:  2019/1/9 14:44
    */
    @RequestMapping(value = "/selectCource",method = RequestMethod.GET)
    @ResponseBody
    public PageResult SelectCourse(HttpSession session){
        Teacher teacher = (Teacher) session.getAttribute("key");
        String college = ElectiveSystemConfig.map.get(teacher.getTeaPower());
        PageResult pageResult = courseService.SelectCourceByCollege(college);
        return pageResult;
    }

    /**
     * @Description: 删除该学院的没有课程的课程分组
     * @param: [college] 学院名称
     * @return: cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult
     * @Author:  SongJunWei
     * @CreateDate:  2019/1/14 15:22
     */
    @RequestMapping(value = "/deleteCourseNotUse",method = RequestMethod.POST)
    @ResponseBody
    public ElectiveSystemResult deleteCourseNotUse(String college){
        ElectiveSystemResult electiveSystemResult = courseService.deleteCourseNotUse(college);
        return electiveSystemResult;
    }

    /**
    * @Description: 添加分组
    * @param: [course]
    * @return: cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult
    * @Author:  SongJunWei
    * @CreateDate:  2019/1/9 15:02
    */
//    @RequestMapping(value = "/insertCourse",method = RequestMethod.POST)
//    @ResponseBody
//    public ElectiveSystemResult insertCourse(Course course){
//        ElectiveSystemResult electiveSystemResult = courseService.insertCourse(course);
//        return electiveSystemResult;
//    }

//    /**
//     * 跳转增加分组页面
//     * @return
//     */
//    @RequestMapping("/JumpCourse")
//    public String JumpCourse(Model model){
//        ElectiveSystemResult electiveSystemResult = termResourceService.selectAllTerm();
//        model.addAttribute("term",electiveSystemResult);
//        return "/Course/insertCourse";
//    }

    /**
     * 跳转更改分组页面
     * @return
     */
    @RequestMapping("/courseEdit")
    public String updateCourse(Model model, String curId, String cuName, String courseName, HttpSession session){
        Teacher teacher = (Teacher) session.getAttribute("key");
        String college = ElectiveSystemConfig.map.get(teacher.getTeaPower());
        List<CourseVo> courseList = courseService.SelectAllCourse(college);
        model.addAttribute("courseList",courseList);
        model.addAttribute("cuName",cuName);
        model.addAttribute("curId",curId);
        model.addAttribute("courseName",courseName);
        return "Course/course_edit";
    }

    /**
    * @Description: 查看分组对应课程页面
    * @param: [couId, pageNum, pageSize]
    * @return: java.lang.String
    * @Author:  SongJunWei
    * @CreateDate:  2019/1/9 15:56
    */
    @RequestMapping("/SelectCurriculum")
    @ResponseBody
    public PageResult SelectCurriculumByCourse(int couId,
                                                @RequestParam(value = "page",defaultValue = "1")int pageNum,
                                               @RequestParam(value = "limit",defaultValue = "5") int pageSize){
        PageResult pageResult = curriculumService.selectCurri(couId,pageNum,pageSize);
        return pageResult;
    }

    /**
     * 跳转编辑分组页面
     * @return
     */
//    @RequestMapping("/courseEdit")
//    public String JumpCurriculum(){
//        return "/Course/course_edit";
//    }

    @RequestMapping("/")
    public String course(){
        return "/Course/course";
    }

}
