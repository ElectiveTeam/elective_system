package cn.wisdsoft.electivesystem.controller.administrator.achievement;

import cn.wisdsoft.electivesystem.pojo.Achievement;
import cn.wisdsoft.electivesystem.pojo.Rule;
import cn.wisdsoft.electivesystem.pojo.Teacher;
import cn.wisdsoft.electivesystem.pojo.utils.*;
import cn.wisdsoft.electivesystem.service.administrator.achievement.AchievementService;
import cn.wisdsoft.electivesystem.service.administrator.rule.RuleService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpRequest;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>ClassName: AchievementController</p>
 * <p>Description:成绩模块</p>
 *
 * @author 刘玉龙
 * @version 1.0
 * @date 2019/1/8 15:20
 */
@Controller
@RequestMapping(value = ElectiveSystemConfig.ACHIEVEMENT_MAPPING)
public class AchievementController {

    private final AchievementService achievementService;

    @Autowired
    public AchievementController(AchievementService achievementService) {
        this.achievementService = achievementService;
    }
    @Autowired
    private RuleService ruleService;


    @RequestMapping(value = "/test")
    public String test(){
        return "home_page/index";
    }
    @RequestMapping(value = "/")
    public String test2(){
        return "Achievement/achievement";
    }

    @RequestMapping(value = "/test1",method = RequestMethod.GET)
    @ResponseBody
    public PageResult getAllCurriculum(HttpSession session){
        List<Achievement> achievements = (List<Achievement>) session.getAttribute("achievements");
        session.removeAttribute("achievements");
        return PageResult.ok(achievements,achievements.size());
    }
    /*@RequestMapping(value = "/getAllCurriculum",method = RequestMethod.GET)
    @ResponseBody
    public ElectiveSystemResult getAllCurriculum(HttpSession session ,String key){
        Teacher teacher = (Teacher) session.getAttribute(key);
        if(teacher==null){
            return ElectiveSystemResult.build(400,"请登录");
        }
        return achievementService.getAllCurriculum(teacher.getTeacherId());
    }

    @RequestMapping(value = "/getStuBySelId",method = RequestMethod.GET)
    @ResponseBody
    public ElectiveSystemResult getStuBySelId(int selectId){
        return achievementService.getStuBySelId(selectId);
    }*/
    @RequestMapping(value = "/getAchieveById/{id}",method = RequestMethod.GET)
    public String getAchieveById(@PathVariable int id, Model model){
        Achievement achievement = achievementService.getById(id);
        System.out.println(achievement);
        Rule rule = ruleService.getRuleBySelectId(achievement.getSelectId());
        System.out.println(rule);
        model.addAttribute("achievement",achievement);
        model.addAttribute("rule",rule);
        return "Achievement/editachieve";
    }
    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    @ResponseBody
    public PageResult getAll(int selectId){
        return achievementService.getAll(selectId);
    }

    @RequestMapping(value = "/editStuAchieve",method = RequestMethod.POST)
    @ResponseBody
    public ElectiveSystemResult editStuAchieve(Achievement achievement){
        return achievementService.editStuAchieve(achievement);
    }

    @RequestMapping(value = "/saveAchieve",method = RequestMethod.POST)
    @ResponseBody
    public ElectiveSystemResult saveAchieve(int selectId){
        return achievementService.saveAchieve(selectId);
    }

    @RequestMapping(value = "/exportExcel")
    @ResponseBody
    public void exportExcel(String model, HttpServletResponse response){
        List list = JSONObject.parseArray(model, Achievement.class);
        System.out.println(list.get(1));
        Map<String,String> map = new LinkedHashMap<>();
        map.put("stuId","学号");
        map.put("stuName","姓名");
        map.put("usual","平时成绩");
        map.put("midterm","期中成绩");
        map.put("skill","技能考核");
        map.put("finalexam","期末成绩");
        map.put("achieve","总成绩");
        HSSFWorkbook excel = ExportUtil.createExcel("student", map);
        HSSFSheet oneHSSFSheet = null;
        try {
            oneHSSFSheet = Common.getOneHSSFSheet(excel, 0);
        } catch (Exception e) {
            System.out.println("没有工作簿");
        }
        try {
            ExportUtil.fillCell(excel,oneHSSFSheet,list);
            Common.getExcel(excel,"学生",response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/importExcel",method = RequestMethod.POST)
    @ResponseBody
    public ElectiveSystemResult importExcel(MultipartFile fileType, int selectId,HttpSession session){
        Rule rule = ruleService.getRuleBySelectId(selectId);
        int u = rule.getUsual();
        int m = rule.getMidterm();
        int s = rule.getSkill();
        int f = rule.getFinalexam();
        try {
            Workbook excel = ImportUtil.getExcel(fileType.getInputStream(), fileType.getOriginalFilename());
            List<List<Object>> listByExcel = ImportUtil.getListByExcel(excel);
            List<Achievement> achievements = new ArrayList<Achievement>();
            for (List list:listByExcel){
                int usual = Integer.parseInt(list.get(2).toString());
                int midterm = Integer.parseInt(list.get(3).toString());
                int skill = Integer.parseInt(list.get(4).toString());
                int finalexam = Integer.parseInt(list.get(5).toString());
                Achievement am = new Achievement();
                am.setStuId(list.get(0).toString());
                am.setStuName(list.get(1).toString());
                am.setUsual(usual);
                am.setMidterm(midterm);
                am.setSkill(skill);
                am.setFinalexam(finalexam);
                am.setAchieve((usual*u+midterm*m+skill*s+finalexam*f)/100);
                achievements.add(am);
            }
            session.setAttribute("achievements",achievements);
            return achievementService.insertExportList(achievements,selectId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ElectiveSystemResult.build(500,"导入失败");
    }
}
