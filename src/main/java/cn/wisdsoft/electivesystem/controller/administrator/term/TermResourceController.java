package cn.wisdsoft.electivesystem.controller.administrator.term;

import cn.wisdsoft.electivesystem.pojo.TermResource;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemConfig;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult;
import cn.wisdsoft.electivesystem.service.administrator.term.TermResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>ClassName: TermResourceController</p>
 * <p>Description:学期模块</p>
 *
 * @author 刘玉龙
 * @version 1.0
 * @date 2019/1/8 14:37
 */
@Controller
@RequestMapping(value = ElectiveSystemConfig.TERM_MAPPING)
public class TermResourceController {

    private final TermResourceService termResourceService;

    @Autowired
    public TermResourceController(TermResourceService termResourceService) {
        this.termResourceService = termResourceService;
    }

    /**
     * 作用:添加
     *
     * @param termResource 学期对象
     * @return cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult
     * @date 16:30 2019/1/8
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public ElectiveSystemResult insertTermResource(TermResource termResource) {
        return null;
    }
}
