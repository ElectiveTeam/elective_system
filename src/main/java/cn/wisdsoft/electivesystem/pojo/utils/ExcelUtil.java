package cn.wisdsoft.electivesystem.pojo.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * @描述 负责将数据集(表单数据)导出Excel文件
 */
public class ExcelUtil {

    /**
     * 类实例
     */
    private static ExcelUtil export;

    /**
     * excel文档
     */
    private HSSFWorkbook workbook;

    /**
     * excel sheet
     */
    private HSSFSheet sheet;

    /**
     * 字节流
     */
    private OutputStream fileOutput;

    /**
     * 声明私有构造方法
     */
    private ExcelUtil() {

    }

    /**
     * 产生一个excel导出工具类实例(单例模式)
     * 
     * @return excel导出工具类对象
     */
    public static ExcelUtil newInstance() {
        if (export == null)
            export = new ExcelUtil();
        return export;
    }

    /**
     * @功能描述 设置excel文档(单表单)
     * @创建人 xx
     * @创建时间 2011-5-27 下午02:25:58
     * @param tName
     *            excel表名集
     * @param tHeader
     *            excel表头数据集
     * @param tValue
     *            excel表单数据集(除表头)
     * @param tHeaderStyle
     *            excel表头单元格样式
     * @param tValueStyle
     *            excel表单数据单元格样式(除表头)
     * @param filePath
     *            excel文件地址
     * @throws Exception
     *             异常往上抛出
     */
    public void exportExcel(String tName, ArrayList<String> tHeader, ArrayList<ArrayList<Object>> tValue,
            Map<String, Short> tHeaderStyle, Map<String, Short> tValueStyle, String filePath) throws Exception {

        try {
            // 当excel文档不存在时创建
            workbook = new HSSFWorkbook();

            // 单个表单赋值和样式
            this.setSheet(tName, tHeader, tValue, tHeaderStyle, tValueStyle);
            // 导出excel文件
            this.export(workbook, filePath);

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    /**
     * @功能描述 设置excel文档(单表单)
     * @创建人 xx
     * @创建时间 2011-5-27 下午02:25:58
     * @param tName
     *            excel表名集
     * @param tHeader
     *            excel表头数据集
     * @param tValue
     *            excel表单数据集(除表头)
     * @param tHeaderStyle
     *            excel表头单元格样式
     * @param tValueStyle
     *            excel表单数据单元格样式(除表头)
     * @throws Exception
     *             异常往上抛出
     */
    public InputStream exportExcelToStream(String tName, ArrayList<String> tHeader,
            ArrayList<ArrayList<Object>> tValue, Map<String, Short> tHeaderStyle, Map<String, Short> tValueStyle)
            throws Exception {

        // 当excel文档不存在时创建
        workbook = new HSSFWorkbook();

        // 单个表单赋值和样式
        this.setSheet(tName, tHeader, tValue, tHeaderStyle, tValueStyle);

        // 导出excel文件
        return export(workbook);

    }

    /**
     * @功能描述 设置excel文档(多表单)
     * @创建人 xx
     * @创建时间 2011-5-27 下午02:25:58
     * @param tName
     *            excel表名集
     * @param tHeader
     *            excel表头数据集
     * @param tValue
     *            excel表单数据集(除表头)
     * @param tHeaderStyle
     *            excel表头单元格样式
     * @param tValueStyle
     *            excel表单数据单元格样式(除表头)
     * @param filePath
     *            excel文件地址
     * @throws Exception
     *             异常往上抛出
     */
    public void exportExcel(ArrayList<String> tName, ArrayList<ArrayList<String>> tHeader,
            ArrayList<ArrayList<ArrayList<Object>>> tValue, ArrayList<Map<String, Short>> tHeaderStyle,
            ArrayList<Map<String, Short>> tValueStyle, String filePath) throws Exception {

        try {
            // 当excel文档不存在时创建
            workbook = new HSSFWorkbook();

            // for循环完成文档各个表单的赋值和样式
            for (int i = 0; i < tName.size(); i++) {
                this.setSheet(tName.get(i), tHeader.get(i), tValue.get(i), tHeaderStyle.get(i), tValueStyle.get(i)); // 单个表单赋值和样式
            }

            // 导出excel文件
            this.export(workbook, filePath);

        } catch (Exception e) {
        }
    }

    /**
     * @功能描述 设置excel文档(多表单)
     * @创建人 xx
     * @创建时间 2011-5-27 下午02:25:58
     * @param tName
     *            excel表名集
     * @param tHeader
     *            excel表头数据集
     * @param tValue
     *            excel表单数据集(除表头)
     * @param tHeaderStyle
     *            excel表头单元格样式
     * @param tValueStyle
     *            excel表单数据单元格样式(除表头)
     * @throws Exception
     *             异常往上抛出
     */
    public InputStream exportExcelToStream(ArrayList<String> tName, ArrayList<ArrayList<String>> tHeader,
            ArrayList<ArrayList<ArrayList<Object>>> tValue, ArrayList<Map<String, Short>> tHeaderStyle,
            ArrayList<Map<String, Short>> tValueStyle) throws Exception {

        // 当excel文档不存在时创建
        workbook = new HSSFWorkbook();

        // for循环完成文档各个表单的赋值和样式
        for (int i = 0; i < tName.size(); i++) {
            this.setSheet(tName.get(i), tHeader.get(i), tValue.get(i), tHeaderStyle.get(i), tValueStyle.get(i)); // 单个表单赋值和样式
        }
        return export(workbook);
    }

    /**
     * @功能描述 设置excel表单
     * @创建人 xx
     * @创建时间 2011-5-27 下午02:23:02
     * @param tName
     *            excel表名
     * @param tHeader
     *            excel表头数据集
     * @param tValue
     *            excel表单数据集(除表头)
     * @param tHeaderStyle
     *            excel表头单元格样式
     * @param tValueStyle
     *            excel表单数据单元格样式(除表头)
     * @throws Exception
     *             异常往上抛出
     */
    private void setSheet(String tName, ArrayList<String> tHeader, ArrayList<ArrayList<Object>> tValue,
            Map<String, Short> tHeaderStyle, Map<String, Short> tValueStyle) throws Exception {

        try {
            // 创建表单并设置其表名
            sheet = workbook.createSheet(tName);

            // 创建表单行
            HSSFRow tRow = sheet.createRow(0);

            // 赋值和样式(此时,为表头行)
            tRow = this.setTRow(tRow, tHeader, tHeaderStyle);

            // for循环完成表单数据的赋值和样式(除表头)
            for (int i = 0; i < tValue.size(); i++) {
                tRow = sheet.createRow(i + 1); // 获取表单行

                tRow = this.setTRow(tRow, tValue.get(i), tValueStyle); // 设置当前行的数据和样式
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @功能描述 设置excel表单行数据
     * @创建人 xx
     * @创建时间 2011-5-27 下午02:22:30
     * @param row
     *            excel表单行
     * @param tRow
     *            excel表单行数据
     * @param tHeaderStyle
     *            excel表头样式
     * @return 设置后的的表单行
     * @throws Exception
     *             异常往外抛出
     */
    @SuppressWarnings("unchecked")
    private HSSFRow setTRow(HSSFRow row, ArrayList tRow, Map<String, Short> tHeaderStyle) throws Exception {

        try {
            // 获取单元格样式
            HSSFCellStyle cellStyle = this.setCellStyle(tHeaderStyle);
            // 声明单元格
            HSSFCell cell = null;

            // for循环完成该表单某行各个列赋值和样式
            for (int i = 0; i < tRow.size(); i++) {
                cell = row.createCell(i); // 获取每列单元格
                cell.setCellStyle(cellStyle); // 设置样式

                sheet.autoSizeColumn((short) i); // 设置单元格自适应
                Object obj = tRow.get(i); // 获取当前列的值
                // 判断对象所属类型, 并强转
                if (obj instanceof Integer) // 当数字时
                    cell.setCellValue((Integer) obj);
                if (obj instanceof String) // 当为字符串时
                    cell.setCellValue((String) obj);
                if (obj instanceof Boolean) // 当为布尔时
                    cell.setCellValue((Boolean) obj);
                if (obj instanceof Date) // 当为时间时
                    cell.setCellValue((Date) obj);
                if (obj instanceof Calendar) // 当为时间时
                    cell.setCellValue((Calendar) obj);
                if (obj instanceof Double) // 当为小数时
                    cell.setCellValue((Double) obj);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row; // 返回
    }

    /**
     * @功能描述 设置单元格样式
     * @创建人 xx
     * @创建时间 2011-5-27 下午02:21:40
     * @param fontStyle
     *            样式Map集合
     * @return 设置后单元格样式
     * @throws Exception
     *             异常往外抛出
     */
    private HSSFCellStyle setCellStyle(Map<String, Short> fontStyle) throws Exception {

        // 声明单元格样式
        HSSFCellStyle cellStyle = null;
        try {
            // 创建字体
            HSSFFont font = workbook.createFont();
            // 设置字体样式
            // 设置字体颜色(红色为:HSSFFont.COLOR_RED 这里表示short类型 10)
            font.setColor(fontStyle.get("color"));
            // 设置字体形体(宽体为:HSSFFont.BOLDWEIGHT_BOLD 700) -- 粗体
            //应用poi-3.6版本的jar
            //font.setBoldweight(fontStyle.get("weight"));

            // 创建单元格样式
            cellStyle = workbook.createCellStyle();
            // 添加字体样式
            cellStyle.setFont(font);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return cellStyle; // 返回
    }

    /**
     * @功能描述 导出Excel
     * @创建人 xx
     * @创建时间 2011-5-27 下午02:57:37
     * @param workbook
     *            excel文档
     * @param filePath
     *            xls文件地址
     * @throws Exception
     *             异常往外抛出
     */
    private void export(HSSFWorkbook workbook, String filePath) throws Exception {

        try {
            // 根据指定xls文件创建文件字符流
            fileOutput = new FileOutputStream(filePath);
            // 将文档写入指定文件
            workbook.write(fileOutput);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭流, 释放资源
                fileOutput.close();
            } catch (IOException e) {
                e.printStackTrace();
                ;
            }
        }
    }

    /**
     * @功能描述 获取流
     * @创建人 xx
     * @创建时间 2011-5-27 下午02:57:37
     * @param workbook
     *            excel文档
     * @throws Exception
     *             异常往外抛出
     */
    private InputStream export(HSSFWorkbook workbook) throws IOException {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            try {
                workbook.write(baos);
            } catch (IOException e) {
                e.printStackTrace();
            }
            byte[] ba = baos.toByteArray();
            ByteArrayInputStream bais = new ByteArrayInputStream(ba);
            return bais;
        } finally {
            // 关闭流, 释放资源
            baos.close();
        }
    }
}
