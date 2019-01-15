package cn.wisdsoft.electivesystem.controller.administrator.curriculum;

import cn.wisdsoft.electivesystem.pojo.Curriculum;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemConfig;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult;
import cn.wisdsoft.electivesystem.pojo.utils.PageResult;
import cn.wisdsoft.electivesystem.service.administrator.curriculum.CurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
     * 作用:添加课程
     *
     * @param termResource 课程对象
     * @return cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult
     * @date 14：18 2019/1/9
     */
    @RequestMapping(value = "/increase", method = RequestMethod.POST)
    @ResponseBody
    public ElectiveSystemResult increaseCurriculum(Curriculum curriculum) {
    	return curriculumService.increaseCurriculum(curriculum);
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
/**
     * 作用:修改课程
     *
     * @param termResource 课程对象
     * @return cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult
     * @date 14：18 2019/1/9
     */
    @RequestMapping(value = "/xiugai", method = RequestMethod.POST)
    @ResponseBody
    public ElectiveSystemResult xiugaiCurriculum(Curriculum curriculum) {
    	return curriculumService.xiugaiCurriculum(curriculum);
    }
    /**
     * 作用:查看
     *
     * @param termResource 课程对象  以及 分页功能
     * @return cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult
     * @date 17:07 2019/1/9
     */
    @RequestMapping(value = "/findAllByPage", method = RequestMethod.GET)
    @ResponseBody
    public PageResult<Curriculum> selectCurriculum(@RequestParam(value="page",defaultValue="1")int pageNum,
    									@RequestParam(value="limit",defaultValue="10")int pageSize){
    	return curriculumService.selectCurriculum(pageNum, pageSize);
    }
    
    @RequestMapping(value = "/toPage")
    public String toPage() {
    	return "curriculum/curriculum_list";
    }
}
