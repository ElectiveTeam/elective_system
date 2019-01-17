package cn.wisdsoft.electivesystem.controller.teacher;

import cn.wisdsoft.electivesystem.mapper.CourseMapper;
import cn.wisdsoft.electivesystem.mapper.CurriculumMapper;
import cn.wisdsoft.electivesystem.pojo.Course;
import cn.wisdsoft.electivesystem.pojo.Curriculum;
import cn.wisdsoft.electivesystem.pojo.CurriculumFu;
import cn.wisdsoft.electivesystem.pojo.Relationship;
import cn.wisdsoft.electivesystem.pojo.TermResource;
import cn.wisdsoft.electivesystem.pojo.VO.Teacher;
import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemConfig;
import cn.wisdsoft.electivesystem.pojo.utils.ExcelUtil;
import cn.wisdsoft.electivesystem.pojo.utils.PageResult;
import cn.wisdsoft.electivesystem.service.teacher.TeacherService;

import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 闫亮
 * @version 1.0
 * @date 2018/1/9 10:48
 */
@Controller
@RequestMapping(value = ElectiveSystemConfig.TEACHER_MAPPING)
public class TeacherController {
	@Autowired
	TeacherService ts;
	@Autowired
	CurriculumMapper clm;
	@Autowired
	CourseMapper cm;

    private final TeacherService teacherService;

    @Autowired
    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
    
    @RequestMapping(value="/courseAdd",method=RequestMethod.GET)
    public String courseAdd(Model model,HttpSession session) {
    	
    	//查询处于申请状态的学院
    	List<TermResource> termlist=ts.selectBytimetype();
    	//session取年级列表
    	List<String> grades=(List<String>) session.getAttribute("grades");
    	model.addAttribute("termlist",termlist);
    	model.addAttribute("grades",grades);
		return "teacher/courseAdd";
    }
    
