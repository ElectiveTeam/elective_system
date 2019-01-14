package cn.wisdsoft.electivesystem.controller.student.selectGrade;


import cn.wisdsoft.electivesystem.pojo.Student;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult;
import cn.wisdsoft.electivesystem.service.sudent.selectGrade.SelectGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/selectGrade")
public class SelectGradeController {

    @Autowired
    private SelectGradeService selectGradeService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    @ResponseBody
    //HttpSession session,String key
    public ElectiveSystemResult selectGrade(String stuId){
        /*Student student = (Student) session.getAttribute(key);
        if(student==null){
            return ElectiveSystemResult.build(400,"请登录");
        }
        return selectGradeService.selectGrade(student.getStudentId());*/
        return selectGradeService.selectGrade(stuId);
    }


}
