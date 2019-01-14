package cn.wisdsoft.electivesystem.controller.teacher;

import cn.wisdsoft.electivesystem.pojo.Teacher;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemConfig;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult;
import cn.wisdsoft.electivesystem.service.teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * <p>ClassName: TeacherController</p>
 * <p>Description:</p>
 *
 * @author 刘玉龙
 * @version 1.0
 * @date 2019/1/8 9:09
 */
@Controller
@RequestMapping(value = ElectiveSystemConfig.TEACHER_MAPPING)
public class TeacherController {

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @RequestMapping(value = "/selCurByTeaId",method = RequestMethod.GET)
    @ResponseBody
    public ElectiveSystemResult selectCurByTeacherId(HttpSession session,String key,int termId){
        Teacher teacher = (Teacher) session.getAttribute("key");
        if(teacher==null){
            return ElectiveSystemResult.build(500,"请登录");
        }
        return null;
    }
}
