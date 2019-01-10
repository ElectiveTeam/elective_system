package cn.wisdsoft.electivesystem.service.sudent.selectedCurriculum.impl;

import cn.wisdsoft.electivesystem.mapper.RelationshipMapper;
import cn.wisdsoft.electivesystem.pojo.Relationship;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult;
import cn.wisdsoft.electivesystem.service.sudent.selectedCurriculum.SelectedCurriculumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName SelectedCurriculumServiceImpl
 * @Description
 * @Author LIZEYU
 * @Date 2019/1/9 7:57
 * @Version 1.0
 **/

@Service
public class SelectedCurriculumServiceImpl implements SelectedCurriculumService {

    private final RelationshipMapper relationshipMapper;


    @Autowired
    public SelectedCurriculumServiceImpl(RelationshipMapper relationshipMapper) {
        this.relationshipMapper = relationshipMapper;
    }


    @Override
    public ElectiveSystemResult insertRelation(Relationship relationship) {
        int count = relationshipMapper.insert(relationship);
        if(count>0){
            return ElectiveSystemResult.ok("选课成功。");
        }
        return ElectiveSystemResult.ok("选课失败。");
    }
}
