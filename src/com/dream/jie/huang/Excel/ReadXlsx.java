package com.dream.jie.huang.Excel;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadXlsx {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReadXlsx r = new ReadXlsx();
		try {
			String s = "";
			ArrayList<String[]> list =  r.getXlsx("D:\\2.xlsx");
			int i = 0;
			for(String[] l:list){
				s+="'"+l[3]+"',";
				i++;
			}
			System.out.println(s);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<String[]> getXlsx(String fileName) throws IOException{
		ArrayList<String[]> list = new ArrayList<>();
		
		XSSFWorkbook book = new XSSFWorkbook(fileName);
		// 循环工作表Sheet
		XSSFSheet xssfSheet = book.getSheetAt(0);//第一个
		// 循环行Row
		for(int rowNum = 0; rowNum <= xssfSheet.getLastRowNum(); rowNum++ ){
			XSSFRow xssfRow = xssfSheet.getRow( rowNum);
			if(xssfRow == null){
				continue;
			}
			// 循环列Cell
			String[] data = new String[100];
			for(int cellNum = 0; cellNum <= xssfRow.getLastCellNum(); cellNum++){
				XSSFCell xssfCell = xssfRow.getCell( cellNum);
				if(xssfCell == null ){
					continue;
				}
//				xssfCell.setCellType(Cell.CELL_TYPE_STRING);
				data[cellNum] = getValue(xssfCell);
			}
			list.add(data);
		}
		book.close();
		return list;
	}
	
	@SuppressWarnings("static-access")  
	private String getValue(XSSFCell xssfCell){ 
	    if(xssfCell.getCellType() == xssfCell.CELL_TYPE_BOOLEAN){  
	      return String.valueOf( xssfCell.getBooleanCellValue());  
	    }else if(xssfCell.getCellType() == xssfCell.CELL_TYPE_NUMERIC){  
	    	if(HSSFDateUtil.isCellDateFormatted(xssfCell)){
	    		Date theDate = xssfCell.getDateCellValue();  
		    	if(theDate!=null){
		    	String ret = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(theDate); 
		    	return ret;
		    }
	    }
	      return String.valueOf( xssfCell.getNumericCellValue());  
	    }else{  
	    	return String.valueOf( xssfCell.getStringCellValue());  
	    }
	  }  
}
