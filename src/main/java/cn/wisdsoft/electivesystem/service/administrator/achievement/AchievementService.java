package cn.wisdsoft.electivesystem.service.administrator.achievement;

import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult;

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
    public ElectiveSystemResult uploadAchieve(String stuId[],int selectId,int achieve[]);
    public ElectiveSystemResult editStuAchieve(String stuId,int selectId,int achieve);
    public ElectiveSystemResult saveAchieve(int selectId);
    public ElectiveSystemResult insertExportList(List<List<Object>> list,int selectId);
}
