package cn.wisdsoft.electivesystem.controller.administrator.achievement;

import cn.wisdsoft.electivesystem.pojo.Teacher;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemConfig;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult;
import cn.wisdsoft.electivesystem.service.administrator.achievement.AchievementService;
import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

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

    @RequestMapping(value = "/uploadAchieve",method = RequestMethod.POST)
    @ResponseBody
    public ElectiveSystemResult uploadAchieve(String stuId[],int selectId,int achieve[]){
        return achievementService.uploadAchieve(stuId,selectId,achieve);
    }

    @RequestMapping(value = "/editStuAchieve",method = RequestMethod.POST)
    @ResponseBody
    public ElectiveSystemResult editStuAchieve(int id,int achieve){
        return achievementService.editStuAchieve(id,achieve);
    }

    @RequestMapping(value = "/saveAchieve",method = RequestMethod.POST)
    @ResponseBody
    public ElectiveSystemResult saveAchieve(int selectId){
        return achievementService.saveAchieve(selectId);
    }

}
