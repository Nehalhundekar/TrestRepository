package com.comcast.genericutility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelGeneric 
{
	public String getExcel(String sheet,int row,int cell)
	{
		String val="";
		try{
			FileInputStream fis=new FileInputStream("./Excel/Excl1.xlsx");
			Workbook wb=WorkbookFactory.create(fis);
			Cell cel = wb.getSheet(sheet).getRow(row).getCell(cell);
			val=cel.getStringCellValue();
		}
		catch (Exception e) 
		{
			
			System.out.println("could not handle");
		}
		return val;
	}

}
