package cn.wisdsoft.electivesystem.service.administrator.rule;

import cn.wisdsoft.electivesystem.pojo.Rule;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult;
import cn.wisdsoft.electivesystem.pojo.utils.PageResult;

public interface RuleService {
    public ElectiveSystemResult insert(Rule rule);
    public ElectiveSystemResult delRule(int id);
    public ElectiveSystemResult editRule(Rule rule);
    public Rule getRuleById(int id);
    public Rule getRuleBySelectId(int selectId);
    public PageResult getRuleByTeacherId(String teacherId,String cuName);
}
