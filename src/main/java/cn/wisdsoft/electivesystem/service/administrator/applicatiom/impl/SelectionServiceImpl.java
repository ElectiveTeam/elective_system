package cn.wisdsoft.electivesystem.service.administrator.applicatiom.impl;

import cn.wisdsoft.electivesystem.mapper.SelectionMapper;
import cn.wisdsoft.electivesystem.pojo.Selection;
import cn.wisdsoft.electivesystem.service.administrator.applicatiom.SelectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>ClassName: SelectionServiceImpl</p>
 * <p>Description:</p>
 *
 * @author 刘玉龙
 * @version 1.0
 * @date 2019/1/10 23:43
 */
@Service
public class SelectionServiceImpl implements SelectionService {

    private final SelectionMapper selectionMapper;

    @Autowired
    public SelectionServiceImpl(SelectionMapper selectionMapper) {
        this.selectionMapper = selectionMapper;
    }

    /**
     * 作用:增加选课
     *
     * @param selection 选课对象
     * @return int
     * @date 23:46 2019/1/10
     */
    @Override
    public int insertSelection(Selection selection) {
        if (selection.getStatus() != 0) {
            return 0;
        }
        return selectionMapper.insert(selection);
    }
}
