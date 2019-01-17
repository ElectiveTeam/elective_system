package cn.wisdsoft.electivesystem.service.sudent.selectedCurriculum.impl;

import cn.wisdsoft.electivesystem.mapper.CurriculumMapper;
import cn.wisdsoft.electivesystem.mapper.TermResourceMapper;
import cn.wisdsoft.electivesystem.pojo.*;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult;
import cn.wisdsoft.electivesystem.mapper.RelationshipMapper;
import cn.wisdsoft.electivesystem.service.sudent.selectedCurriculum.SelectedCurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

    private final TermResourceMapper termResourceMapper;

    @Autowired
    public SelectedCurriculumServiceImpl(CurriculumMapper curriculumMapper, RelationshipMapper relationshipMapper, TermResourceMapper termResourceMapper) {
        this.curriculumMapper = curriculumMapper;
        this.relationshipMapper = relationshipMapper;
        this.termResourceMapper = termResourceMapper;
    }

    @Override
    public ElectiveSystemResult selectCurriculum(int curriculumId) {
        CurriculumDo curriculumDo = curriculumMapper.selectDetails(curriculumId);
        return ElectiveSystemResult.ok(curriculumDo);
    }

    @Override
    public ElectiveSystemResult selectAllCurriculum(String termName, String category, String grade) {
        List<CurriculumDo> curriculumDos = curriculumMapper.selectAllCurriculum(termName, category, grade);
        if(curriculumDos.size() != 0) {
            CurriculumDo curriculumDo = curriculumDos.get(0);
            Date d = new Date();
            Date closeTime = curriculumDo.getCloseTime();
            Date openTime = curriculumDo.getOpenTime();
            if(closeTime == null || openTime == null) {
                return ElectiveSystemResult.build(900,"管理员失误导致的，请联系校方人员修复！");
            }
            if(d.compareTo(openTime) < 0 || d.compareTo(closeTime) > 0) {
                return ElectiveSystemResult.ok(new ArrayList<>());
            }
        }
        curriculumDos.forEach((curriculumDo -> {
            Integer curriculumId = curriculumDo.getCurriculumId();
            int selectionId = relationshipMapper.selectSelectionId(curriculumId);
            RelationshipExample example = new RelationshipExample();
            RelationshipExample.Criteria criteria = example.createCriteria();
            criteria.andSelectIdEqualTo(selectionId);
            long counts = relationshipMapper.countByExample(example);
            long maxNumber = curriculumDo.getMaxNumber();
            if(counts <= maxNumber * 0.25) {
                curriculumDo.setRemark("green");
            } else if(counts <= maxNumber * 0.5) {
                curriculumDo.setRemark("yellow");
            } else if (counts <= maxNumber * 0.8) {
                curriculumDo.setRemark("orange");
            } else if (counts < maxNumber) {
                curriculumDo.setRemark("red");
            } else {
                curriculumDo.setRemark("grey");
            }
        }));
        return ElectiveSystemResult.ok(curriculumDos);

    }

    @Override
    public ElectiveSystemResult selectStatus(String category) {
        TermResource termResource = relationshipMapper.selectCollegeStatus(category);
        TermResource termResource1 = relationshipMapper.selectSchoolStatus();
        Date open = null,close = null,open1 = null,close1 = null;
        Date now = new Date();
        if (termResource == null && termResource1 == null) {
            return ElectiveSystemResult.build(401, category+"选课功能暂未开放");
        }
        if(termResource != null) {
            open = termResource.getOpenTime();
            close = termResource.getCloseTime();
        }
        if(termResource1 != null) {
            open1 = termResource1.getOpenTime();
            close1 = termResource1.getCloseTime();
        }
        if(open != null && open1 != null) {
            Date o = open.compareTo(open1)>0?open1:open;
            Date c = close.compareTo(close1)>0?close:close1;
//            if (now.compareTo(o) < 0) {
//                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//                String openTime = sdf.format(o);
//                return ElectiveSystemResult.build(402, "选课时间将在"+openTime+"开启，请耐心等待");
//            }
//            if (now.compareTo(c) > 0) {
//                return ElectiveSystemResult.build(401, "选课功能暂未开放");
//            }
            judgeTime(now,o,c);
        } else if(open != null) {
            judgeTime(now,open,close);
        } else {
            judgeTime(now,open1,close1);
        }
        return ElectiveSystemResult.build(200, "可以选课");
    }

    @Override
    public ElectiveSystemResult selectCurriculumNow(String stuId, String college) {
        TermResourceExample example = new TermResourceExample();
        TermResourceExample.Criteria criteria = example.createCriteria();
        criteria.andCollegeEqualTo(college);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        criteria.andStatusIn(list);
        List<TermResource> termResources = termResourceMapper.selectByExample(example);
        TermResource termResource = termResources.get(0);
        String termName = termResource.getTermName();
        return ElectiveSystemResult.ok(relationshipMapper.selectUserCurriculum(stuId, termName));
    }

    @Override
    public ElectiveSystemResult selectTermName(String college) {
        TermResourceExample example = new TermResourceExample();
        TermResourceExample.Criteria criteria = example.createCriteria();
        criteria.andCollegeEqualTo(college);
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        criteria.andStatusIn(list);
        List<TermResource> termResources = termResourceMapper.selectByExample(example);
        return ElectiveSystemResult.ok(termResources.get(0));
    }
	
	@Override
    public ElectiveSystemResult checkCurriculum(String stuId) {
        return ElectiveSystemResult.ok(relationshipMapper.checkCurriculum(stuId));
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

    private ElectiveSystemResult judgeTime(Date now,Date o,Date c) {
        if (now.compareTo(o) < 0) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            String openTime = sdf.format(o);
            return ElectiveSystemResult.build(402, "选课时间将在"+openTime+"开启，请耐心等待");
        } else {
            return ElectiveSystemResult.build(401, "选课功能暂未开放");
        }
    }
}
