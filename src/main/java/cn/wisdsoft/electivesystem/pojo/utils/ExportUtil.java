package cn.wisdsoft.electivesystem.pojo.utils;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @Author 高伟萌
 * @Date 2018/10/21 22:06
 * @Description TODO
 */
public class ExportUtil {
    private static List<String> myHeader = new ArrayList<>();

    private static StringBuffer error = new StringBuffer(0);

    /**
     * Create excel hssf workbook.
     * 创建工作空间
     *
     * @param sheetName the sheet name 工作簿名称
     * @param header    the header 表头
     * @return the hssf workbook 返回工作空间
     */
    public static HSSFWorkbook createExcel(String sheetName, Map<String, String> header) {
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        HSSFSheet hssfSheet = hssfWorkbook.createSheet(sheetName);
        HSSFRow row = hssfSheet.createRow(0);
        HSSFFont font = hssfWorkbook.createFont();
        font.setFontName("微软雅黑");
        //创建行样式
        HSSFCellStyle style = hssfWorkbook.createCellStyle();
        //将字体应用到样式中
        style.setFont(font);
        //水平居中
        style.setAlignment(HorizontalAlignment.CENTER);
        //垂直居中
        style.setVerticalAlignment(VerticalAlignment.CENTER);
        //字体大小
        font.setFontHeightInPoints((short) 15);
        //字体颜色
        font.setColor(IndexedColors.RED.getIndex());
        //String[] myList = new String[]{"id", "username", "password"};
        int cellid = 0;
        for (Map.Entry<String, String> entry : header.entrySet()) {
            row.setHeight((short) 500);
            Cell cell = row.createCell(cellid);
            cell.setCellStyle(style);
            cell.setCellValue(entry.getValue());
            hssfSheet.autoSizeColumn(cellid);
            myHeader.add(entry.getKey());
            cellid++;
        }
        return hssfWorkbook;
    }


    /**
     * Fill cell.
     * 填充单元格
     *
     * @param <T>          the type parameter POJO类型
     * @param hssfWorkbook the hssf workbook 工作空间
     * @param hssfSheet    the hssf sheet 工作簿
     * @param dataList     the data list 包含POJO类的集合
     * @throws Exception the exception 取值（get）方法设置错误，通常是字段不对应POJO类
     */
    public static <T> void fillCell(HSSFWorkbook hssfWorkbook, HSSFSheet hssfSheet, List<T> dataList) throws Exception {
        //创建Map的迭代器
        Iterator<T> iterator = dataList.iterator();
        int flag = 0;
        while (iterator.hasNext()) {
            flag++;
            //创建行
            HSSFRow hssfRow = hssfSheet.createRow(flag);
            //获取实例
            T t = iterator.next();
            for (int i = 0; i < myHeader.size(); i++) {
                //创建单元格
                HSSFCell hssfCell = hssfRow.createCell(i);
                //获取字段名称
                String propertyName = myHeader.get(i);
                System.out.println(propertyName);
                //创建Object类型的数组
                Object[] objects;
                CellStyle cellStyle = hssfWorkbook.createCellStyle();
                HSSFDataFormat dataFormat = hssfWorkbook.createDataFormat();
                try {
                    //objects包含两个值，第一个是方法返回类型，第二个是方法获取的结果
                    objects = getPropertyName(t, propertyName);
                } catch (Exception e) {
                    error.append("第").append(flag + 1).append("行，第").append(i).append("列，字段：").append(propertyName).append("数据错误！(需和POJO类属性名称一致)");
                    StringBuffer error = getError();
                    throw new Exception(error.toString());
                }
                String obj_1 = (String) objects[0];
                Object obj_2 = objects[1];
                switch (obj_1) {
                    case "java.lang.Integer":
                        if(obj_2==null){
                            hssfCell.setCellValue((String) obj_2);
                        }else{
                            hssfCell.setCellValue((Integer) obj_2);
                        }
                        break;
                    case "java.util.Date":
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        String format = dateFormat.format(obj_2);
                        hssfCell.setCellValue(format);
                        cellStyle.setDataFormat(dataFormat.getFormat("yyyy-MM-dd"));
                        hssfCell.setCellStyle(cellStyle);
                        hssfCell.setCellValue(format);
                        //TODO
                        break;
                    case "java.lang.String":
                        cellStyle.setDataFormat(dataFormat.getFormat("@"));
                        hssfCell.setCellStyle(cellStyle);
                        hssfCell.setCellValue((String) obj_2);
                        break;
                    case "java.lang.Double":
                        cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));
                        hssfCell.setCellStyle(cellStyle);
                        hssfCell.setCellValue((Double) obj_2);
                        break;
                }
            }
        }
    }
//
//    /**
//     * Write excel.
//     * 下载Excel
//     *
//     * @param hssfWorkbook the hssf workbook 工作空间
//     * @throws IOException the io exception
//     */
//    public static void writeExcel(HSSFWorkbook hssfWorkbook) throws IOException {
//        FileOutputStream outputStream = new FileOutputStream("D:/123.xls");
//        hssfWorkbook.write(outputStream);
//        outputStream.close();
//    }

    /**
     * 通过反射获取POJO类中的值
     *
     * @param instance     POJO类的实例
     * @param propertyName 字段名称
     * @param <T>          POJO类型
     * @return
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */
    private static <T> Object[] getPropertyName(T instance, String propertyName) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Object result;
        Class<?> clazz = instance.getClass();
        String getPropertyName = initGetMethod(propertyName);
        Method method = clazz.getMethod(getPropertyName);
        result = method.invoke(instance);
        String name = method.getReturnType().getName();
        Object[] objects = new Object[]{name, result};
        return objects;
    }

    /**
     * 生成get方法
     *
     * @param field 字段名称
     * @return 返回方法名称
     */
    private static String initGetMethod(String field) {
        return "get" + field.substring(0, 1).toUpperCase() + field.substring(1);
    }

    private static StringBuffer getError() {
        return error;
    }
}
