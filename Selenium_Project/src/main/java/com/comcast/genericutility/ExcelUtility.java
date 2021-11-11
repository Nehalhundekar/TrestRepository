package com.comcast.genericutility;

import java.io.FileInputStream;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility 
{
	
	public String getData(String Sheet,int row,int cell) 
	{
		   String val="";
		   try{
		
			FileInputStream fiz=new FileInputStream("./Excel/Excl1.xlsx");
			Workbook wb = WorkbookFactory.create(fiz);
			Cell c = wb.getSheet(Sheet).getRow(row).getCell(cell);
			 val=c.getStringCellValue();
		   }
		   catch(Exception e)
		   {
			   System.out.println("could not handle");
		   }
			 
			 return val;
			
	
		
		
			
		
	}

}
