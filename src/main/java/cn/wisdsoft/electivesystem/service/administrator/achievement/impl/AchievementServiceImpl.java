package cn.wisdsoft.electivesystem.service.administrator.achievement.impl;

import cn.wisdsoft.electivesystem.mapper.AchievementMapper;
import cn.wisdsoft.electivesystem.pojo.Achievement;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult;
import cn.wisdsoft.electivesystem.pojo.utils.PageResult;
import cn.wisdsoft.electivesystem.service.administrator.achievement.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>ClassName: AchievementServiceImpl</p>
 * <p>Description:</p>
 *
 * @author 刘玉龙
 * @version 1.0
 * @date 2019/1/8 15:23
 */
@Service
public class AchievementServiceImpl implements AchievementService {

    @Autowired
    private AchievementMapper achievementMapper;

    public AchievementServiceImpl() {

    }

    /*@Override
    public ElectiveSystemResult getAllCurriculum(String teacherId) {
        return null;
    }

    @Override
    public ElectiveSystemResult getStuBySelId(int selectId) {
        return null;
    }*/

    @Override
    public Achievement getById(int id) {
        return achievementMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageResult getAll(int selectId) {
        List<Achievement> achievements = achievementMapper.getAll(selectId);
        int size = achievements.size();
        if (size>0){
            return PageResult.ok(achievements,size);
        }
        return null;
    }

    @Override
    public ElectiveSystemResult uploadAchieve(String[] stuId, int selectId, int[] achieve) {
        int size = stuId.length;
        int flag = 0;
        for (int i=0;i<size;i++){
            Achievement achievement = new Achievement();
            achievement.setAchieve(achieve[i]);
            achievement.setSelectId(selectId);
            achievement.setStuId(stuId[i]);
            achievement.setStatus(0);
            flag+=achievementMapper.insert(achievement);
        }
        if(flag==size){
            return ElectiveSystemResult.ok();
        }
        return ElectiveSystemResult.build(400,"录入失败");
    }

    @Override
    public ElectiveSystemResult editStuAchieve(Achievement achievement) {
        int flag = achievementMapper.updateByPrimaryKeySelective(achievement);
        if(flag>0){
            return ElectiveSystemResult.ok();
        }
        return ElectiveSystemResult.build(400,"修改失败");
    }

    @Override
    public ElectiveSystemResult saveAchieve(int selectId) {
        int flag = achievementMapper.saveAchieve(selectId);
        if(flag>0){
            return ElectiveSystemResult.ok();
        }
        return ElectiveSystemResult.build(400,"发布失败");
    }

    @Override
    public ElectiveSystemResult insertExportList(List<Achievement> list, int selectId) {
        int result = achievementMapper.insertExcelList(list,selectId);
        return ElectiveSystemResult.ok();
    }
}
