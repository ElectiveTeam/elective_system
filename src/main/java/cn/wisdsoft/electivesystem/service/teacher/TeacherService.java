package cn.wisdsoft.electivesystem.service.teacher;

import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult;

/**
 * <p>ClassName: TeacherService</p>
 * <p>Description:</p>
 *
 * @author 刘玉龙
 * @version 1.0
 * @date 2019/1/8 9:17
 */
public interface TeacherService {
    public ElectiveSystemResult selCurByTeaId(String teacherId);
}
