package cn.wisdsoft.electivesystem.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class index {
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String Index(){
        return "home_page/index";
    }
    @RequestMapping(value = "/login/first",method = RequestMethod.GET)
    public String Login(){
        return "home_page/first";
    }
}
