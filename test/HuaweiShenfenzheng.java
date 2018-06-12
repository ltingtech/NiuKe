package test;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class HuaweiShenfenzheng {

	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		while(reader.hasNext()){
			String str=reader.nextLine();
			if(str.equals("0")){
				break;
				
			}
			else{
				int result=process(str);
				System.out.println(result);
			}
		}
		reader.close();


	}
	public static int process(String str){
		int len=str.length();
		int result=0;
		if(len!=18){
			return 1;
		}
		else{
			for(int i=0;i<17;i++){
				char c=str.charAt(i);
				if(c<'0'||c>'9'){
					return 2;
				}
			}
			char lastChar=str.charAt(17);
			if(!((lastChar>='0'&&lastChar<='9')||lastChar=='x')){
				result=3;
			}
			else{
				result=judgeYearMonth(str);
			}
			
		}
		return result;
	}
	private static int judgeYearMonth(String str){
		int result=0;
		String yearStr=str.substring(6, 10);
		int year=Integer.parseInt(yearStr);
		String monthStr=str.substring(10,12);
		String dayStr=str.substring(12, 14);
		if(year>=1900 && year<=2100){
			if(year%400==0||(year%4==0 && year%100!=0))
			{
				result=judgeMonth(monthStr,dayStr,true);
			}
			else{
				result=judgeMonth(monthStr,dayStr,false);
			}
		}
		else{
			result=4;
		}
		return result;
	}
	private static int judgeMonth(String monthStr,String dayStr,boolean isRunYear){
		int result=0;
		int month=Integer.parseInt(monthStr);
		int day=Integer.parseInt(dayStr);
		if(month>=1&& month<=12){
			int[] month31=new int[]{1,3,5,7,8,10,12};
			if(month!=2){
				if(day==31){
					boolean flag=false;
					for(int i=0;i<month31.length;i++){
						if(month==month31[i]){
							flag=true;
							break;
						}
					}
					if(!flag){
						result=5;
					}
				}
			}
			else{
				if(isRunYear){
					if(day<=0 || day>29){
						result=5;
					}
				}
				else{
					if(day<=0 || day>28){
						result=5;
					}
				}
				
			}
		}
		else{
			result=5;
		}
		return result;
	}

}
