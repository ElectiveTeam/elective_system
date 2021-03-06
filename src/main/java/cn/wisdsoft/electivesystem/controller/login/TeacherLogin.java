package cn.wisdsoft.electivesystem.controller.login;

import cn.wisdsoft.electivesystem.pojo.VO.Teacher;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemConfig;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult;
import cn.wisdsoft.electivesystem.pojo.utils.HttpClientUtil;
import cn.wisdsoft.electivesystem.pojo.utils.TokenUtil;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping(value = ElectiveSystemConfig.TEACHER_MAPPING)
public class TeacherLogin {
    @RequestMapping(value = "/TeacherLogin",method = RequestMethod.POST)
    @ResponseBody
    public ElectiveSystemResult TeacherLogin(String worknumber, String teaPassword, HttpSession session){

        HashMap<String, String> map = new HashMap<>();
        map.put("worknumber", worknumber);
        map.put("teaPassword", teaPassword);
        String s = HttpClientUtil.doGet("http://192.168.6.180:8080/info/teacherlogin", map);
        String a = HttpClientUtil.doGet("http://192.168.6.180:8080/info/selectgrade");
        JSONObject jsonObject1 = JSONObject.parseObject(a);
        JSONArray array = jsonObject1.getJSONArray("data");
        List<String> grades=new ArrayList<String>();
        for(int i = 0; i < array.size(); i++){
            JSONObject o = array.getJSONObject(i);
            ((ArrayList) grades).add((String)o.get("name"));
        }
        session.setAttribute("grades",grades);

        JSONObject jsonObject = JSONObject.parseObject(s);
        int status = Integer.parseInt(jsonObject.get("status").toString());
        if(status==200){
            String TeacherKey = jsonObject.get("data").toString();
            TokenUtil tokenUtil = new TokenUtil();
            try {
                Claims claims = tokenUtil.parseJWT(TeacherKey);
                String subject = claims.getSubject();
                JSONObject tea = JSONObject.parseObject(subject);
                Teacher teacher1 = JSONObject.parseObject(tea.get("teacher").toString(), Teacher.class);
                session.setAttribute("key",teacher1);
                return ElectiveSystemResult.ok(teacher1);
            } catch (Exception e) {
                e.printStackTrace();
                return ElectiveSystemResult.build(500,"服务器错误");
            }

        }else {
            return ElectiveSystemResult.build(421,"账号或密码错误");
        }
    }
}
