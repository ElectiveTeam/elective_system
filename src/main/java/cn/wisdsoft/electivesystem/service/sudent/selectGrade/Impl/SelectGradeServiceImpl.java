package cn.wisdsoft.electivesystem.service.sudent.selectGrade.Impl;

import cn.wisdsoft.electivesystem.mapper.AchievementMapper;
import cn.wisdsoft.electivesystem.pojo.Achievement;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult;
import cn.wisdsoft.electivesystem.service.sudent.selectGrade.SelectGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SelectGradeServiceImpl implements SelectGradeService {
    @Autowired
    private AchievementMapper achievementMapper;

    @Override
    public ElectiveSystemResult selectGrade(String stuId) {
        List<Achievement> achievements = achievementMapper.selectGrade(stuId);
        int size = achievements.size();
        if(size>0){
            return ElectiveSystemResult.ok(achievements);
        }
        return ElectiveSystemResult.build(400,"查询失败");
    }
}
