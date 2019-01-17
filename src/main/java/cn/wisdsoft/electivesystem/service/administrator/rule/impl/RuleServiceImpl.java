package cn.wisdsoft.electivesystem.service.administrator.rule.impl;

import cn.wisdsoft.electivesystem.mapper.RuleMapper;
import cn.wisdsoft.electivesystem.pojo.Rule;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult;
import cn.wisdsoft.electivesystem.pojo.utils.PageResult;
import cn.wisdsoft.electivesystem.service.administrator.rule.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public ElectiveSystemResult delRule(int id) {
        int size = ruleMapper.deleteByPrimaryKey(id);
        if (size>0){
            return ElectiveSystemResult.ok();
        }
        return ElectiveSystemResult.build(500,"删除失败");
    }

    @Override
    public ElectiveSystemResult editRule(Rule rule) {
        int size = ruleMapper.updateByPrimaryKeySelective(rule);
        if (size>0){
            return ElectiveSystemResult.ok();
        }
        return ElectiveSystemResult.build(500,"修改失败");
    }

    @Override
    public Rule getRuleById(int id) {
        Rule rule = ruleMapper.selectByPrimaryKey(id);
        return rule;
    }

    @Override
    public Rule getRuleBySelectId(int selectId) {
        return ruleMapper.selectBySelectId(selectId);
    }

    @Override
    public PageResult getRuleByTeacherId(String teacherId,String cuName) {
        List<Rule> rules = ruleMapper.selByTeacherId(teacherId,cuName);
        int size = rules.size();
        if (size>0){
            return PageResult.ok(rules,size);
        }
        return PageResult.build(500,"暂无数据");
    }

    @Override
    public boolean check(int id) {
        Rule rule = ruleMapper.selectBySelectId(id);
        if (rule==null){
            return true;
        }
        return false;
    }
}
