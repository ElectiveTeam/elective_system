package cn.wisdsoft.electivesystem.service.administrator.achievement;

import cn.wisdsoft.electivesystem.pojo.Achievement;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult;
import cn.wisdsoft.electivesystem.pojo.utils.PageResult;

import java.util.List;

/**
 * <p>ClassName: AchievementService</p>
 * <p>Description:</p>
 *
 * @author 刘玉龙
 * @version 1.0
 * @date 2019/1/8 15:22
 */
public interface AchievementService {

    //public ElectiveSystemResult getAllCurriculum(String teacherId);
    //public ElectiveSystemResult getStuBySelId(int selectId);
    public Achievement getById(int id);
    public PageResult getAll(int selectId);
    public ElectiveSystemResult uploadAchieve(String stuId[],int selectId,int achieve[]);
    public ElectiveSystemResult editStuAchieve(Achievement achievement);
    public ElectiveSystemResult saveAchieve(int selectId);
    public ElectiveSystemResult insertExportList(List<Achievement> list, int selectId);
}
