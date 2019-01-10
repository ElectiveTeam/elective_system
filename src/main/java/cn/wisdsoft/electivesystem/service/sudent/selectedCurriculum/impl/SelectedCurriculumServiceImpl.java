package cn.wisdsoft.electivesystem.service.sudent.selectedCurriculum.impl;

import cn.wisdsoft.electivesystem.mapper.CurriculumMapper;
import cn.wisdsoft.electivesystem.pojo.Curriculum;
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

    private final CurriculumMapper curriculumMapper;

    @Autowired
    public SelectedCurriculumServiceImpl(CurriculumMapper curriculumMapper) {
        this.curriculumMapper = curriculumMapper;
    }

    @Override
    public ElectiveSystemResult selectCurriculum(int curriculumId) {
        Curriculum curriculum = curriculumMapper.selectByPrimaryKey(curriculumId);
        return ElectiveSystemResult.ok(curriculum);
    }

    @Override
    public ElectiveSystemResult selectAllCurriculum(String termName) {
        return ElectiveSystemResult.ok(curriculumMapper.selectAllCurriculum(termName));
    }
}
