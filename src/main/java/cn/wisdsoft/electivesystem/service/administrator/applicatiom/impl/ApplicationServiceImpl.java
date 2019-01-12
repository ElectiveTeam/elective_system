package cn.wisdsoft.electivesystem.service.administrator.applicatiom.impl;

import cn.wisdsoft.electivesystem.mapper.CourseMapper;
import cn.wisdsoft.electivesystem.mapper.CurriculumMapper;
import cn.wisdsoft.electivesystem.pojo.Curriculum;
import cn.wisdsoft.electivesystem.pojo.CurriculumExample;
import cn.wisdsoft.electivesystem.pojo.utils.PageResult;
import cn.wisdsoft.electivesystem.service.administrator.applicatiom.ApplicationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>ClassName: ApplicationServiceImpl</p>
 * <p>Description:</p>
 *
 * @author 刘玉龙
 * @version 1.0
 * @date 2019/1/8 15:06
 */
@Service
public class ApplicationServiceImpl implements ApplicationService {

    private final CurriculumMapper curriculumMapper;

    private final CourseMapper courseMapper;

    @Autowired
    public ApplicationServiceImpl(CurriculumMapper curriculumMapper, CourseMapper courseMapper) {
        this.curriculumMapper = curriculumMapper;
        this.courseMapper = courseMapper;
    }

    /**
     * 作用:查看所有审核并分页
     * TODO:根据条件分页
     *
     * @param page  页数
     * @param limit 行数
     * @return cn.wisdsoft.electivesystem.pojo.utils.PageResult<cn.wisdsoft.electivesystem.pojo.Curriculum>
     * @date 9:47 2019/1/9
     */
    @Override
    public PageResult<Curriculum> findAllByPage(int page, int limit) {
        PageHelper.startPage(page, limit);
        CurriculumExample curriculumExample = new CurriculumExample();
        CurriculumExample.Criteria curriculumExampleCriteria
                = curriculumExample.createCriteria();
        List<Curriculum> curricula = curriculumMapper.selectByExample(curriculumExample);
        PageInfo<Curriculum> pageInfo = new PageInfo<>(curricula);
        return PageResult.ok(curricula, pageInfo.getTotal());
    }

    /**
     * 作用:提交审核
     *
     * @param curriculum 课程对象
     * @return int
     * @date 10:01 2019/1/9
     */
    @Override
    public int insertCurriculum(Curriculum curriculum) {
        curriculum.setStatus(0);
        return curriculumMapper.insert(curriculum);
    }

    /**
     * 作用:进行审核
     *
     * @param id     课程编号
     * @param status 审核结果
     * @param reason 拒绝原因呢
     * @return int
     * @date 10:14 2019/1/9
     */
    @Override
    public int updateCurriculum(Integer id, Integer status, String reason) {
        Curriculum curriculum = new Curriculum();
        curriculum.setId(id);
        curriculum.setStatus(status);
        if (status == 3) {
            curriculum.setRemark(reason);
        } else {
            curriculum.setRemark(null);
        }
        return curriculumMapper.updateByPrimaryKeySelective(curriculum);
    }

    /**
     * 作用:通过课程编号查询信息
     *
     * @param id 课程编号
     * @return cn.wisdsoft.electivesystem.pojo.Curriculum
     * @date 22:31 2019/1/10
     */
    @Override
    public Curriculum findCurriculumById(int id) {
        Curriculum curriculum = curriculumMapper.selectByPrimaryKey(id);
        curriculum.setCourse(courseMapper.selectByPrimaryKey(curriculum.getCouId()));
        return curriculum;
    }
}
