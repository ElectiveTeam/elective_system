package cn.wisdsoft.electivesystem.pojo.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>ClassName: ElectiveSystemConfig</p>
 * <p>Description:</p>
 *
 * @author 刘玉龙
 * @version 1.0
 * @date 2019/1/8 9:11
 */
public class ElectiveSystemConfig {

    public final static String PERSON_CENTER_MAPPING = "/student/personCenter";
    public final static String SELECTED_CURRICULUM_MAPPING = "/student/selectedCurriculum";
    public final static String SELECTED_GRADE_MAPPING = "/student/selectedGrade";
    public final static String STUDENT_LOGIN_MAPPING = "/student/studentLogin";
    public final static String TEACHER_MAPPING = "/teacher";
    public final static String APPLICATION_MAPPING = "/application";
    public final static String COURSE_MAPPING = "/course";
    public final static String CURRICULUM_MAPPING = "/curriculum";
    public final static String AUTHORIZATION_MAPPING = "/authorization";
    public final static String TERM_MAPPING = "/term";
    public final static String ACHIEVEMENT_MAPPING = "/achievement";
    public final static String STATISTICS_MAPPING = "/statistics";
    public final static String RULE_MAPPING = "/rule";

    //编号对应的学院
    public final static Map<String, String> map = new HashMap<>();

    static {
    	map.put("HGXY0001", "软件学院");
    	map.put("HGXY0002", "建筑学院");
    	map.put("HGXY0003", "工程管理学院");
    	map.put("HGXY0004", "经济管理学院");
    	map.put("HGXY0005", "信息技术学院");
    	map.put("HGXY0006", "人文学院");
    	map.put("HGXY0007", "土木工程学院");
    	map.put("HGXY0008", "会计学院");
    	map.put("1", "校级管理");
    	map.put("0", "无权限");
    }

    public ElectiveSystemConfig() {

    }
}
