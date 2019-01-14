package cn.wisdsoft.electivesystem.pojo.utils;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;


/**
 * The type Common.<br/>
 * Excel公共工具类（包含获取工作空间、工作簿以及下载Excel）
 */
public class Common {
    /**
     * Gets excel.
     * 获取Excel文档
     *
     * @param hssfWorkbook the hssf workbook  Excel工作空间
     * @param fileName     the file name  Excel文件名称
     * @param response     the response  HTTPServletResponse响应
     * @throws Exception the exception
     */
    public static void getExcel(HSSFWorkbook hssfWorkbook, String fileName, HttpServletResponse response) throws Exception {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName + ".xls", "UTF-8"));
        hssfWorkbook.write(response.getOutputStream());
        System.out.println(response.getHeader("Content-Disposition"));
        response.getOutputStream().flush();
        response.getOutputStream().close();
    }

    /**
     * Gets all hssf sheet.
     * 获取工作空间内所有的工作簿
     *
     * @param hssfWorkbook the hssf workbook  工作空间
     * @return the all hssf sheet  返回包含所有工作簿的集合
     * @throws Exception the exception  如果工作空间不包含工作簿，则抛出错误
     */
    public static List<HSSFSheet> getAllHSSFSheet(HSSFWorkbook hssfWorkbook) throws Exception {
        List<HSSFSheet> sheets = new ArrayList<>();
        for (int i = 0; i < hssfWorkbook.getNumberOfSheets(); i++) {
            HSSFSheet sheet = hssfWorkbook.getSheetAt(i);
            if (sheet != null) {
                sheets.add(sheet);
            } else {
                throw new Exception("该工作空间中没有工作簿！");
            }
        }
        return sheets;
    }

    /**
     * Gets one hssf sheet.
     * 获取工作空间内指定工作簿
     *
     * @param hssfWorkbook the hssf workbook  工作空间
     * @param index        the index  工作簿下标（第一个下表为0）
     * @return the one hssf sheet  返回指定工作簿
     * @throws Exception the exception  如果工作空间内不包含工作簿，则抛出异常
     */
    public static HSSFSheet getOneHSSFSheet(HSSFWorkbook hssfWorkbook, int index) throws Exception {
        HSSFSheet sheet = hssfWorkbook.getSheetAt(index);
        if (sheet == null) {
            throw new Exception("该工作空间不包含此工作簿！");
        }
        return sheet;
    }
}
