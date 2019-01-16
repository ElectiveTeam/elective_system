package cn.wisdsoft.electivesystem.controller.administrator.term;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.wisdsoft.electivesystem.pojo.TermResource;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemConfig;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult;
import cn.wisdsoft.electivesystem.pojo.utils.PageResult;
import cn.wisdsoft.electivesystem.service.administrator.term.TermResourceService;

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
        termResource.setStatus(0);
    	return termResourceService.insertTermResource(termResource);
    }
    /**
     * 作用:更改
     *
     * @param termResource 学期对象
     * @return cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult
     * @date 16:30 2019/1/8
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public ElectiveSystemResult updateTermResource(TermResource termResource) {
		return termResourceService.updateTermResource(termResource);	
    }
    /**
     * 作用:学院查询状态
     * @return cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult
     * @date 8:36 2019/1/10
     */
    @RequestMapping(value = "/status", method = RequestMethod.POST)
    @ResponseBody
    public ElectiveSystemResult statusTermResource(String college) {
    	return termResourceService.statusTermResource(college);
     	
    }
     
    /**
     * 作用:删除
     *
     * @param termResource 学期对象
     * @return cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult
     * @date 16:30 2019/1/8
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public ElectiveSystemResult deleteTermResource(Integer termResource) {
		return termResourceService.deleteTermResource(termResource);
    }
    
    @RequestMapping(value="/term",method = RequestMethod.GET)
	public String term() {
		return "term/term";
	}
      
    @RequestMapping(value="/termAdd",method = RequestMethod.GET)
	public String termAdd() {
		return "term/term_add";
	}
    
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @ResponseBody
    public PageResult<TermResource> findAll() {
    	return termResourceService.findAll();
    }
    
    @RequestMapping(value="/termEdit",method = RequestMethod.GET)
	public String termEdit(Integer id,String states,Model model) {
    	//根据id查询数据
    	TermResource term = termResourceService.seleTermById(id);
    	//将查询到的数据，放在下面    	
    	model.addAttribute("term", term);
    	model.addAttribute("states", states);
    	System.out.println(term);
		return "term/term_edit";
	}
}












