package com.gx.soft.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import javax.servlet.http.HttpServlet;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOptUtil extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 判断文件类型
	public static Workbook createWorkBook(InputStream is, String myfilesFileName)
			throws IOException {
		Workbook book = null;
		if (myfilesFileName.toLowerCase().endsWith("xls")) {
			book = new HSSFWorkbook(is);
		}
		if (myfilesFileName.toLowerCase().endsWith("xlsx")) {
			book = new XSSFWorkbook(is);
		}
		return book;
	}

	// 判断从Excel文件中解析出来数据的格式
	public static String getCellValue(Cell cell) {
		String value = "";
		if (cell != null) {
			// 简单的查检列类型
			switch (cell.getCellType()) {
			case HSSFCell.CELL_TYPE_STRING:// 字符串
				value = cell.getRichStringCellValue().getString();
				break;
			case HSSFCell.CELL_TYPE_NUMERIC:// 数字
				long dd = (long) cell.getNumericCellValue();
				value = dd + "";
				break;
			case HSSFCell.CELL_TYPE_BLANK:
				value = "";
				break;
			case HSSFCell.CELL_TYPE_FORMULA:
				value = String.valueOf(cell.getCellFormula());
				break;
			case HSSFCell.CELL_TYPE_BOOLEAN:// boolean型值
				value = String.valueOf(cell.getBooleanCellValue());
				break;
			case HSSFCell.CELL_TYPE_ERROR:
				value = String.valueOf(cell.getErrorCellValue());
				break;
			default:
				break;
			}
		}
		return value;
	}

	// 将EXCEL中的日期格式转化为JAVA的DATE格式
	public static Date getCellDate(Cell cell) {
		// SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		Date value = null;
		if (cell != null) {
			if (HSSFDateUtil.isCellDateFormatted(cell)) {
				double d = cell.getNumericCellValue();
				value = HSSFDateUtil.getJavaDate(d);
			}
		}
		return value;
	}

	public static void setCellValue(HSSFCell cell, String value) {
		String res = "";
		if (value != null && value.trim().length() > 0) {
			res = value;
		}
		cell.setCellValue(res);
	}

	public static void setCellValue(HSSFCell cell, Float value) {
		Float res = 0.00f;
		if (value != null) {
			res = value;
		}
		cell.setCellValue(res);
	}
	public static void setCellValue(HSSFCell cell, Integer value) {
		Integer res = 0;
		if (value != null) {
			res = value;
		}
		cell.setCellValue(res);
	}

	public static void setCellValue(HSSFWorkbook hwb, HSSFCellStyle cellStyle,
			HSSFCell cell, Date value) {
		// HSSFCellStyle cellStyle = hwb.createCellStyle();
		HSSFDataFormat format = hwb.createDataFormat();
		cellStyle.setDataFormat(format.getFormat("yyyy-MM-dd HH:mm:ss"));
		if (value != null) {
			cell.setCellValue(value);
			cell.setCellStyle(cellStyle);
		} else {
			cell.setCellValue("");
		}
	}
}
