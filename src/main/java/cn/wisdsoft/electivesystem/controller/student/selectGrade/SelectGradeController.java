package cn.wisdsoft.electivesystem.controller.student.selectGrade;


import cn.wisdsoft.electivesystem.pojo.Achievement;
import cn.wisdsoft.electivesystem.pojo.Rule;
import cn.wisdsoft.electivesystem.pojo.Student;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemConfig;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult;
import cn.wisdsoft.electivesystem.service.administrator.rule.RuleService;
import cn.wisdsoft.electivesystem.service.sudent.selectGrade.SelectGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = ElectiveSystemConfig.SELECTED_GRADE_MAPPING)
public class SelectGradeController {

    @Autowired
    private SelectGradeService selectGradeService;
    @Autowired
    private RuleService ruleService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    @ResponseBody
    public ElectiveSystemResult selectGrade(String stuId){
        return selectGradeService.selectGrade(stuId);
    }

    @RequestMapping(value = "/selDetails",method = RequestMethod.GET)
    @ResponseBody
    public ElectiveSystemResult selectGrade(String stuId,int selectId){
//        return selectGradeService.selectGrade(stuId);
        Achievement achievement = selectGradeService.selByStuIdAndSelId(stuId,selectId);
        Rule rule = ruleService.getRuleBySelectId(selectId);
        List list = new ArrayList();
        list.add(achievement);
        list.add(rule);
        return ElectiveSystemResult.ok(list);
    }


}
