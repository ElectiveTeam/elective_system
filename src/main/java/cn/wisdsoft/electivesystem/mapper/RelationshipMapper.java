package cn.wisdsoft.electivesystem.mapper;

import cn.wisdsoft.electivesystem.pojo.Relationship;
import cn.wisdsoft.electivesystem.pojo.RelationshipExample;
import java.util.List;

import cn.wisdsoft.electivesystem.pojo.StudentDo;
import cn.wisdsoft.electivesystem.pojo.TermResource;
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
     * @param termName  学期名称
     * @return 自定义Vo类 list
     */
    List<StudentDo> selectUserCurriculum(@Param("stuId") String stuId,@Param("termName") String termName);

    /**
     * @Author 李泽宇
     * @Description 学生退课
     * @Date 2019 /1/10 14:16
     * @Param stuId 学生id，selectId 选课id
     */
    int delRelationByStuIdAndSelectId(@Param("stuId") String stuId,@Param("selectId") int selectId);

    /**
     * Choose status int.
     * 判断学生是否可以选课
     *
     * @param category the category  学院类别
     * @return the term resource  返回包含开始时间和关闭时间的实体类
     */
    TermResource selectCollegeStatus(String category);

    /**
     * 查询是否可以选择校选课程
     * @return  返回包含开始时间和关闭时间的实体类
     */
    TermResource selectSchoolStatus();

    /**
     * Select choose status int.
     * 判断学生是否已选对应课程
     *
     * @param stuId        the stu id  学生ID
     * @param curriculumId the curriculum id  课程ID
     * @return the int  如果已选，返回1，否则返回0
     */
    int selectChooseStatus(@Param("stuId") String stuId,@Param("curriculumId") int curriculumId);

    /**
     * Select Selection Id int.
     * 通过课程ID查询选课ID
     *
     * @param curriculumId  课程ID
     * @return the int  返回对应的选课ID
     */
    int selectSelectionId(int curriculumId);

    /**
     * 查询该学生院选课的条数
     * @param yard  学院名称
     * @param stuId  学生ID
     * @return  返回选课条数
     */
    int selectYard(@Param("yard") String yard,@Param("stuId") String stuId);

    /**
     * 查询该学生校选课的条数
     * @param stuId  学生ID
     * @return  返回选课条数
     */
    int selectSchool(String stuId);

    /**
     * 查询学生选择的课程组
     * @param stuId  学生ID
     * @return  包含课程组ID的列表
     */
    List<Integer> checkCurriculum(String stuId);
}