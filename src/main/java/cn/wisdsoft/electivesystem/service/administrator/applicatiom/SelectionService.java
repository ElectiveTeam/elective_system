package cn.wisdsoft.electivesystem.service.administrator.applicatiom;

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
}
