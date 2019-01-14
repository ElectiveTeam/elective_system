package cn.wisdsoft.electivesystem.service.teacher.impl;

import cn.wisdsoft.electivesystem.mapper.CurriculumMapper;
import cn.wisdsoft.electivesystem.pojo.Curriculum;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult;
import cn.wisdsoft.electivesystem.service.teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>ClassName: TeacherServiceImpl</p>
 * <p>Description:</p>
 *
 * @author 刘玉龙
 * @version 1.0
 * @date 2019/1/8 9:19
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    public TeacherServiceImpl() {

    }

    @Autowired
    private CurriculumMapper curriculumMapper;

    @Override
    public ElectiveSystemResult selCurByTeaId(String teacherId) {
        int size = 0;
        List<Curriculum> curriculum = curriculumMapper.selCurByTeaId(teacherId);
        size = curriculum.size();
        if (size>0){
            return ElectiveSystemResult.ok(curriculum);
        }
        return null;
    }
}
