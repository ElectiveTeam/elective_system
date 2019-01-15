package cn.wisdsoft.electivesystem.controller.changepassword;

import cn.wisdsoft.electivesystem.pojo.VO.Teacher;
import cn.wisdsoft.electivesystem.pojo.utils.HttpClientUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class TeaChangePassword {
    @RequestMapping(value = "/TeaChangePassword",method = RequestMethod.GET)
    public String TeaChangePassword(String TeaId, Model model){
        System.out.println("========================================================");
        System.out.println(TeaId);
        System.out.println("========================================================");
        Teacher teacher = new Teacher();
        teacher.setWorknumber(TeaId);
        model.addAttribute("TeaId",TeaId);
        return "changepassword/teachangepassword";
    }

    @RequestMapping(value = "/TeaUpdatePassword",method = RequestMethod.POST)
    @ResponseBody
    public int StuUpdatePassword(String teaid,String password){
        HashMap<String,String> map = new HashMap<>();
        map.put("worknumber",teaid);
        map.put("teaPassword",password);

        String result = HttpClientUtil.doGet("http://192.168.6.180:8080/info/updatapassword",map);
        System.out.println("=============================================");
        System.out.println(result);
        System.out.println("=============================================");

        //        int i = Integer.parseInt(result);
//        if (i>0){
//            a =1;
//        }
        return 1;
    }
}
