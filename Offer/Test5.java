package Offer;

import java.util.*;

public class Test5 {

	public static void main(String[] args) {
//		Test5 instance=new Test5();
//		try {
//			int result=instance.minSum(21);
//			System.out.println(result);
//		} catch (Exception e) {
//		}
		ArrayList<Integer> l=new ArrayList<Integer>();
		l.add(2);
		l.add(3);
		int a=l.remove();
		System.out.println(a);
	}
	public int minSum(int number) throws Exception
	{
		if(number<=0)
		{
			throw new Exception("不是自然数");
		}
		else{
			int result=0;
			int i=(int)Math.sqrt(number);
			for(;i>=2;i--){
				if((number%i)==0)
				{
					result+=minSum(i);
					result+=minSum(number/i);
					break;
				}
			}
			if(i==1){
				return number;
			}
			else {
				return result;
			}
		}
		
	}
//	private int getMinChild(int number) throws Exception{
//		if(number<=0)
//		{
//			throw new Exception("不是自然数");
//		}
//		else {
//			if (number==1){
//				return number;
//			}
//			else {
//				int result=number;
//				for(int i=2;i<=Math.sqrt(number);i++)
//				{
//					if((number%i)==0){
//						result=i;
//						break;
//					}
//				}
//				return result;
//			}
//		}
//	}

}
