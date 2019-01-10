package cn.wisdsoft.electivesystem.service.administrator.term.impl;

import cn.wisdsoft.electivesystem.mapper.TermResourceMapper;
import cn.wisdsoft.electivesystem.pojo.TermResource;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult;
import cn.wisdsoft.electivesystem.service.administrator.term.TermResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>ClassName: TermResourceServiceImpl</p>
 * <p>Description:</p>
 *
 * @author 刘玉龙
 * @version 1.0
 * @date 2019/1/8 15:12
 */
@Service
public class TermResourceServiceImpl implements TermResourceService {

    @Autowired
    private TermResourceMapper termResourceMapper;

    public TermResourceServiceImpl() {

    }

    /**
    * @Description: 查询所有学院，学期学年信息
    * @param: []
    * @return: cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult
    * @Author:  SongJunWei
    * @CreateDate:  2019/1/9 15:18
    */
    @Override
    public ElectiveSystemResult selectAllTerm() {
        List<TermResource> termResources = termResourceMapper.selectAllCource();
        if (termResources.size()<0)
            return ElectiveSystemResult.build(420,"暂未开放学期选课申请");

        return ElectiveSystemResult.ok(termResources);
    }
}
