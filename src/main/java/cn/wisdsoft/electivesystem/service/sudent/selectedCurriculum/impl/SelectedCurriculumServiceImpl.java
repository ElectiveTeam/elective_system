package cn.wisdsoft.electivesystem.service.sudent.selectedCurriculum.impl;

import cn.wisdsoft.electivesystem.mapper.CurriculumMapper;
import cn.wisdsoft.electivesystem.pojo.*;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult;
import cn.wisdsoft.electivesystem.mapper.RelationshipMapper;
import cn.wisdsoft.electivesystem.service.sudent.selectedCurriculum.SelectedCurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName SelectedCurriculumServiceImpl
 * @Description
 * @Author LIZEYU
 * @Date 2019/1/9 7:57
 * @Version 1.0
 **/
@Service
public class SelectedCurriculumServiceImpl implements SelectedCurriculumService {

    private final CurriculumMapper curriculumMapper;

    private final RelationshipMapper relationshipMapper;

    @Autowired
    public SelectedCurriculumServiceImpl(CurriculumMapper curriculumMapper, RelationshipMapper relationshipMapper) {
        this.curriculumMapper = curriculumMapper;
        this.relationshipMapper = relationshipMapper;
    }

    @Override
    public ElectiveSystemResult selectCurriculum(int curriculumId) {
        Curriculum curriculum = curriculumMapper.selectByPrimaryKey(curriculumId);
        return ElectiveSystemResult.ok(curriculum);
    }

    @Override
    public ElectiveSystemResult selectAllCurriculum(String termName, String category) {
        List<CurriculumDo> curriculumDos = curriculumMapper.selectAllCurriculum(termName, category);
        curriculumDos.forEach((curriculumDo -> {
            Integer curriculumId = curriculumDo.getCurriculumId();
            int selectionId = relationshipMapper.selectSelectionId(curriculumId);
            RelationshipExample example = new RelationshipExample();
            RelationshipExample.Criteria criteria = example.createCriteria();
            criteria.andSelectIdEqualTo(selectionId);
            long counts = relationshipMapper.countByExample(example);
            curriculumDo.setRemark(counts < curriculumDo.getMaxNumber() ? "招生中" : "已招满");
        }));
        return ElectiveSystemResult.ok(curriculumDos);
    }

    @Override
    public ElectiveSystemResult selectStatus(String category) {
        TermResource termResource = relationshipMapper.selectStatus(category);
        if (termResource == null) {
            return ElectiveSystemResult.build(401, category+"选课功能暂未开放");
        }
        Date open = termResource.getOpenTime();
        Date close = termResource.getCloseTime();
        Date now = new Date();
        long l, day, hour, min;
        if (now.compareTo(open) < 0) {
            l = open.getTime() - now.getTime();
            day = l / (24 * 60 * 60 * 1000);
            hour = (l / (60 * 60 * 1000) - day * 24);
            min = ((l / (60 * 1000)) - day * 24 * 60 - hour * 60);
            return ElectiveSystemResult.build(402, "距离选课还有" + day + "天" + hour + "小时" + min + "分钟！");
        }
        if (now.compareTo(close) > 0) {
            return ElectiveSystemResult.build(401, "选课功能暂未开放");
        }
        return ElectiveSystemResult.build(200, "可以选课");
    }

    @Override
    public ElectiveSystemResult insertRelation(String stuId, String stuName, int curriculumId, String yard) {
        //通过课程ID查询选课ID
        int selectionId = relationshipMapper.selectSelectionId(curriculumId);
        //判断学生是否选过该课程
        int status = relationshipMapper.selectChooseStatus(stuId, curriculumId);
        switch (status) {
            case 1:
                return ElectiveSystemResult.build(403, "你已选过该课程!");
            case 0:
                //查询选课人数
                RelationshipExample example = new RelationshipExample();
                RelationshipExample.Criteria criteria = example.createCriteria();
                criteria.andSelectIdEqualTo(selectionId);
                long counts = relationshipMapper.countByExample(example);
                //查询最大人数
                int maxNumber = curriculumMapper.selectMaxNumber(curriculumId);
                if (counts == maxNumber) {
                    return ElectiveSystemResult.build(404, "该课程已选满!");
                }
                //查询院选课条数
                int yardNumbers = relationshipMapper.selectYard(yard, stuId);
                if (yardNumbers > 3) {
                    return ElectiveSystemResult.build(405, "你的院选课不得超过3门!");
                }
                //查询校选课条数
                int schoolNumbers = relationshipMapper.selectSchool(stuId);
                if (schoolNumbers > 1) {
                    return ElectiveSystemResult.build(406, "你的校选课不得超过1门!");
                }
                Relationship relationship = new Relationship();
                relationship.setSelectId(selectionId);
                relationship.setStuId(stuId);
                relationship.setStuName(stuName);
                relationshipMapper.insert(relationship);
                return ElectiveSystemResult.ok();
            default:
                return ElectiveSystemResult.build(900, "sql语句错误！");
        }
    }
}
