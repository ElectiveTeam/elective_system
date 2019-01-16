package cn.wisdsoft.electivesystem.controller.administrator.statistics;

import cn.wisdsoft.electivesystem.pojo.Relationship;
import cn.wisdsoft.electivesystem.pojo.Statistics;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemConfig;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemResult;
import cn.wisdsoft.electivesystem.pojo.utils.PageResult;
import cn.wisdsoft.electivesystem.service.administrator.statistics.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>ClassName: StatisticsController</p>
 * <p>Description:</p>
 *
 * @author 刘玉龙
 * @version 1.0
 * @date 2019/1/8 15:25
 */
@Controller
@RequestMapping(value = ElectiveSystemConfig.STATISTICS_MAPPING)
public class StatisticsController {

    private final StatisticsService statisticsService;

    @Autowired
    
    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @RequestMapping(value="/index",method=RequestMethod.GET)
    public String index() {return "/home_page/index";}

    /**
     * 打开选课统计详情表格页面并绑定后台查询的学期
     * @param model
     * @return
     */
    @RequestMapping(value="/list",method=RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("TermList",statisticsService.findTerm().getData());
        return "/statistics/elective-list";
    }

    /**
     * 根据学期和学院统计选课情况
     * @param college
     * @param termName
     * @return
     */
    @RequestMapping(value="/findElective",method=RequestMethod.GET)
    @ResponseBody
    public PageResult<Statistics> findElective(String college,String termName,int limit,int page){
		return statisticsService.findElective(page,limit,college, termName);
    }

    /**
     * 打开选课统计人数图表页面并绑定学期
     * @param model
     * @return
     */
    @RequestMapping(value="/Echarts",method=RequestMethod.GET)
    public String Echarts(Model model) {
        model.addAttribute("TermList",statisticsService.findTerm().getData());
        return "/statistics/elective-echarts";
    }

    /**
     * 根据学期，选课类型，教师统计选课人数图表
     * @param college
     * @param ternName
     * @param teacherName
     * @return
     */
    @RequestMapping(value="/findElectiveEcharts",method = RequestMethod.GET)
    @ResponseBody
    public ElectiveSystemResult findElectiveEcharts(String college,String ternName,String teacherName) {
        return statisticsService.findEleciveEcharts(college,ternName,teacherName);
    }

    @RequestMapping(value="/edit",method=RequestMethod.GET)
    public String Edit(String selectid,Model model) {
        model.addAttribute("selectid",selectid);
        return "/statistics/elective-edit";}

    /**
     * 查询该课程选课学生信息
     * @param selectid
     * @param limit
     * @param page
     * @return
     */
    @RequestMapping(value="/findstu",method= RequestMethod.GET)
    @ResponseBody
    public PageResult<Relationship> findStu(int selectid,int limit,int page){
        return statisticsService.findStu(page,limit,selectid);
    }


}
