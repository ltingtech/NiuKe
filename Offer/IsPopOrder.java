package Offer;

import java.util.Stack;

public class IsPopOrder {

	public static void main(String[] args) {
		double[] pushData=new double[]{1,2,3,4,5};
		double[] popData=new double[]{2,3,1,5,4};
		boolean result=isPopOrder(null, null);
		System.out.println(result);

	}
	public static boolean isPopOrder(double[] pushOrder,double[] popOrder)
	{
		if(pushOrder==null || popOrder==null ||pushOrder.length!=popOrder.length)
		{
			return false;
		}
		else {
			int len=pushOrder.length;
			Stack<Double> stack=new Stack<Double>();
			int j=0;
			for(int i=0;i<len;i++){
				if(stack.isEmpty()||stack.peek()!=popOrder[i])
				{
					if(j>=len)
					{
						return false;
					}
					while(j<len)
					{
						stack.push(pushOrder[j]);
						if(pushOrder[j]!=popOrder[i]) //入栈的元素与出栈元素仍不相等
						{
							if(j>=len-1)  //已经遍历到末尾
							{
								return false;
							}
							j++;
							continue;
						}
						else {
							j++;
							stack.pop();
							break;
						}
					}
				}
				else {
					stack.pop(); //如果栈顶正好是当前出栈元素，则直接弹出
				}
			}
			return true;
		}
	}
}
