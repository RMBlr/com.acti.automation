package com.acti.utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLib {
	XSSFWorkbook wb;

	public ExcelLib(String excelpath) {
		try {
			File file = new File(excelpath);
			FileInputStream fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("unable to open exel sheet");
			e.printStackTrace();
		}

	}

	public int getRowCount(String sheetName) {
		return wb.getSheet(sheetName).getLastRowNum() + 1;

	}

	public int getRowCount(int sheetNum) {
		return wb.getSheetAt(sheetNum).getLastRowNum() + 1;

	}

	public String getCellData(int sheetnum, int row, int col) {
		String celldata = wb.getSheetAt(sheetnum).getRow(row).getCell(col).toString();

		return celldata;
	}

	public String getCellData(String sheetname, int row, int col) {
		String celldata = wb.getSheet(sheetname).getRow(row).getCell(col).toString();

		return celldata;
	}

}
