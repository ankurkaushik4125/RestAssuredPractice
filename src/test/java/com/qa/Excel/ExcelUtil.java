package com.qa.Excel;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtil {

	 public FileInputStream fis = null;
	 public FileOutputStream fos=null;
	 public XSSFWorkbook workbook=null;
	 public XSSFSheet sheet=null;
	 public XSSFRow row=null;
	 public XSSFCell cell=null;
	 
	 String xlfilepath="";
	 // Constuctor created to read workbook
	 public ExcelUtil(String xlfilepath) throws IOException
	 {
		 this.xlfilepath=xlfilepath;
		 fis = new FileInputStream(xlfilepath);
		  workbook = new XSSFWorkbook(fis);
		  fis.close();
	 }
	 // method to read total row count in sheet
	 public int getRowCount(String sheetName) 
	 {
		 sheet= workbook.getSheet(sheetName);
		 int rowCount=sheet.getLastRowNum()+1;
		 return rowCount;
	 }

	 // method to read  total coloum in sheet
	 public int getCellCount(String sheetName) 

	 {
		 sheet= workbook.getSheet(sheetName);
		 row = sheet.getRow(0);
		 int cellCount=row.getLastCellNum();
		 return cellCount;
	 }
	 
// To get cell data by cell index 

public String getCellData(String sheetName, int colNum, int rowNum)
{
	try {
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);
		
		DataFormatter df = new DataFormatter();
String celldata = df.formatCellValue(cell).trim();
return celldata;

	 
	 }
	catch (Exception e)
	{
		e.printStackTrace();
		return "row " + rowNum +" Or Coloum " + colNum+ "Doesn't exit in excel ";
	}
	
	
	
	}

public boolean setCellData(String sheetName, String colName, int rowNum, String value)
{
    try
    {
        int col_Num = -1;
        sheet = workbook.getSheet(sheetName);

        row = sheet.getRow(0);
        for (int i = 0; i < row.getLastCellNum(); i++) {
            if (row.getCell(i).getStringCellValue().trim().equals(colName))
            {
                col_Num = i;
            }
        }

        sheet.autoSizeColumn(col_Num);
        row = sheet.getRow(rowNum - 1);
        if(row==null)
            row = sheet.createRow(rowNum - 1);

        cell = row.getCell(col_Num);
        if(cell == null)
            cell = row.createCell(col_Num);

        cell.setCellValue(value);
       
        fos = new FileOutputStream(xlfilepath);
        workbook.write(fos);
        fos.close();
        
    }
    catch (Exception ex)
    {
        ex.printStackTrace();
        return  false;
    }
    return true;
}


public boolean setCellData(String sheetName, int colNumber, int rowNum, String value)
{
    try
    {
        sheet = workbook.getSheet(sheetName);
        row = sheet.getRow(rowNum);
        if(row==null)
            row = sheet.createRow(rowNum);

        cell = row.getCell(colNumber);
        if(cell == null)
            cell = row.createCell(colNumber);

        cell.setCellValue(value);

        fos = new FileOutputStream(xlfilepath);
        workbook.write(fos);
        fos.close();
    }
    catch (Exception ex)
    {
        ex.printStackTrace();
        return  false;
    }
    return true;
}



public String getCellData(String sheetName, String colName, int rowNum)
{
	try {
		int colNum=-1;
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(0);
		
		for (int i=0; i<row.getLastCellNum();i++)
		{
			
			if (row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
{
				colNum = i;
	}
		}
	row = sheet.getRow(rowNum);
	cell = row.getCell(colNum);

	

	
	DataFormatter df = new DataFormatter();
	String celldata = df.formatCellValue(cell).trim();
	return celldata;
	


	
	}
	catch (Exception e)
	{
		e.printStackTrace();
		return "row " + rowNum +" Or Coloum " + colName+ "Doesn't exit in excel ";
	}
	
	
	
	}

}

	 
	 
	 
		
	


