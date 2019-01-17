package cn.wisdsoft.electivesystem.controller.power;

import cn.wisdsoft.electivesystem.pojo.VO.Teacher;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemConfig;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult;
import cn.wisdsoft.electivesystem.pojo.utils.HttpClientUtil;
import cn.wisdsoft.electivesystem.pojo.utils.PageResult;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
public class Power {
    @RequestMapping(value = "/power",method = RequestMethod.GET)
    public String Power(){
        return "power/power1";
    }

    @RequestMapping(value = "/powersousuo",method = RequestMethod.GET)
    @ResponseBody
    public PageResult PowerSousuo(String zhigonghao,@RequestParam(value = "page",defaultValue = "1") int page,
                                  @RequestParam(value = "limit",defaultValue = "10")int limit){
        List<Teacher> teachers = new ArrayList<Teacher>();
        HashMap<String,String> map = new HashMap<>();
        map.put("worknumber",zhigonghao);
        map.put("page",page+"");
        map.put("limit",limit+"");
        String a = HttpClientUtil.doGet("http://192.168.6.180:8080/info/findTeacher",map);
        PageResult pageResult = JSONObject.parseObject(a, PageResult.class);
        List<Teacher> data = JSONObject.parseArray(pageResult.getData().toString(), Teacher.class);
        data.forEach(teacher -> teacher.setTeaPower(ElectiveSystemConfig.map.get(teacher.getTeaPower())));
        pageResult.setData(data);
        return pageResult;
    }

    @RequestMapping(value = "/powersousuo1",method = RequestMethod.GET)
    @ResponseBody
    public String PowerSousuo1(String zhigonghao){
        HashMap<String,String> map = new HashMap<>();
        map.put("worknumber",zhigonghao);
        String a = HttpClientUtil.doGet("http://192.168.6.180:8080/info/findTeacher",map);
        return a;
    }

    @RequestMapping(value = "/powerupdata",method = RequestMethod.POST)
    @ResponseBody
    public ElectiveSystemResult PowerUpdata(String worknumber, String teapower){
        HashMap<String,String> map = new HashMap<>();
        map.put("worknumber",worknumber);
        map.put("teapower",teapower);
        String a = HttpClientUtil.doGet("http://192.168.6.180:8080/info/updatePower",map);
        return ElectiveSystemResult.ok();
    }

//    @RequestMapping(value = "/powerss", method = RequestMethod.GET)
//    @ResponseBody
//    public PageResult<Teacher> selectCurriculum(@RequestParam(value="page",defaultValue="1")int pageNum,
//                                                   @RequestParam(value="limit",defaultValue="10")int pageSize){
//        return curriculumService.selectCurriculum(pageNum, pageSize);
//    }
    @RequestMapping("/powerEdit")
    public String powerEdit(String param,Model model){
        Teacher teacher = JSONObject.parseObject(param, Teacher.class);

        model.addAttribute("params",teacher);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(teacher);
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        return "power/power_edit";
    }

}
