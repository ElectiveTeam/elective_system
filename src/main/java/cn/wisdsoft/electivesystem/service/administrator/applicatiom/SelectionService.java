package cn.wisdsoft.electivesystem.service.administrator.applicatiom;

import cn.wisdsoft.electivesystem.pojo.CurriculumDo;
import cn.wisdsoft.electivesystem.pojo.Selection;

/**
 * <p>ClassName: SelectionService</p>
 * <p>Description:</p>
 *
 * @author 刘玉龙
 * @version 1.0
 * @date 2019/1/10 23:43
 */
public interface SelectionService {

    /**
     * 作用:增加选课
     *
     * @param selection 选课对象
     * @return int
     * @date 23:46 2019/1/10
     */
    int insertSelection(Selection selection);

    /**
     * 作用:通过课程编号查询课程信息
     *
     * @param id 课程编号
     * @return cn.wisdsoft.electivesystem.pojo.CurriculumDo
     * @date 14:16 2019/1/14
     */
    CurriculumDo findCurriculumDoById(int id);

    /**
     * 作用:更新选课信息
     *
     * @param selection 选课对象
     * @return int
     * @date 15:10 2019/1/14
     */
    int updateSelection(Selection selection);
}
