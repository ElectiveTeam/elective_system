package cn.wisdsoft.electivesystem.controller.administrator.rule;

import cn.wisdsoft.electivesystem.pojo.Curriculum;
import cn.wisdsoft.electivesystem.pojo.Rule;
import cn.wisdsoft.electivesystem.pojo.VO.Teacher;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemConfig;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult;
import cn.wisdsoft.electivesystem.pojo.utils.PageResult;
import cn.wisdsoft.electivesystem.service.administrator.rule.RuleService;
import cn.wisdsoft.electivesystem.service.teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = ElectiveSystemConfig.RULE_MAPPING)
public class RuleController {
    private final RuleService ruleService;

    @Autowired
    public RuleController(RuleService ruleService) {
        this.ruleService = ruleService;
    }
    @Autowired
    private TeacherService teacherService;

    @RequestMapping(value = "/")
    public String rule(){
        return "Achievement/rule";
    }
    @RequestMapping(value = "/add")
    public String addrule(HttpSession session,Model model){
        Teacher teacher = (Teacher) session.getAttribute("key");

        if (teacher==null){
            return "home_page/login.jsp";
        }
        List<Curriculum> curriculumList = teacherService.selectByTeacherId(teacher.getWorknumber());
        model.addAttribute(curriculumList);
        return "Achievement/addrule";
    }

    @RequestMapping(value = "/getRule",method = RequestMethod.GET)
    @ResponseBody
    public PageResult getRuleByTeacherId(HttpSession session,String cuName){
        Teacher teacher = (Teacher) session.getAttribute("key");
        if(teacher==null){
            return PageResult.build(500,"请登录");
        }
        return ruleService.getRuleByTeacherId(teacher.getWorknumber(),cuName);
    }

    @RequestMapping(value = "/getRuleById/{id}",method = RequestMethod.GET)
    public String getRuleById(@PathVariable int id,Model model){
        Rule rule = ruleService.getRuleById(id);
        model.addAttribute(rule);
        System.out.println(rule);
        return "Achievement/editrule";
    }

    @RequestMapping(value = "/addRule",method = RequestMethod.POST)
    @ResponseBody
    public ElectiveSystemResult addRule(Rule rule){
        return ruleService.insert(rule);
    }

    @RequestMapping(value = "/editRuleById",method = RequestMethod.POST)
    @ResponseBody
    public ElectiveSystemResult editRuleById(Rule rule){
        return ruleService.editRule(rule);
    }

    @RequestMapping(value = "/delRule",method = RequestMethod.POST)
    @ResponseBody
    public ElectiveSystemResult delRule(int id){
        return ruleService.delRule(id);
    }
}
