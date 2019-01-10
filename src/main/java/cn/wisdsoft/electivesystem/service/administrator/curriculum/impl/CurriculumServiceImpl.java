package cn.wisdsoft.electivesystem.service.administrator.curriculum.impl;

import cn.wisdsoft.electivesystem.mapper.CurriculumMapper;
import cn.wisdsoft.electivesystem.pojo.Curriculum;
import cn.wisdsoft.electivesystem.pojo.CurriculumExample;
import cn.wisdsoft.electivesystem.pojo.utils.PageResult;
import cn.wisdsoft.electivesystem.service.administrator.curriculum.CurriculumService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>ClassName: CurriculumServiceImpl</p>
 * <p>Description:</p>
 *
 * @author 刘玉龙
 * @version 1.0
 * @date 2019/1/8 15:11
 */
@Service
public class CurriculumServiceImpl implements CurriculumService {

    @Autowired
    private CurriculumMapper curriculumMapper;

    public CurriculumServiceImpl() {

    }


   /**
    * @Description: 根据分组编号，查询该分组下的课程
    * @param: [couId, pageNum, pageSize]
    * @return: cn.wisdsoft.electivesystem.pojo.utils.PageResult
    * @Author:  SongJunWei
    * @CreateDate:  2019/1/9 15:54
    */
    @Override
    public PageResult selectCurri(int couId,int pageNum,int PageSize) {
        PageHelper.startPage(pageNum,PageSize,"id desc");
        CurriculumExample example = new CurriculumExample();
        example.createCriteria().andCouIdEqualTo(couId);
        List<Curriculum> curricula = curriculumMapper.selectByExample(example);
        PageInfo pageInfo = new PageInfo(curricula);
        return PageResult.ok(curricula,pageInfo.getTotal());
    }
}
