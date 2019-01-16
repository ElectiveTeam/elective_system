package cn.wisdsoft.electivesystem.controller.login;

import cn.wisdsoft.electivesystem.pojo.VO.Student;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemConfig;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult;
import cn.wisdsoft.electivesystem.pojo.utils.HttpClientUtil;
import cn.wisdsoft.electivesystem.pojo.utils.TokenUtil;
import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
@RequestMapping(value = ElectiveSystemConfig.STUDENT_LOGIN_MAPPING)
public class StudentLogin {
    @RequestMapping(value = "/StudentLogin",method = RequestMethod.POST)
    @ResponseBody
    public ElectiveSystemResult StudentLogin(String xuehao,String password,HttpSession session){
        HashMap<String,String> map = new HashMap<>();
        map.put("id",xuehao);
        map.put("stuPassword",password);
        String s = HttpClientUtil.doGet("http://192.168.6.180:8080/info/studentlogin",map);
        JSONObject jsonObject = JSONObject.parseObject(s);
        int status = Integer.parseInt(jsonObject.get("status").toString());
        if(status==200){
            String StudentKey = jsonObject.get("data").toString();
            TokenUtil tokenUtil = new TokenUtil();
            try {
                Claims claims = tokenUtil.parseJWT(StudentKey);
                String subject = claims.getSubject();
                JSONObject stu = JSONObject.parseObject(subject);
                Student student1 = JSONObject.parseObject(stu.get("student").toString(), Student.class);
                session.setAttribute(StudentKey,student1);
                return ElectiveSystemResult.ok(student1);
            } catch (Exception e) {
                e.printStackTrace();
                return ElectiveSystemResult.build(500,"服务器错误");
            }
        }else {
            return ElectiveSystemResult.build(421,"账号或密码错误");
        }
    }
}
