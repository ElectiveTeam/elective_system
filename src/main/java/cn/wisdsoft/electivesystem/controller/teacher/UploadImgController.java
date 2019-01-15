package cn.wisdsoft.electivesystem.controller.teacher;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

import cn.wisdsoft.electivesystem.pojo.utils.ElectiveSystemConfig;
import cn.wisdsoft.electivesystem.pojo.utils.ImageUploadUtil;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



/**
 * @author 闫亮
 * @version 1.0
 * @date 2019/1/9 10:36
 */
@Controller
@RequestMapping(value = ElectiveSystemConfig.TEACHER_MAPPING)
public class UploadImgController{
	   /**
     * 图片上传
     * @Title imageUpload
     * @param request
     * @param response
     */
    @RequestMapping(value="/imageUpload",method=RequestMethod.POST)
    public void imageUpload(HttpServletRequest request, HttpServletResponse response) {
    	ModelAndView mav = new ModelAndView();
    	String DirectoryName = "/WEB-INF/upload";
        try {
            ImageUploadUtil.ckeditor(request, response, DirectoryName);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //mav.setViewName("index");
        //return mav;
    }

}
