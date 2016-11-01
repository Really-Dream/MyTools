package com.dream.jie.huang.Excel;

import java.io.File;
import java.util.ArrayList;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ReadExcel {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReadExcel r = new ReadExcel();
		try {
			ArrayList<String[]> list = r.getXls("D:/4.xls");
			String s="";
			for(String[] l : list){
				s += "'"+l[2]+"',";
			}
			System.out.println(s);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<String[]> getXls(String path) throws Exception{
		ArrayList<String[]> list = new ArrayList<String[]>();
		Workbook book = Workbook.getWorkbook(new File(path)); 
		Sheet sheet = book.getSheet(0);//第一个sheet
		int cloums = sheet.getColumns();
		int rows = sheet.getRows();
		for (int i = 0 ; i < rows ; i++){
			String[] data = new String[cloums];
			for(int j = 0;j < cloums; j++){
				Cell cell = sheet.getCell(j, i);//第1列，第2行
				String result = cell.getContents();
//				System.out.println(result);
				data[j] = result;
			}
			list.add(data);
				}
		book.close();
		return list;
	}
}
