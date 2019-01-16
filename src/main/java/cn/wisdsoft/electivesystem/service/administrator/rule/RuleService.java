package cn.wisdsoft.electivesystem.service.administrator.rule;

import cn.wisdsoft.electivesystem.pojo.Rule;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult;
import cn.wisdsoft.electivesystem.pojo.utils.PageResult;

public interface RuleService {
    //添加规则
    public ElectiveSystemResult insert(Rule rule);
    //删除规则
    public ElectiveSystemResult delRule(int id);
    //修改规则
    public ElectiveSystemResult editRule(Rule rule);
    //通过id查询规则详情
    public Rule getRuleById(int id);
    //通过选课Id查询规则
    public Rule getRuleBySelectId(int selectId);
    //通过教师Id和课程名查询规则
    public PageResult getRuleByTeacherId(String teacherId,String cuName);
}
