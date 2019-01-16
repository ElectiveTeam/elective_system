package cn.wisdsoft.electivesystem.controller.administrator.rule;

import cn.wisdsoft.electivesystem.pojo.Rule;
import cn.wisdsoft.electivesystem.pojo.Teacher;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemConfig;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult;
import cn.wisdsoft.electivesystem.pojo.utils.PageResult;
import cn.wisdsoft.electivesystem.service.administrator.rule.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = ElectiveSystemConfig.RULE_MAPPING)
public class RuleController {
    private final RuleService ruleService;

    @Autowired
    public RuleController(RuleService ruleService) {
        this.ruleService = ruleService;
    }

    @RequestMapping(value = "/")
    public String rule(){
        return "Achievement/rule";
    }
    
    @RequestMapping(value = "/add")
    public String addrule(){
        return "Achievement/addrule";
    }

//    @RequestMapping(value = "/getRule",method = RequestMethod.GET)
//    @ResponseBody
//    public PageResult getRuleByTeacherId(HttpSession session,String key,String cuName){
//        Teacher teacher = (Teacher) session.getAttribute(key);
//        if(teacher==null){
//            return PageResult.build(500,"请登录");
//        }
//        return ruleService.getRuleByTeacherId(teacher.getTeacherId(),cuName);
//    }
    @RequestMapping(value = "/getRule",method = RequestMethod.GET)
    @ResponseBody
    public PageResult getRuleByTeacherId(String teacherId,String cuName){
        return ruleService.getRuleByTeacherId(teacherId,cuName);
    }

    @RequestMapping(value = "/getRuleById/{id}",method = RequestMethod.GET)
    public String getRuleById(@PathVariable int id,Model model){
//        return ruleService.getRuleByIById(id);
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
