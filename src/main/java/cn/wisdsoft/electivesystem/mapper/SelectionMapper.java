package cn.wisdsoft.electivesystem.mapper;

import cn.wisdsoft.electivesystem.pojo.Selection;
import cn.wisdsoft.electivesystem.pojo.SelectionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SelectionMapper {
    long countByExample(SelectionExample example);

    int deleteByExample(SelectionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Selection record);

    int insertSelective(Selection record);

    List<Selection> selectByExample(SelectionExample example);

    Selection selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Selection record, @Param("example") SelectionExample example);

    int updateByExample(@Param("record") Selection record, @Param("example") SelectionExample example);

    int updateByPrimaryKeySelective(Selection record);

    int updateByPrimaryKey(Selection record);
}