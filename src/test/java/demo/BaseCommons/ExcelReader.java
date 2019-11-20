package demo.BaseCommons;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	// filename = "C:\\abc\data.xls"
	// Sheetname = "Accout"
	public static String ReadExcelAtCell(String fileName, String sheetName, int rowNo, int colNo) {
		Workbook wb = null;
		File scr = new File(fileName);
		FileInputStream fi;
		String rs = "";
		try {
			fi = new FileInputStream(scr);
			if (fileName.contains(".xlsx")) {
				wb = new XSSFWorkbook(fi);
			} else if (fileName.contains(".xls")) {
				wb = new HSSFWorkbook(fi);
			} else {
				System.out.println("khong dung dinh dang excel");
			}

			// tao sheet
			Sheet sheet = wb.getSheet(sheetName);

			// di den row can get info
			Row row = sheet.getRow(rowNo);

			// tao cell de chua info
			Cell cell = row.getCell(colNo);
			// o se co kieu string
			cell.setCellType(CellType.STRING);

			rs = cell.getStringCellValue();
			wb.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("file not found" + fileName + " " + e.getStackTrace());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("file error");
		}

		System.out.println(rs);
		return rs;
	}

	/// doc theo row
	public static ArrayList<String> ReadExcelAtRow(String fileName, String sheetName, int rowNo, int startCol, int endCol) {
		Workbook wb = null;
		File scr = new File(fileName);
		FileInputStream fi;
		String rs = "";
		ArrayList<String> arr = new ArrayList<String>();
		try {
			fi = new FileInputStream(scr);
			if (fileName.contains(".xlsx")) {
				wb = new XSSFWorkbook(fi);
			} else if (fileName.contains(".xls")) {
				wb = new HSSFWorkbook(fi);
			} else {
				System.out.println("khong dung dinh dang excel");
			}

			// tao sheet
			Sheet sheet = wb.getSheet(sheetName);
			////////////////////////////////////////////////////////

			// di den row can get info
			Row row = sheet.getRow(rowNo);

			// tao 1 array de chua kqa

			for (int i = startCol; i < endCol; i++) {
				// tao cell de chua info
				Cell cell = row.getCell(i);
				// o se co kieu string
				cell.setCellType(CellType.STRING);
				rs = cell.getStringCellValue();
				arr.add(rs);
			}

			wb.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("file not found" + fileName + " " + e.getStackTrace());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("file error");
		}

		return arr;
	}

	/// doc theo coloum
	public static ArrayList<String> ReadExcelAtCol(String fileName, String sheetName, int rowNo, int colNo) {
		Workbook wb = null;
		File scr = new File(fileName);
		FileInputStream fi;
		String rs = "";
		ArrayList<String> arr = new ArrayList<String>();
		try {
			fi = new FileInputStream(scr);
			if (fileName.contains(".xlsx")) {
				wb = new XSSFWorkbook(fi);
			} else if (fileName.contains(".xls")) {
				wb = new HSSFWorkbook(fi);
			} else {
				System.out.println("khong dung dinh dang excel");
			}

			// tao sheet
			Sheet sheet = wb.getSheet(sheetName);
			////////////////////////////////////////////////////////

			// di den row can get info
		//	Row row = sheet.getRow(rowNo);
			
			//tinh duoc range can loop
			int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
			
			for (int i = rowNo; i < rowCount + 1; i++) {
				try {
					Row row = sheet.getRow(i);
					Cell cell = row.getCell(colNo);
					cell.setCellType(CellType.STRING);
					 rs = cell.getStringCellValue();
					 arr.add(rs);
				} catch (Exception e) {
					// if row(i) = null / empty
					arr.add("");
				}
			}
			

			wb.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("file not found" + fileName + " " + e.getStackTrace());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("file error");
		}

		return arr;
	}

	
	
	public static ArrayList<String> ReadExcelAtCol(String fileName, String sheetName,  int colNo) {
		Workbook wb = null;
		File scr = new File(fileName);
		FileInputStream fi;
		String rs = "";
		ArrayList<String> arr = new ArrayList<String>();
		try {
			fi = new FileInputStream(scr);
			if (fileName.contains(".xlsx")) {
				wb = new XSSFWorkbook(fi);
			} else if (fileName.contains(".xls")) {
				wb = new HSSFWorkbook(fi);
			} else {
				System.out.println("khong dung dinh dang excel");
			}

			// tao sheet
			Sheet sheet = wb.getSheet(sheetName);
			////////////////////////////////////////////////////////

			// di den row can get info
		//	Row row = sheet.getRow(rowNo);
			
			//tinh duoc range can loop
			int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
			
			for (int i = 0; i < rowCount + 1; i++) {
				try {
					Row row = sheet.getRow(i);
					Cell cell = row.getCell(colNo);
					cell.setCellType(CellType.STRING);
					 rs = cell.getStringCellValue();
					 arr.add(rs);
				} catch (Exception e) {
					// if row(i) = null / empty
					arr.add("");
				}
			}
			

			wb.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("file not found" + fileName + " " + e.getStackTrace());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("file error");
		}

		return arr;
	}
}
