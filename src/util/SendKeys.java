package util;

import common.Elements;
import util.Browser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.openqa.selenium.WebElement;

public class SendKeys {

	public static void run(HashMap<String, String> params){
	    WebElement element = Elements.find(params,Browser.Driver);
	    
	    switch (params.get("Text Type")) {
	    case "User":
	    	try {
				InputStream is1 = new FileInputStream("\\\\testmech\\WebAuto\\User.xls");
				SendKeys excelReader = new SendKeys();
				Map<String, String> map = excelReader.readExcelContent(is1);
				element.sendKeys(map.get(params.get("Text")));
			} catch (FileNotFoundException e) {
				System.out.println("Excel file doesn't exist!");
				e.printStackTrace();
			}
	    	break;
	    case "Product":
	    	try {
				InputStream is2 = new FileInputStream("\\\\testmech\\WebAuto\\Product.xls");
				SendKeys excelReader = new SendKeys();
				Map<String, String> map = excelReader.readExcelContent(is2);
				element.sendKeys(map.get(params.get("Text")));
			} catch (FileNotFoundException e) {
				System.out.println("Excel file doesn't exist!");
				e.printStackTrace();
			}	    	
	    	break;
        case "Text":
            element.sendKeys(params.get("Text"));
            break;
	    default:
	    	element.sendKeys(params.get("Text"));
	    }
	}
	
	private POIFSFileSystem fs;
	private HSSFWorkbook wb;
	private HSSFSheet sheet;
	private HSSFRow row;

	/**
	 * read Excel
	 * 
	 * @param InputStream
	 * @return Map 
	 */
	public Map<String, String> readExcelContent(InputStream is) {
		Map<String, String> content = new HashMap<String, String>();
		String str = "";
		try {
			fs = new POIFSFileSystem(is);
			wb = new HSSFWorkbook(fs);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = wb.getSheetAt(0);
		int rowNum = sheet.getLastRowNum();
		row = sheet.getRow(0);
		int colNum = row.getPhysicalNumberOfCells();
		for (int i = 0; i <= rowNum; i++) {
			row = sheet.getRow(i);
			int j = 0;
			while (j < colNum) {
				str= getCellFormatValue(row.getCell(j));
				content.put(row.getCell(0)+"."+sheet.getRow(0).getCell(j), str);
				j++;
			}
		}
		return content;
	}

	/**
	 * 
	 * @param cell
	 * @return
	 */
	private String getCellFormatValue(HSSFCell cell) {
		String cellvalue = "";
		if (cell != null) {
			switch (cell.getCellType()) {
			case HSSFCell.CELL_TYPE_NUMERIC:
			case HSSFCell.CELL_TYPE_FORMULA: {
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					Date date = cell.getDateCellValue();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					cellvalue = sdf.format(date);
				}
				else {
					//change numeric to string
					DecimalFormat df = new DecimalFormat("0");
					cellvalue = df.format(cell.getNumericCellValue());
				}
				break;
			}
			case HSSFCell.CELL_TYPE_STRING:
				cellvalue = cell.getRichStringCellValue().getString();
				break;
			default:
				cellvalue = "";
			}
		} else {
			cellvalue = "";
		}
		return cellvalue;

	}
}
