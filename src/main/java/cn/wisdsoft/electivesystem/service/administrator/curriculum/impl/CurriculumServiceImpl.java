package cn.wisdsoft.electivesystem.service.administrator.curriculum.impl;

import cn.wisdsoft.electivesystem.mapper.CurriculumMapper;
import cn.wisdsoft.electivesystem.pojo.Curriculum;
import cn.wisdsoft.electivesystem.pojo.CurriculumExample;
import cn.wisdsoft.electivesystem.pojo.VO.Teacher;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemConfig;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult;
import cn.wisdsoft.electivesystem.pojo.utils.PageResult;
import cn.wisdsoft.electivesystem.service.administrator.curriculum.CurriculumService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>ClassName: CurriculumServiceImpl</p>
 * <p>Description:</p>
 *
 * @author 刘玉龙
 * @version 1.0
 * @date 2019/1/8 15:11
 */
@Service
public class CurriculumServiceImpl implements CurriculumService {

	private final CurriculumMapper curriculumMapper;
	
	private final HttpServletRequest request;

	@Autowired
    public CurriculumServiceImpl(CurriculumMapper curriculumMapper, HttpServletRequest request) {
           this.curriculumMapper = curriculumMapper;
           this.request = request;
    }


   /**
    * @Description: 根据分组编号，查询该分组下的课程
    * @param: [couId, pageNum, pageSize]
    * @return: cn.wisdsoft.electivesystem.pojo.utils.PageResult
    * @Author:  SongJunWei
    * @CreateDate:  2019/1/9 15:54
    */
    @Override
    public PageResult selectCurri(int couId,int pageNum,int PageSize) {
        PageHelper.startPage(pageNum,PageSize,"id desc");
        CurriculumExample example = new CurriculumExample();
        example.createCriteria().andCouIdEqualTo(couId);
        List<Curriculum> curricula = curriculumMapper.selectByExample(example);
        PageInfo pageInfo = new PageInfo(curricula);
        return PageResult.ok(curricula,pageInfo.getTotal());
    }

    /**
    * @Description: 修改课程分组
    * @param: [curriculum]
    * @return: cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult
    * @Author:  SongJunWei
    * @CreateDate:  2019/1/10 20:08
    */
    @Override
    public ElectiveSystemResult updateCourse(Curriculum curriculum) {
        int count = curriculumMapper.updateByPrimaryKeySelective(curriculum);
        if(count<0){
            return ElectiveSystemResult.build(420,"修改失败");
        }
        return ElectiveSystemResult.ok();
    }
@Override
	public ElectiveSystemResult increaseCurriculum(Curriculum curriculum) {
		curriculumMapper.insert(curriculum);
		return ElectiveSystemResult.ok();
	}

	@Override
	public ElectiveSystemResult xiugaiCurriculum(Curriculum curriculum) {
		curriculumMapper.updateByPrimaryKey(curriculum);
		return ElectiveSystemResult.ok();
	}

	@Override
	public PageResult<Curriculum> selectCurriculum(int pageNum, int pageSize) {
		HttpSession session = request.getSession();
		Teacher teacher = (Teacher) session.getAttribute("key");
		PageHelper.startPage(pageNum, pageSize);
		List<Curriculum> curriList = curriculumMapper
				.findCurriculumByCollegeNameAndStatus(ElectiveSystemConfig.map.get(teacher.getTeaPower()));
		PageInfo<Curriculum> info = new PageInfo<>(curriList);
		return PageResult.ok(curriList, info.getTotal());
	}
}
