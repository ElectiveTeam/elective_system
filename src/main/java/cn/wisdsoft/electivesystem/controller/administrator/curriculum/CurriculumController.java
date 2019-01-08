package cn.wisdsoft.electivesystem.controller.administrator.curriculum;

import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemConfig;
import cn.wisdsoft.electivesystem.service.administrator.curriculum.CurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>ClassName: CurriculumController</p>
 * <p>Description:课程模块</p>
 *
 * @author 刘玉龙
 * @version 1.0
 * @date 2019/1/8 14:24
 */
@Controller
@RequestMapping(value = ElectiveSystemConfig.CURRICULUM_MAPPING)
public class CurriculumController {

    private final CurriculumService curriculumService;

    @Autowired
    public CurriculumController(CurriculumService curriculumService) {
        this.curriculumService = curriculumService;
    }
}
