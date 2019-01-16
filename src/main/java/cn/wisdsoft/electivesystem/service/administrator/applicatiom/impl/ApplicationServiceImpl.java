package cn.wisdsoft.electivesystem.service.administrator.applicatiom.impl;

import cn.wisdsoft.electivesystem.mapper.CourseMapper;
import cn.wisdsoft.electivesystem.mapper.CurriculumMapper;
import cn.wisdsoft.electivesystem.pojo.Curriculum;
import cn.wisdsoft.electivesystem.pojo.CurriculumExample;
import cn.wisdsoft.electivesystem.pojo.VO.Teacher;
import cn.wisdsoft.electivesystem.mapper.TermResourceMapper;
import cn.wisdsoft.electivesystem.pojo.*;
import cn.wisdsoft.electivesystem.pojo.VO.Teacher;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemConfig;
import cn.wisdsoft.electivesystem.pojo.utils.PageResult;
import cn.wisdsoft.electivesystem.service.administrator.applicatiom.ApplicationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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

    private final HttpServletRequest request;

    private final TermResourceMapper termResourceMapper;

    @Autowired
    public ApplicationServiceImpl(CurriculumMapper curriculumMapper, CourseMapper courseMapper, HttpServletRequest request, TermResourceMapper termResourceMapper) {
        this.curriculumMapper = curriculumMapper;
        this.courseMapper = courseMapper;
        this.request = request;
        this.termResourceMapper = termResourceMapper;
    }

    /**
     * 作用:查看所有审核并分页
     *
     * TODO 通过管理中获取权限查询学院
     * @param page  页数
     * @param limit 行数
     * @param key 个人令牌
     * @return cn.wisdsoft.electivesystem.pojo.utils.PageResult<cn.wisdsoft.electivesystem.pojo.Curriculum>
     * @date 9:47 2019/1/9
     */
    @Override
    public PageResult<Curriculum> findAllByPage(int page, int limit, String key) {
        HttpSession session = request.getSession();
        Teacher teacher = (Teacher) session.getAttribute("key");
        List<TermResource> termResources =
                termResourceMapper.selectByCollege(ElectiveSystemConfig.map.get(teacher.getTeaPower()));
        if (termResources == null || termResources.size() ==0) {
            return PageResult.ok(null, 0);
        }
        CourseExample courseExample = new CourseExample();
        CourseExample.Criteria courseExampleCriteria = courseExample.createCriteria();
        courseExampleCriteria.andTrIdEqualTo(termResources.get(0).getId());
        List<Course> courses = courseMapper.selectByExample(courseExample);
        List<Integer> couIds = new ArrayList<>();
        courses.forEach(course -> couIds.add(course.getId()));
        PageHelper.startPage(page, limit);
        CurriculumExample curriculumExample = new CurriculumExample();
        CurriculumExample.Criteria curriculumExampleCriteria
                = curriculumExample.createCriteria();
        curriculumExampleCriteria.andCouIdIn(couIds);
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
