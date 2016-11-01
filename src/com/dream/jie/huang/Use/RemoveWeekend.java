package com.dream.jie.huang.Use;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dream.jie.huang.Excel.ReadXlsx;

public class RemoveWeekend {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		ReadXlsx xlsx = new ReadXlsx();
		List<String[]> list = new ArrayList<String[]>();
		list = xlsx.getXlsx("D:\\3.xlsx");
		for(String[] l:list){
			
//			System.out.println(remove(l[1],l[0])+"  ");
//			System.out.println(remove(l[2],l[0])+"  ");
//			if(l[2] != "" && l[2] != null){
//				System.out.println(remove(l[3],l[2])+"  ");
//			}else{
//				System.out.println(remove(l[3],l[0])+"  ");
//			}
			if(l[2] != "" && l[2] != null){
				System.out.println(remove(l[4],l[2])+"  ");
			}else{
				System.out.println(remove(l[4],l[0])+"  ");
			}
//			System.out.println(remove(l[5],l[4]));
		}
		
	}

	public static String remove(String begin,String end){
		GetWorkDayTimeMillisecond gwdtm = new GetWorkDayTimeMillisecond();
		if(begin != "" && end != "" && begin != null & end != null){
			Double b = gwdtm.getWorkdayTimeInMillis(begin,end,"yyyy-MM-dd HH:mm:ss");
			return String.valueOf(Number2((double)b));
		}else {
			return "";
		}
	}
	
	public static   double   Number2(double   pDouble) 
	{ 
	    BigDecimal     bd=new     BigDecimal(pDouble); 
	    BigDecimal     bd1=bd.setScale(2,bd.ROUND_HALF_UP); 
	    pDouble=bd1.doubleValue(); 
	    long     ll   =   Double.doubleToLongBits(pDouble); 
	    return   pDouble; 
	}
	
}
