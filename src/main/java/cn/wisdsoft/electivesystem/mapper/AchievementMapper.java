package cn.wisdsoft.electivesystem.mapper;

import cn.wisdsoft.electivesystem.pojo.Achievement;
import cn.wisdsoft.electivesystem.pojo.AchievementExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AchievementMapper {
    long countByExample(AchievementExample example);

    int deleteByExample(AchievementExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Achievement record);

    int insertSelective(Achievement record);

    List<Achievement> selectByExample(AchievementExample example);

    Achievement selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Achievement record, @Param("example") AchievementExample example);

    int updateByExample(@Param("record") Achievement record, @Param("example") AchievementExample example);

    int updateByPrimaryKeySelective(Achievement record);

    int updateByPrimaryKey(Achievement record);

    int editStuAchieve(@Param("stuId")String stuId,@Param("selectId") int selectId, @Param("achieve")int achieve);

    int saveAchieve(int selectId);

    List<Achievement> selectGrade(String stuId);

    int insertExcelList(@Param("list") List list,@Param("selectId") int selectId);
}