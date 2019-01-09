package cn.wisdsoft.electivesystem.service.sudent.personCenter.impl;

import cn.wisdsoft.electivesystem.mapper.RelationshipMapper;
import cn.wisdsoft.electivesystem.pojo.StudentDo;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult;
import cn.wisdsoft.electivesystem.service.sudent.personCenter.PersonCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName PersonCenterServiceImpl
 * @Description
 * @Author LIZEYU
 * @Date 2019/1/8 17:01
 * @Version 1.0
 **/

@Service
public class PersonCenterServiceImpl implements PersonCenterService {


    private final RelationshipMapper relationshipMapper;

    @Autowired
    public PersonCenterServiceImpl(RelationshipMapper relationshipMapper) {
        this.relationshipMapper = relationshipMapper;
    }

    @Override
    public ElectiveSystemResult selectUserCurriculum(String stuId) {
        List<StudentDo> studentDos = relationshipMapper.selectUserCurriculum(stuId);
        return ElectiveSystemResult.ok(studentDos);
    }
}
