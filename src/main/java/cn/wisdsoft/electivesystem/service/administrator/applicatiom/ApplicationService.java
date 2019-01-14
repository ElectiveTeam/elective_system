package cn.wisdsoft.electivesystem.service.administrator.applicatiom;

import cn.wisdsoft.electivesystem.pojo.Curriculum;
import cn.wisdsoft.electivesystem.pojo.utils.PageResult;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <p>ClassName: ApplicationService</p>
 * <p>Description:</p>
 *
 * @author 刘玉龙
 * @version 1.0
 * @date 2019/1/8 15:05
 */
public interface ApplicationService {

    /**
     * 作用:查看所有审核并分页
     *
     * @param page 页数
     * @param limit 行数
     * @return cn.wisdsoft.electivesystem.pojo.utils.PageResult<cn.wisdsoft.electivesystem.pojo.Curriculum>
     * @date 9:47 2019/1/9
     */
    PageResult<Curriculum> findAllByPage(int page, int limit);

    /**
     * 作用:提交审核
     *
     * @param curriculum 课程对象
     * @return int
     * @date 10:01 2019/1/9
     */
    int insertCurriculum(Curriculum curriculum);

    /**
     * 作用:进行审核
     *
     * @param id 课程编号
     * @param status 审核结果
     * @param reason 拒绝原因呢
     * @return int
     * @date 10:14 2019/1/9
     */
    int updateCurriculum(Integer id, Integer status, @RequestParam(required = false) String reason);
}
