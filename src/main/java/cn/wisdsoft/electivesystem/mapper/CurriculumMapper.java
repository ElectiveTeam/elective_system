package cn.wisdsoft.electivesystem.mapper;

import cn.wisdsoft.electivesystem.pojo.Curriculum;
import cn.wisdsoft.electivesystem.pojo.CurriculumDo;
import cn.wisdsoft.electivesystem.pojo.CurriculumExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CurriculumMapper {
    long countByExample(CurriculumExample example);

    int deleteByExample(CurriculumExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Curriculum record);

    int insertSelective(Curriculum record);

    List<Curriculum> selectByExampleWithBLOBs(CurriculumExample example);

    List<Curriculum> selectByExample(CurriculumExample example);

    Curriculum selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Curriculum record, @Param("example") CurriculumExample example);

    int updateByExampleWithBLOBs(@Param("record") Curriculum record, @Param("example") CurriculumExample example);

    int updateByExample(@Param("record") Curriculum record, @Param("example") CurriculumExample example);

    int updateByPrimaryKeySelective(Curriculum record);

    int updateByPrimaryKeyWithBLOBs(Curriculum record);

    int updateByPrimaryKey(Curriculum record);

    /**
     * 查询当前学期所有课程信息
     * @param termName  学期名称
     * @param category  课程类别
     * @return  包含课程信息的集合
     */
    List<CurriculumDo> selectAllCurriculum(@Param("termName") String termName,@Param("category") String category,@Param("grade") String grade);

    /**
     * 查询最大人数
     * @param curriculumId  课程ID
     * @return  返回最大人数
     */
    int selectMaxNumber(int curriculumId);
	 /**
     * 查询所有的课程 
     * @return
     */
    List<Curriculum> selectCurriculum();
    
    /**
     * 通过学院和状态查询所有课程
     * @param collegeName
     * @return
     */
    List<Curriculum> findCurriculumByCollegeNameAndStatus(@Param("collegeName") String collegeName);
    CurriculumDo selectDetails(int curriculumId);

}