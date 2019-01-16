package cn.wisdsoft.electivesystem.service.administrator.course.impl;

import cn.wisdsoft.electivesystem.mapper.CourseMapper;
import cn.wisdsoft.electivesystem.pojo.Course;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult;
import cn.wisdsoft.electivesystem.pojo.utils.PageResult;
import cn.wisdsoft.electivesystem.service.administrator.course.CourseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.javassist.runtime.Desc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>ClassName: CourseServiceImpl</p>
 * <p>Description:</p>
 *
 * @author 刘玉龙
 * @version 1.0
 * @date 2019/1/8 15:09
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    public CourseServiceImpl() {

    }

    /**
    * @Description: 查询所有课程组信息
    * @param: [PageSize, PageNum]
    * @return: cn.wisdsoft.electivesystem.pojo.utils.PageResult
    * @Author:  SongJunWei
    * @CreateDate:  2019/1/8 19:23
    */
    @Override
    public PageResult SelectCource() {
//        PageHelper.startPage(PageNum,PageSize,"id desc");
        PageHelper.orderBy("id DESC");
        List<Course> courses = courseMapper.SelectCource();
        PageInfo pageInfo = new PageInfo(courses);
        return PageResult.ok(courses,pageInfo.getTotal());
    }

    /**
    * @Description: 删除该学院的没有课程的课程分组
    * @param: [college] 学院名称
    * @return: cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult
    * @Author:  SongJunWei
    * @CreateDate:  2019/1/14 15:22
    */
    @Override
    public ElectiveSystemResult deleteCourseNotUse(String college) {
        courseMapper.deleteCourseNotUse(college);
        return ElectiveSystemResult.ok();
    }

    /**
    * @Description: 增加分组
    * @param: [course]
    * @return: cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult
    * @Author:  SongJunWei
    * @CreateDate:  2019/1/9 15:00
    */
    @Override
    public ElectiveSystemResult insertCourse(Course course) {
        int count = courseMapper.insertSelective(course);
        if(count<0){
            return ElectiveSystemResult.build(420,"增加分组失败");
        }
        return ElectiveSystemResult.build(200,"增加分组成功");
    }

   /**
    * @Description: 更该分组成功
    * @param: [course]
    * @return: cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult
    * @Author:  SongJunWei
    * @CreateDate:  2019/1/9 17:39
    */
    @Override
    public ElectiveSystemResult updateCource(Course course) {
        int count = courseMapper.updateByPrimaryKeySelective(course);
        if(count<0){
            return ElectiveSystemResult.build(420,"更改失败");
        }
        return ElectiveSystemResult.build(200,"更改分组成功");
    }

    @Override
    public List<Course> SelectAllCourse() {
        List<Course> courseList = courseMapper.SelectCource();
        return courseList;
    }
}
