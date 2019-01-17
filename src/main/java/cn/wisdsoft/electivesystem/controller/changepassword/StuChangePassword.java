package cn.wisdsoft.electivesystem.controller.changepassword;


import cn.wisdsoft.electivesystem.pojo.VO.Student;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemConfig;
import cn.wisdsoft.electivesystem.pojo.utils.HttpClientUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping(value = ElectiveSystemConfig.STUDENT_LOGIN_MAPPING)
public class StuChangePassword {
    @RequestMapping(value = "/StuChangePassword",method = RequestMethod.GET)
    public String StuChangePassword(String StuId, Model model){
        Student student = new Student();
        student.setId(StuId);
        System.out.println("*****************************************************************");
        System.out.println(StuId);
        System.out.println("*****************************************************************");
        model.addAttribute("StuId",StuId);
        return "changepassword/stuchangepassword";
    }
    @RequestMapping(value = "/StuUpdatePassword",method = RequestMethod.POST)
    @ResponseBody
    public int StuUpdatePassword(String stuid,String oldpassword,String password){
        HashMap<String,String> map = new HashMap<>();
        map.put("id",stuid);
        map.put("oldPassword",oldpassword);
        map.put("stuPassword",password);
        int a =0;
        String i = HttpClientUtil.doGet("http://192.168.6.180:8080/info/updatastupassword",map);
        if (i!=null){
            a =1;
        }
        return a;
    }
}
