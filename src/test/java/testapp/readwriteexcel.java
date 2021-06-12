package testapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class readwriteexcel {

	static XSSFWorkbook exlWbook;  // xlsx -- XSSF, xls -- HSSF
	static XSSFSheet exlWsheet;
	static XSSFCell cell;
	static XSSFRow row;
	static int rowcount, colcount;
	static Object[][] excelfield = null;
	public static DataFormatter formatter= new DataFormatter();
	
	public static Object[][] readexcel(String filepath, String sheetname) throws Exception
	{
//		try
//		{
			// filepath  = "./data/testdata.xlsx"
			// sheetname = "test"
			File f = new File(filepath);
			FileInputStream file = new FileInputStream(f);
			exlWbook = new XSSFWorkbook(file);
			exlWsheet = exlWbook.getSheet(sheetname);
			rowcount = exlWsheet.getPhysicalNumberOfRows();
			colcount = exlWsheet.getRow(0).getLastCellNum();
			excelfield = new Object[rowcount-1][colcount];
//			exlWsheet = exlWbook.getSheetAt(3);
//			cell = exlWsheet.getRow(1).getCell(1);
//			System.out.println(rowcount);
//			System.out.println(colcount);
			for(int i =0; i<rowcount-1 ; i++)
			{
				row = exlWsheet.getRow(i+1);
				for(int j =0; j<colcount ; j++)
				{	
					if(row==null)
					{
						excelfield[i][j] ="";
					}
					else
					{
						cell= row.getCell(j);
						if(cell==null)
						{
							excelfield[i][j]= ""; 
                        }
                        else
                        {
                        	String value=formatter.formatCellValue(cell);
                        	System.out.println(value);
                        	excelfield[i][j]=value;
//							System.out.println(excelfield[i][j]);
                        }
					}
				}
			}
			
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//			cell = null;
//		}
		return excelfield;
		
	}
}
