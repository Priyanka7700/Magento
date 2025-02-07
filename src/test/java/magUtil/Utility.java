package magUtil;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utility {
	
	public static String getCellValue(String file, String sheet, int r, int c)
	{
		try {
			FileInputStream f = new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(file);
			XSSFCell cell = wb.getSheet(sheet).getRow(r).getCell(c);

			if (cell.getCellType() == CellType.STRING) {
				return cell.getStringCellValue();
			} else {
				return cell.getRawValue();
			}

		} catch (Exception e) {
			return "";
		}
	}

	public static int getRowCount(String file, String sheet) {
		try {
			FileInputStream f = new FileInputStream(file);
			XSSFWorkbook wb = new XSSFWorkbook(file);
			return wb.getSheet(sheet).getLastRowNum();
		} catch (Exception e) {
			return 0;
		}
	}

}
