package cn.wisdsoft.electivesystem.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import cn.wisdsoft.electivesystem.pojo.CurriculumPage;

@Repository
public interface CurriculumPageMapper {
	//入参教师id,申请状态，学期名称
	public List<CurriculumPage> selectCurriculumPage(@Param("teacherId") String teacherId,@Param("status") Integer status,@Param("termName") String termName);


}
