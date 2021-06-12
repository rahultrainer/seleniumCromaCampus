package Utilities;

import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;  

public class Excelinputoutput extends filereader {

	static String[][] tabArray = null;
	private static XSSFSheet sheet;
	private static XSSFWorkbook wb;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	
	public static Object[][] readexcel(String filetoread, String SheetName)
	{
		try  
		{  
			//creating a new file instance  
			FileInputStream fis = new FileInputStream(fileread(filetoread));
			//creating Workbook instance that refers to .xlsx file  
			XSSFWorkbook wb = new XSSFWorkbook(fis);   
			XSSFSheet sheet = wb.getSheet(SheetName);
			int RowCount = sheet.getLastRowNum();
			int ColCount = sheet.getRow(0).getLastCellNum();
			int ci=0,cj=0;
//			int totalRows = 1;
//			int totalCols = 2;
			tabArray=new String[RowCount][ColCount];
			System.out.println(ColCount + "inside excel" + RowCount);
			for (int i=0;i<RowCount;i++, ci++)
				{
				for(int j=0;j<ColCount;j++, cj++)
				   tabArray[ci][cj]=getCellData(RowCount,j);
//				   System.out.println(tabArray[ci][cj]);
				}
			System.out.println("done inside excel");
		}  
		catch(Exception e)  
		{  
		e.printStackTrace();  
		}   
		return tabArray;
	}
	
	public static String getCellData(int RowNum, int ColNum) throws Exception
	{
	   try{
		  Cell = sheet.getRow(RowNum).getCell(ColNum);
		  String CellData = Cell.getStringCellValue();
		  System.out.println("CellData " +CellData);
		  return CellData;
	  }catch (Exception e){
			System.out.println("data error");
		  return "";
		}
	}
	
	public void writeexcel()
	{
		
	}
}
