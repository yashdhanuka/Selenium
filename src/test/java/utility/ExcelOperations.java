package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOperations {

	Map<String, List<String>> excelValues = new HashMap<String, List<String>>();
	List<String> values = new ArrayList<String>();
	
	public XSSFSheet getSheet(String file) throws IOException {
		FileInputStream inputStream = new FileInputStream(new File(file));
	
		//Create Workbook instance holding reference to .xlsx file
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

		//Get first/desired sheet from the workbook
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		return sheet;
	}

	public List<String> getColumnDataUsingColumnNumber(String file,int colNumber) throws IOException {

		XSSFSheet sheet = getSheet(file);

		XSSFRow row = sheet.getRow(colNumber);
		int rowCount = sheet.getPhysicalNumberOfRows();

		for(int i =1;i<rowCount;i++) {
			row = sheet.getRow(i);
			XSSFCell cell = row.getCell(colNumber);
			if(cell == null || cell.getCellTypeEnum() == CellType.BLANK) {
				continue;
			}
			values.add(cell.toString());
		}
		return values;
	}

	public List<String> getColumnDataUsingColumnName(String file,String colName) throws IOException{

		XSSFSheet sheet = getSheet(file);
		int colNum = 0;

		for (Row row: sheet) {
			for(Cell cell: row) {
				String cellValue = cell.toString();
				if(cellValue.equals(colName)) {
					colNum = cell.getColumnIndex();
				}
			}
		}
		return getColumnDataUsingColumnNumber(file,colNum);
	}
	
}