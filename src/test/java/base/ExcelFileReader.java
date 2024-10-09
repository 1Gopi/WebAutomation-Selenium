package base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileReader extends BaseClass {
	FileInputStream fileinputstream;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	public String user;
	public String pass;

	public ExcelFileReader() {
		System.out.println("In ExcelFile Reader constructore and the excel path is : "+ExcelPath);
		try {
			fileinputstream = new FileInputStream(ExcelPath);
			workbook = new XSSFWorkbook(fileinputstream);
			sheet = workbook.getSheetAt(0);
			// int rowNum = sheet.getLastRowNum()-sheet.getFirstRowNum();

			// Iterate through rows and columns
			for (int rowNum = 0; rowNum <= sheet.getLastRowNum()-1; rowNum++) {
				XSSFRow row = sheet.getRow(rowNum);
				if (row != null) {
					user = sheet.getRow(rowNum).getCell(0).toString();
					pass = sheet.getRow(rowNum).getCell(1).toString();
				}

			}
			

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
