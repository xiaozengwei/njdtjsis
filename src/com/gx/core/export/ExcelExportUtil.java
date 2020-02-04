package com.gx.core.export;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 导出帮助类：使用此类需要配合@ExportBean注解
 */
public class ExcelExportUtil {
    private ExcelDataStrategy excelDataStrategy;

    public ExcelExportUtil() {

    }

    public ExcelExportUtil(ExcelDataStrategy excelDataStrategy) {
        this.excelDataStrategy = excelDataStrategy;
    }


    /**
     * 导出方法
     *
     * @param response
     * @param fileName 导出的文件名
     * @param beanList 导出的数据
     * @param metaMap  元信息 clazz类对象,columnNames字段名String[],columnWidth列宽Integer[],columnComment列名String[]
     */
    public void exportBean(HttpServletResponse response, String fileName, List beanList, Map<String, Object> metaMap) throws Exception {
        try {

            Map<String, Object> objectMap = excelDataStrategy.getExcelDataMap(beanList, metaMap);

            String[] columnComments = (String[]) objectMap.get("columnComment");
            //列宽
            Integer[] excelHeaderWidth = (Integer[]) objectMap.get("columnWidth");
            //数据列
            Map<Integer, List<String>> dataMap = (Map<Integer, List<String>>) objectMap.get("data");
//            XSSFWorkbook xssfWorkbook = new XSSFWorkbook();

            // keep 100 rows in memory, exceeding rows will be flushed to disk
            SXSSFWorkbook wb = new SXSSFWorkbook(100);
            Sheet sheet = wb.createSheet();
            sheet.setDefaultRowHeight((short) 300);

            // 设置列宽度
            if (excelHeaderWidth != null && excelHeaderWidth.length > 0) {

                for (int i = 0; i < excelHeaderWidth.length; i++) {
                    sheet.setColumnWidth(i, 32 * excelHeaderWidth[i]);
                }
            } else {//默认宽度
                for (int i = 0; i < columnComments.length; i++) {
                    sheet.setColumnWidth(i, 32 * 250);
                }
            }
            // 标题
            Cell cell;
            //列名
            String[] cells = columnComments;
            Row titleRow = sheet.createRow(0);
            for (int i = 0; i <= cells.length - 1; i++) {
                cell = titleRow.createCell((short) i);
                cell.setCellValue(cells[i]);
            }

            CellStyle cellStyle = wb.createCellStyle();
            wb.createCellStyle();
            DataFormat format = wb.createDataFormat();
            cellStyle.setDataFormat(format.getFormat("@"));
            Set<Map.Entry<Integer, List<String>>> entrySet = dataMap.entrySet();
            int size = entrySet.size();

            for (int i = 1; i <= size; i++) {
                Row dataRow = sheet.createRow(i);
                List<String> dList = dataMap.get(i);
                for (int j = 0; j < dList.size(); j++) {
                    cell = dataRow.createCell(j);
                    cell.setCellStyle(cellStyle);
                    cell.setCellValue(dList.get(j));
                }
            }
            response.setContentType("application/vnd.ms-excel");
            String name = fileName + System.currentTimeMillis() + ".xlsx";
            String filename = "\"" + new String(name.getBytes(), "iso-8859-1") + "\"";
            response.addHeader("Content-Disposition", "attachment; filename=" + filename);
            wb.write(response.getOutputStream());
//            wb.dispose();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }


    /**
     * 导出方法
     *
     * @param response
     * @param fileName 导出的文件名
     * @param beanList 导出的数据
     * @param metaMap  元信息 clazz类对象,columnNames字段名String[],columnWidth列宽Integer[],columnComment列名String[]
     */
    public void exportBean1(HttpServletResponse response, String fileName, List beanList, Map<String, Object> metaMap) throws Exception {
        try {

            Map<String, Object> objectMap = excelDataStrategy.getExcelDataMap(beanList, metaMap);

            String[] columnComments = (String[]) objectMap.get("columnComment");
            //列宽
            Integer[] excelHeaderWidth = (Integer[]) objectMap.get("columnWidth");
            //数据列
            Map<Integer, List<String>> dataMap = (Map<Integer, List<String>>) objectMap.get("data");
//            XSSFWorkbook xssfWorkbook = new XSSFWorkbook();

            // keep 100 rows in memory, exceeding rows will be flushed to disk
            SXSSFWorkbook wb = new SXSSFWorkbook(100);

            Sheet sheet = wb.createSheet();
            sheet.setDefaultRowHeight((short) 300);

            // 设置列宽度
            if (excelHeaderWidth != null && excelHeaderWidth.length > 0) {

                for (int i = 0; i < excelHeaderWidth.length; i++) {
                    sheet.setColumnWidth(i, 32 * excelHeaderWidth[i]);
                }
            } else {//默认宽度
                for (int i = 0; i < columnComments.length; i++) {
                    sheet.setColumnWidth(i, 32 * 250);
                }
            }
            // 标题
            Cell cell;
            //列名
            String[] cells = columnComments;
            Row titleRow = sheet.createRow(0);
            CellStyle cellStyle1 = wb.createCellStyle();
            cellStyle1.setAlignment(HSSFCellStyle.ALIGN_CENTER);
            for (int i = 0; i <= cells.length - 1; i++) {
                cell = titleRow.createCell((short) i);
                cell.setCellStyle(cellStyle1);
                cell.setCellValue(cells[i]);
            }

            CellStyle cellStyle = wb.createCellStyle();
            wb.createCellStyle();
            DataFormat format = wb.createDataFormat();
            cellStyle.setDataFormat(format.getFormat("@"));
            cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
            Set<Map.Entry<Integer, List<String>>> entrySet = dataMap.entrySet();
            int size = entrySet.size();

            for (int i = 1; i <= size; i++) {
                Row dataRow = sheet.createRow(i);
                List<String> dList = dataMap.get(i);
                for (int j = 0; j < dList.size(); j++) {
                    cell = dataRow.createCell(j);
                    cell.setCellStyle(cellStyle);
                    cell.setCellValue(dList.get(j));
                    if(dList.get(j)!=null&&!dList.get(j).equals("")&&(j==3||j==2)){
                        cell.setCellValue(dList.get(j).substring(11,19));
                    }
                }
            }
            response.setContentType("application/vnd.ms-excel");
            String name = fileName + System.currentTimeMillis() + ".xlsx";
            String filename = "\"" + new String(name.getBytes(), "iso-8859-1") + "\"";
            response.addHeader("Content-Disposition", "attachment; filename=" + filename);
            wb.write(response.getOutputStream());
//            wb.dispose();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }
}
