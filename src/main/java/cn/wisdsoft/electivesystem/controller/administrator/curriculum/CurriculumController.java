package cn.wisdsoft.electivesystem.controller.administrator.curriculum;

import cn.wisdsoft.electivesystem.pojo.Curriculum;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemConfig;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult;
import cn.wisdsoft.electivesystem.service.administrator.curriculum.CurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    /**
     * @Description: 更改课程分组
     * @param: [course]
     * @return: cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult
     * @Author:  SongJunWei
     * @CreateDate:  2019/1/9 17:45
     */
    @RequestMapping(value = "/UpdateCurriculum",method = RequestMethod.POST)
    @ResponseBody
    public ElectiveSystemResult updateCurriculum(Curriculum curriculum){
        System.out.println(curriculum.getId());
        ElectiveSystemResult updateCurriculum = curriculumService.updateCourse(curriculum);
        return updateCurriculum;
    }
}
