package cn.wisdsoft.electivesystem.service.administrator.applicatiom.impl;

import cn.wisdsoft.electivesystem.mapper.CourseMapper;
import cn.wisdsoft.electivesystem.mapper.CurriculumMapper;
import cn.wisdsoft.electivesystem.mapper.SelectionMapper;
import cn.wisdsoft.electivesystem.pojo.*;
import cn.wisdsoft.electivesystem.service.administrator.applicatiom.SelectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    private final CurriculumMapper curriculumMapper;

    private final CourseMapper courseMapper;

    @Autowired
    public SelectionServiceImpl(SelectionMapper selectionMapper, CurriculumMapper curriculumMapper, CourseMapper courseMapper) {
        this.selectionMapper = selectionMapper;
        this.curriculumMapper = curriculumMapper;
        this.courseMapper = courseMapper;
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
       if (selection.getMinNumber() == null) {
           selection.setMinNumber(30);
       }
        Curriculum curriculum = new Curriculum();
        curriculum.setId(selection.getCuId());
        curriculum.setStatus(2);
        curriculumMapper.updateByPrimaryKeySelective(curriculum);
        return selectionMapper.insert(selection);
    }

    /**
     * 作用:通过课程编号查询课程信息
     *
     * @param id 课程编号
     * @return cn.wisdsoft.electivesystem.pojo.CurriculumDo
     * @date 14:16 2019/1/14
     */
    @Override
    public CurriculumDo findCurriculumDoById(int id) {
        //课程信息
        Curriculum curriculum = curriculumMapper.selectByPrimaryKey(id);
        CurriculumDo curriculumDo = new CurriculumDo();
        curriculumDo.setCurriculumName(curriculum.getCuName());
        curriculumDo.setTeacherName(curriculum.getTeacherName());
        curriculumDo.setClassHour(curriculum.getClassHour());
        curriculumDo.setGrade(curriculum.getGrade());
        curriculumDo.setDescribe(curriculum.getDescribe());
        curriculumDo.setCredit(curriculum.getCredit());
        //课程组名称
        Course course = courseMapper.selectByPrimaryKey(curriculum.getCouId());
        curriculumDo.setCourseName(course.getCourseName());
        //选课信息
        SelectionExample example = new SelectionExample();
        SelectionExample.Criteria criteria = example.createCriteria();
        criteria.andCuIdEqualTo(id);
        List<Selection> selections =
                selectionMapper.selectByExample(example);
        if (selections !=null && selections.size() != 0) {
            Selection selection = selections.get(0);
            curriculumDo.setSelectionId(selection.getId());
            curriculumDo.setClassTime(selection.getClassTime());
            curriculumDo.setPlace(selection.getPlace());
            curriculumDo.setMaxNumber(selection.getMaxNumber());
            curriculumDo.setMinNumber(selection.getMinNumber());
        }
        return curriculumDo;
    }

    /**
     * 作用:更新选课信息
     *
     * @param selection 选课对象
     * @return int
     * @date 15:10 2019/1/14
     */
    @Override
    public int updateSelection(Selection selection) {
        return selectionMapper.updateByPrimaryKeySelective(selection);
    }
}
