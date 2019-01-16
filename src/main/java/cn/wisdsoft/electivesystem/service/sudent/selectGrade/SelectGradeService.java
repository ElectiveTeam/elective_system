package cn.wisdsoft.electivesystem.service.sudent.selectGrade;

import cn.wisdsoft.electivesystem.pojo.Achievement;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult;

public interface SelectGradeService {
    public ElectiveSystemResult selectGrade(String stuId);
    public Achievement selByStuIdAndSelId(String stuId,int selectId);
}
