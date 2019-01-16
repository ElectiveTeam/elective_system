package cn.wisdsoft.electivesystem.mapper;

import cn.wisdsoft.electivesystem.pojo.TermResource;
import cn.wisdsoft.electivesystem.pojo.TermResourceExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TermResourceMapper {
    long countByExample(TermResourceExample example);

    int deleteByExample(TermResourceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TermResource record);

    int insertSelective(TermResource record);

    List<TermResource> selectByExample(TermResourceExample example);

    TermResource selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TermResource record, @Param("example") TermResourceExample example);

    int updateByExample(@Param("record") TermResource record, @Param("example") TermResourceExample example);

    int updateByPrimaryKeySelective(TermResource record);

    int updateByPrimaryKey(TermResource record);

    List<TermResource> selectAllCource();
//    TermResource seleTermById(Integer id);

    /*查询学期资源表中当前时间处于申请状态的学院*/
    List<TermResource> selectBytimetype();

    int selStatusBySelId(int selectId);
    /**查询本学院本学期的学期资源信息*/
    List<TermResource> selectByCollege(String college);

    int updateTermResourceByCloseTime();
}