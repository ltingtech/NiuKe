package Offer;

public class NumOfArray {

	public static void main(String[] args) {
		double[] dataArr=new double[]{2.6,3.0,2.0,3.4,2.0};
		double result=findMoreHalfNum(dataArr);
		System.out.println(result);

	}

	public static double findMoreHalfNum(double[] dataArr)
	{
		int len=dataArr.length;
		int medial=len>>1;
		int partitionIndex=0;
		int first=0,end=len-1;
		while(partitionIndex!=medial){
			partitionIndex=partition(dataArr, first, end);
			if(partitionIndex>medial)
			{
				end=partitionIndex-1;
			}
			if(partitionIndex<medial)
			{
				first=partitionIndex+1;  //一定要加1，才能保证缩小查找范围
			}
		}
		double mediumNum=dataArr[medial];
		if(!checkMoreThanHalf(dataArr, mediumNum, medial))
		{
			return 0;
		}
		else {
			return mediumNum;
		}
		
	}
	public static int partition(double[] dataArr,int first,int end)
	{
		if(dataArr==null|| first>end)
		{
			return -1;
		}
		else {
			if(first==end)
			{
				return first;
			}
			else {
				int i=first,j=end;
				double temp=dataArr[first];
				while(i<j)
				{
					while(i<j && dataArr[j]>=temp){
						j--;
					}
					dataArr[i]=dataArr[j];
					while(i<j && dataArr[i]<temp)
					{
						i++;
					}
					dataArr[j]=dataArr[i];
				}
				if(i==j){
					dataArr[j]=temp;
					return i;
				}
				else {
					return -1;
				}
			}
		}
	}
	
	public static boolean checkMoreThanHalf(double[] dataArr,double mediumNum,int limitNum){
		boolean result=false;
		int count=0;
		for(int i=0;i<dataArr.length;i++)
		{
			if(dataArr[i]==mediumNum)
			{
				count++;
				if(count>limitNum){
					break;
				}
			}
		}
		if(count>limitNum)
		{
			result=true;
		}
		return result;
	}
}
