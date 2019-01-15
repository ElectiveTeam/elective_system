package cn.wisdsoft.electivesystem.service.administrator.curriculum;

import cn.wisdsoft.electivesystem.pojo.Curriculum;
import cn.wisdsoft.electivesystem.pojo.TermResource;
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
/**
	 * 新建课程
	 * @param curriculum 课程对象
	 * @return
	 */
	ElectiveSystemResult increaseCurriculum(Curriculum curriculum);
	/**
	 * 修改课程
	 * @param curriculum 课程对象
	 * @return
	 */
	ElectiveSystemResult xiugaiCurriculum(Curriculum curriculum);
	
	/**
	 * 查询所有的课程信息 分页
	 * @param pageNum 页数
	 * @param pageSize 每页的条数
	 * @return
	 */
	PageResult<Curriculum> selectCurriculum(int pageNum,int pageSize);
}
