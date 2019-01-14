package cn.wisdsoft.electivesystem.service.administrator.curriculum;

import cn.wisdsoft.electivesystem.pojo.Curriculum;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult;
import cn.wisdsoft.electivesystem.pojo.utils.PageResult;

/**
 * <p>ClassName: CurriculumService</p>
 * <p>Description:课程模块</p>
 *
 * @author 刘玉龙
 * @version 1.0
 * @date 2019/1/8 15:10
 */
public interface CurriculumService {

    PageResult selectCurri(int couId,int pageNum,int PageSize);

    ElectiveSystemResult updateCourse(Curriculum curriculum);
}
