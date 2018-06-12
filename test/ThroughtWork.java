package test;

import java.text.*;
import java.util.*;

public class ThroughtWork {

	public static void main(String[] args) {
		ThroughtWork instance=new ThroughtWork();
		String input="2016-06-02 20:00~22:00 7\n2016-06-03 09:00~12:00 14\n2016-06-04 14:00~17:00 22\n2016-06-05 19:00~22:00 3\n2016-06-06 12:00~15:00 15\n2016-06-07 15:00~17:00 12\n2016-06-08 10:00~13:00 19\n2016-06-09 16:00~18:00 16\n2016-06-10 20:00~22:00 5\n2016-06-11 13:00~15:00 11";
		String resultString=instance.generateSummary(input);
		System.out.println(resultString);

	}
	/*
	 * 计算盈利总额
	 */
	public String generateSummary(String input){
		String[] orders=input.split("\n");
		List<Order> orderList=new ArrayList<Order>();
		int len=orders.length;
		for(int i=0;i<len;i++){
			Order order=orderResolve(orders[i]);
			orderList.add(order);
		}
		String result=getSummary(orderList);
		return result;
	}
	
	/*
	 * 对多个订单计算盈利总额
	 */
	private String getSummary(List<Order> orderList){
		String result="";
		int len=orderList.size();
		int totalIncom=0;
		int totalPay=0;
		for(int i=0;i<len;i++){  //对每个订单都处理
			int profits=0;
			int pay=0;
			Order order=orderList.get(i);
			int parkCount=order.parkCount;
			if(parkCount>0){
				if(order.isWorkDay){
					for(int j=order.beginHour;j<order.endHour;j++){
						if(j>=9&&j<=11){
							pay+=parkCount*30;
						}
						if(j>=12&&j<18){
							pay+=parkCount*50;
						}
						if(j>=18 && j<20){
							pay+=parkCount*80;
						}
						if(j>=20&& j<22){
							pay+=parkCount*60;
						}
					}
				}
				else{
					//非工作日的情况
					for(int j=order.beginHour;j<order.endHour;j++){
						if(j>=9&&j<=11){
							pay+=parkCount*40;
						}
						if(j>=12&&j<18){
							pay+=parkCount*50;
						}
						if(j>=18 && j<22){
							pay+=parkCount*60;
						}
						
					}
				}
			}
			if(parkCount>0){
				profits=order.personCount*30;
			}
			totalIncom+=profits;
			totalPay+=pay;
			result+=order.information;
			result+=" +"+profits;
			result+=" -"+pay;
			int gap=profits-pay;
			if(gap>0){
				result+=" +"+gap;
			}
			if(gap<=0){
				result+=" "+gap;
			}
			result+="\n";
		}
		result+="\n";  //添加空白行
		result+="Total Income:"+totalIncom;
		result+="\n";
		result+="Total Payment:"+totalPay;
		result+="\n";
		result+="Profit:"+(totalIncom-totalPay);
		return result;
	}
	/*
	 * 从字符串订单信息中解析为一个订单实例
	 */
	public Order orderResolve(String orderString){
		Order order=new Order();
		order.information=orderString;
		String[] contentArr=orderString.split(" ");
		Date date=new Date();
		int day=0;
		try {
			date=parseDate(contentArr[0]);
			day=dayForWeek(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(day<=5){
			order.isWorkDay=true;
		}
		else{
			order.isWorkDay=false;
		}
		String hourString=contentArr[1];
		String[] hours=hourString.split("~");
		order.beginHour=Integer.parseInt(hours[0].split(":")[0]);
		order.endHour=Integer.parseInt(hours[1].split(":")[0]);
		int peopleCount=Integer.parseInt(contentArr[2]);
		order.personCount=peopleCount;
		int parks=getParks(peopleCount);
		order.parkCount=parks;
		return order;
	}
	/*
	 * 根据参与人数确定需要订的球场数
	 */
	private int getParks(int peopleCount){
		if(peopleCount<=3){
			return 0;
		}
		if(peopleCount<=5&&peopleCount>=4){
			return 1;
		}
		if(peopleCount<=15 && peopleCount>=6){
			return 2;
		}
		if(peopleCount<=21 && peopleCount>=16){
			return 3;
		}
		if(peopleCount<=24&& peopleCount>=22){
			return 4;
		}
		if(peopleCount>24){
			return peopleCount/6;
		}
		return 0;
	}
	/*
	 * 从字符串解析成日期格式
	 */
	public static  Date parseDate(String s) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.parse(s);
    }
	/*
	 * 求一个日期对应于星期几，星期日认为是星期七
	 */
	public static int dayForWeek(Date date) throws Exception {
		  Calendar c = Calendar.getInstance();
		  c.setTime(date);
		  int dayForWeek = 0;
		  if(c.get(Calendar.DAY_OF_WEEK) == 1){
		   dayForWeek = 7;
		  }else{
		   dayForWeek = c.get(Calendar.DAY_OF_WEEK) - 1;
		  }
		  return dayForWeek;
		 }

}
/**
 * 定义订单类
 * @author Administrator
 *
 */
class Order{
	public boolean isWorkDay;  //是否是工作日
	public int beginHour;      //开始时间点
	public int endHour;        //结束时间点
	public int personCount;    //参与人数
	public int parkCount;      //订的场地数
	public String information; //订单字符串信息
}
