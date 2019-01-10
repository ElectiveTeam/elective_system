package cn.wisdsoft.electivesystem.mapper;

import cn.wisdsoft.electivesystem.pojo.Relationship;
import cn.wisdsoft.electivesystem.pojo.RelationshipExample;
import java.util.List;

import cn.wisdsoft.electivesystem.pojo.StudentDo;
import org.apache.ibatis.annotations.Param;

public interface RelationshipMapper {
    long countByExample(RelationshipExample example);

    int deleteByExample(RelationshipExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Relationship record);

    int insertSelective(Relationship record);

    List<Relationship> selectByExample(RelationshipExample example);

    Relationship selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Relationship record, @Param("example") RelationshipExample example);

    int updateByExample(@Param("record") Relationship record, @Param("example") RelationshipExample example);

    int updateByPrimaryKeySelective(Relationship record);

    int updateByPrimaryKey(Relationship record);

    /**
     * 查询学生已选课程
     * @param stuId  学生ID
     * @return  自定义Vo类
     */
    List<StudentDo> selectUserCurriculum(String stuId);

    /**
     * @Author 李泽宇
     * @Description 学生退课
     * @Date 2019/1/10 14:16
     * @Param stuId 学生id，selectId 选课id
     * @return
     **/
    int delRelationByStuIdAndSelectId(@Param("stuId") String stuId,@Param("selectId") int selectId);

}