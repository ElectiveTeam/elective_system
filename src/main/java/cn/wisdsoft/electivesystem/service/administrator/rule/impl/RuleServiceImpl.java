package cn.wisdsoft.electivesystem.service.administrator.rule.impl;

import cn.wisdsoft.electivesystem.mapper.RuleMapper;
import cn.wisdsoft.electivesystem.pojo.Rule;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult;
import cn.wisdsoft.electivesystem.service.administrator.rule.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RuleServiceImpl implements RuleService {
    @Autowired
    private RuleMapper ruleMapper;

    @Override
    public ElectiveSystemResult insert(Rule rule) {
        int size = ruleMapper.insert(rule);
        if(size>0){
            return ElectiveSystemResult.ok();
        }
        return ElectiveSystemResult.build(500,"添加失败");
    }
}
