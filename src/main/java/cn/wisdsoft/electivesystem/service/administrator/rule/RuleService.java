package cn.wisdsoft.electivesystem.service.administrator.rule;

import cn.wisdsoft.electivesystem.pojo.Rule;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult;

public interface RuleService {
    public ElectiveSystemResult insert(Rule rule);
}
