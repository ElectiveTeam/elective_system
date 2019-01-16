package cn.wisdsoft.electivesystem.service.administrator.term;

import cn.wisdsoft.electivesystem.pojo.TermResource;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult;
import cn.wisdsoft.electivesystem.pojo.utils.PageResult;

/**
 * <p>ClassName: TermResourceService</p>
 * <p>Description:学期Service</p>
 *
 * @author 刘玉龙
 * @version 1.0
 * @date 2019/1/8 15:11
 */
public interface TermResourceService {
	
	/**
	 * 新建学期
	 * @param termResource 学期对象
	 * @return
	 */
	ElectiveSystemResult insertTermResource(TermResource termResource);
	
	/**
	 * 更新学期
	 * @param termResource 学期对象
	 * @return
	 */
	ElectiveSystemResult updateTermResource(TermResource termResource);
	/**
	 * 删除学期
	 * @param termResource 学期对象
	 * @return
	 */
	ElectiveSystemResult deleteTermResource(TermResource termResource);
	/**
	 * 学院查询状态
	 * @param termResource 学期对象
	 * @return
	 */
	ElectiveSystemResult statusTermResource(String college);
	
	/**
	 * 查询所有学院信息
	 * @return cn.wisdsoft.electivesystem.pojo.utils.PageResult<cn.wisdsoft.electivesystem.pojo.TermResource>
	 */
	PageResult<TermResource> findAll();
	/**
	 * 根据id查学期
	 * @param termResource 学期对象
	 * @return
	 */
	TermResource seleTermById(Integer id);
	
}