    //课程列表
    @RequestMapping(value="/curriculumList",method=RequestMethod.GET)
    public String curriculumList(Model model,HttpSession session) {
    	//将最新学期名称存入session
    	String newName = ts.selectNew();
    	session.setAttribute("newName", newName);
    	//将教师姓名和教职工号存储在session中
    	String teacherName=(String)((Teacher)session.getAttribute("key")).getTeaName();
    	String teacherWorknumber=((String)((Teacher)session.getAttribute("key")).getWorknumber());
    	session.setAttribute("teacherName", teacherName);
    	session.setAttribute("teacherWorknumber", teacherWorknumber);
    	//查询学期名称
    	List<String> list  = ts.selectTermName();
    	model.addAttribute("termName",list);
		return "teacher/curriculumList";
    }
    
    
    /**
	 * 根据浏览器的不同进行编码设置，返回编码后的文件名
	 */
	public String getFilename(HttpServletRequest request,
	                                            String filename) throws Exception { 
	    // IE不同版本User-Agent中出现的关键词
	    String[] IEBrowserKeyWords = {"MSIE", "Trident", "Edge"};  
	    // 获取请求头代理信息
	    String userAgent = request.getHeader("User-Agent");  
	    for (String keyWord : IEBrowserKeyWords) { 
	         if (userAgent.contains(keyWord)) { 
	              //IE内核浏览器，统一为UTF-8编码显示
	              return URLEncoder.encode(filename, "UTF-8");
	         }
	    }  
	    //火狐等其它浏览器统一为ISO-8859-1编码显示
	    return new String(filename.getBytes("UTF-8"), "ISO-8859-1");  
	}  
    
    
    //下载学生名单 入参课程名称，课程基础表curriculum的id
    @RequestMapping(value="/downloadExcel",method=RequestMethod.GET)
    public ResponseEntity<byte[]> downloadExcel(String cuName, String id,HttpServletRequest request) throws Exception {
    	//请求，课程基础表curriculum的id,文件名须确保唯一性
    	String fileName = cuName+java.util.UUID.randomUUID().toString()+".xls";
    	String downFile = sheet(request,Integer.parseInt(id),fileName);
    	
    	// 指定要下载的文件所在路径
	    String path = request.getSession().getServletContext().getRealPath("/WEB-INF/excel/");
	    // 创建该文件对象
	    File file = new File(path+File.separator+fileName);
	    // 对文件名编码，防止中文文件乱码
	    fileName = this.getFilename(request, fileName);
	    // 设置响应头
	    HttpHeaders headers = new HttpHeaders();
	    // 通知浏览器以下载的方式打开文件
	    headers.setContentDispositionFormData("attachment", fileName);
	    // 定义以流的形式下载返回文件数据
	    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
	    // 使用Sring MVC框架的ResponseEntity对象封装返回下载数据
	    //使用spring mvc框架提供的ResponseEntity返回下载数据，第一个参数是字节，第二个参数头信息，第三个参数是状态
	   return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
	                                           headers,HttpStatus.OK);
    }
    
    //显示申请详情
    @RequestMapping(value="/show",method=RequestMethod.GET)
    public String show() {
		return "teacher/show";
    }
    
    //显示申请详情
    @RequestMapping(value="/edit",method=RequestMethod.GET)
    public String edit(Model model,HttpSession session) {
    	//查询处于申请状态的学院
    	List<TermResource> termlist=ts.selectBytimetype();
    	//session取年级列表
    	List<String> grades=(List<String>) session.getAttribute("grades");
    	model.addAttribute("termlist",termlist);
    	model.addAttribute("grades",grades);
		return "teacher/edit";
    }
    
    //更改申请状态由待申请转为未提交    1->0
    @RequestMapping(value="/updateStatus",method=RequestMethod.POST)
    @ResponseBody
    public int updateStatus(int id) {
    	Curriculum record = new Curriculum();
    	record.setId(id);
    	record.setStatus(0);
    	int ofn =ts.updateStatus(record);
    	if(ofn==0) {
    		return 0;
    	}else {
    		return 1;
    	}
    }
    
    
    @RequestMapping(value="/selectCourse",method=RequestMethod.POST)
    @ResponseBody
    public List<Course> selectCourse(String term_id) {
    	//根据课程名称模糊查询相似课组名称且学期资源外键相同
    	List<Course> courseList=ts.selectByName(term_id);
		return courseList;
    }
    
    //添加课程信息
    @RequestMapping(value="/addCurriculum",method=RequestMethod.POST)
    @ResponseBody
    public String addCurriculum(@RequestBody CurriculumFu cf,HttpSession session) {
    	Curriculum cl= new Curriculum();
    	cl.setCuName(cf.getCuName());
		cl.setTeacherId(cf.getTeacherId());
		cl.setTeacherName((String)session.getAttribute("teacherName"));
		cl.setClassHour(cf.getClassHour());
		cl.setCredit(cf.getCredit());
		cl.setDescribe(cf.getDescribe());
		cl.setGrade(cf.getGrade());
		cl.setStatus(cf.getStatus());
		cl.setCouId(cf.getCouId());
		//如果选择了课组
    	if(cl.getCouId() != 0) {
    		int ofn = clm.insertSelective(cl);
    		if(ofn>0) {
    			return "ok";
    		}
    	}else {
    		Course course= new Course();
    		course.setCourseName(cf.getCuName()+(String)session.getAttribute("teacherName"));
    		course.setTrId(cf.getTermId());
    		cm.insertSelective(course);//返回新增的课组主键,主键值已经赋值到领域模型实体的id中
    		cl.setCouId(course.getId());
    		//插入课程表
    		int ofn = clm.insertSelective(cl);
    		if(ofn>0) {
    			return "ok";
    		}
    	}
    	return "no";
    }
    
    
    //修改课程信息
    @RequestMapping(value="/updateCurriculum",method=RequestMethod.POST)
    @ResponseBody
    public String updateCurriculum(@RequestBody CurriculumFu cf,HttpSession session) {
    	Curriculum cl= new Curriculum();
    	cl.setId(cf.getId());
    	cl.setCuName(cf.getCuName());
		cl.setTeacherId(cf.getTeacherId());
		cl.setTeacherName((String)session.getAttribute("teacherName"));
		cl.setClassHour(cf.getClassHour());
		cl.setCredit(cf.getCredit());
		cl.setDescribe(cf.getDescribe());
		cl.setGrade(cf.getGrade());
		cl.setStatus(cf.getStatus());
		cl.setCouId(cf.getCouId());
		//如果选择了课组
    	if(cl.getCouId() != 0) {
    		int ofn = clm.updateByPrimaryKey(cl);
    		if(ofn>0) {
    			return "ok";
    		}
    	}else {
    		Course course= new Course();
    		course.setCourseName(cf.getCuName()+(String)session.getAttribute("teacherName"));
    		course.setTrId(cf.getTermId());
    		cm.insertSelective(course);//返回新增的课组主键,主键值已经赋值到领域模型实体的id中
    		cl.setCouId(course.getId());
    		//插入课程表
    		int ofn = clm.updateByPrimaryKey(cl);
    		if(ofn>0) {
    			return "ok";
    		}
    	}
    	return "no";
    }
    
    
    
    //根据教师id,申请状态,学期名称查询申请信息
    //http://localhost:8080/teacher/selectCurriculumPage?teacherId=1&status=0&termName=2013-2014学年第1学期
    @RequestMapping(value="/selectCurriculumPage",method=RequestMethod.GET)
    @ResponseBody
    public PageResult selectCurriculumPage(String teacherId,
										    		Integer status,
										    		String termName,
										            @RequestParam(value = "page",defaultValue = "1") int pageNum,
										            @RequestParam(value = "limit",defaultValue = "10") int pageSize){
    	return ts.selectCurriculumPage(teacherId, status, termName,pageSize,pageNum);
    }
    
    //打印学生名单方法----------硬生成至服务器----待完善----待完善----待完善----待完善----待完善----待完善----待完善----待完善----待完善
    public String sheet(HttpServletRequest request,int curId,String excelName) {
    	//获取数据库数据
    	List<Relationship> relaList=ts.selectBycurriculumID(curId);
    	
    	
        // 表单名
        String tName = "学生名单（姓名学号对照）";
        
        // 表头行列名
        ArrayList<String> tHeader = new ArrayList<String>();
        tHeader.add("学号");
        tHeader.add("姓名");
        
        // 循环写入表单数据(除表头) - 行
        ArrayList<ArrayList<Object>> tableValue = new ArrayList<ArrayList<Object>>();
        for(int i=0;i<relaList.size();i++) {
        	ArrayList<Object> row = new ArrayList<Object>();
            row.add(relaList.get(i).getStuId());
            row.add(relaList.get(i).getStuName());
            tableValue.add(row);
        }
        
        
        // 表头样式
        Map<String, Short> tHeaderStyle = new HashMap<String, Short>();
        tHeaderStyle.put("color", (short)10);
        tHeaderStyle.put("weight", (short)700);
        
        // 表数据样式
        Map<String, Short> tValueStyle = new HashMap<String, Short>();
        tValueStyle.put("color", (short)32767);
        tValueStyle.put("weight", (short)400);
        //设置导出路径和文件名
        String filePath = request.getSession().getServletContext().getRealPath("/WEB-INF/excel");
        // 如果路径不存在，则创建该路径
        File realPathDirectory = new File(filePath);
        if (realPathDirectory == null || !realPathDirectory.exists()) {
            realPathDirectory.mkdirs();
        }
        filePath=filePath+"/"+excelName;
        try {
            ExcelUtil.newInstance().exportExcel(tName, tHeader,
            		tableValue, tHeaderStyle,
                    tValueStyle, filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filePath;
    }
}
