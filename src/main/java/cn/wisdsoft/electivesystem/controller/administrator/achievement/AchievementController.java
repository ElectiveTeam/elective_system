package cn.wisdsoft.electivesystem.controller.administrator.achievement;

import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemConfig;
import cn.wisdsoft.electivesystem.service.administrator.achievement.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
