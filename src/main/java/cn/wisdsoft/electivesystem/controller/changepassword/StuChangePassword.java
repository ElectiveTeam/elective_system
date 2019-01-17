package cn.wisdsoft.electivesystem.controller.changepassword;


import cn.wisdsoft.electivesystem.pojo.VO.Student;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemConfig;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult;
import cn.wisdsoft.electivesystem.pojo.utils.HttpClientUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping(value = ElectiveSystemConfig.STUDENT_LOGIN_MAPPING)
public class StuChangePassword {

    @RequestMapping(value = "/StuUpdatePassword",method = RequestMethod.POST)
    @ResponseBody
    public ElectiveSystemResult StuUpdatePassword(String stuid,String oldPassword,String newPassword){
        HashMap<String,String> map = new HashMap<>();
        map.put("id",stuid);
        map.put("oldPassword",oldPassword);
        map.put("stuPassword",newPassword);
        int a =0;
        String i = HttpClientUtil.doGet("http://192.168.6.180:8080/info/updatastupassword",map);
//        if (i!=null){
//            a =1;
//        }

        return JSONObject.parseObject(i, ElectiveSystemResult.class);
    }
}
