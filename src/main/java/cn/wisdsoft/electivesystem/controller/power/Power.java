package cn.wisdsoft.electivesystem.controller.power;

import cn.wisdsoft.electivesystem.pojo.VO.Teacher;
import cn.wisdsoft.electivesystem.pojo.utils.HttpClientUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class Power {
    @RequestMapping(value = "/power",method = RequestMethod.GET)
    public String Power(){
        return "power/power";
    }

    @RequestMapping(value = "/powersousuo",method = RequestMethod.GET)
    @ResponseBody
    public List<Teacher> PowerSousuo(String zhigonghao){
        System.out.println(zhigonghao);
        List<Teacher> teachers = new ArrayList<>();
        HashMap<String,String> map = new HashMap<>();
        map.put("worknumber",zhigonghao);
        String a = HttpClientUtil.doGet("http://192.168.6.180:8080/info/findTeacher",map);
        System.out.println("***************************************************************");
        System.out.println(a);
        System.out.println("***************************************************************");
        JSONObject jsonObject = JSONObject.parseObject(a);
        String result = jsonObject.get("data").toString();
        teachers = JSONObject.parseArray(result, cn.wisdsoft.electivesystem.pojo.VO.Teacher.class);
        System.out.println("====================================================================");
        System.out.println(teachers);
        System.out.println("====================================================================");
        
        return teachers;
    }

    @RequestMapping(value = "/powerupdata",method = RequestMethod.GET,produces = {"text/html;charset=utf-8"})
    @ResponseBody
    public String PowerUpdata(String worknumber,String teapower){
        HashMap<String,String> map = new HashMap<>();
        map.put("worknumber",worknumber);
        map.put("teapower",teapower);
        String a = HttpClientUtil.doGet("http://192.168.6.180:8080/info/updatePower",map);
        return "成功";
    }
}
