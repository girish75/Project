package Excel;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelper {

	
	public static Object[][] reader(String filename,String sheetname) throws IOException{
		
		Object[][] data = null;
		
		FileInputStream file = new FileInputStream(filename);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		XSSFSheet sheet = workbook.getSheetAt(workbook.getSheetIndex(sheetname));
		
		int totalRows = sheet.getLastRowNum();
		
		Row row = sheet.getRow(0);
		
		int totalColumns = row.getLastCellNum();
		
		data = new Object[totalRows][totalColumns];
		for(int i=1;i<=totalRows;i++ ) {
			row = sheet.getRow(i);
			
			for (int j=0;j<totalColumns;j++) {
				
				switch(row.getCell(j).getCellType()) {
				
				case STRING:
					data[i-1][j]=row.getCell(j).getStringCellValue();
					break;
				case NUMERIC:
					data[i-1][j]=(int)row.getCell(j).getNumericCellValue();
					break;
				case BLANK:
					data[i-1][j]="";
					break;
				case BOOLEAN:
					data[i-1][j]=row.getCell(j).getBooleanCellValue();
					break;
				case ERROR:
					data[i-1][j]=row.getCell(j).getErrorCellValue();
					break;
				case FORMULA:
					data[i-1][j]=row.getCell(j).getCellFormula();
					break;
				case _NONE:
					data[i-1][j]="unknown";
					break;
				default:
					break;
				}
				
			}
		}
		
		return data;
		
	}
	
	/*
	 * public static void main(String[] args) throws IOException {
	 * 
	 * System.out.println(reader(".\\src\\test\\java\\resources\\TestData.xlsx",
	 * "Users").toString()); }
	 */
}
