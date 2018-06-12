package Offer;

public class InversePairCount {

	public static void main(String[] args) {
		double[] dataArr=new double[]{5,4,3,2,1};
		int len=dataArr.length;
		double[] copy=new double[len];
		for(int i=0;i<len;i++)
		{
			copy[i]=dataArr[i];
		}
		int result=calculateCount(dataArr, copy, 0, len-1);
		System.out.println(result);
	}
	
	public static int calculateCount(double[] dataArr,double[] copy,int first,int end){
		if(first>end){
			return -1;
		}
		if(first==end)
		{
			return 0;
		}
		else {
			int count=0;
			int mediumIndex=(first+end)/2;
			 //注意到函数递归调用时dataArr与copy参数的位置调换了
			//这样的好处就是只要开数组长度的内存了
			int leftCount=calculateCount(copy,dataArr,first, mediumIndex); 
			int rightCount=calculateCount(copy,dataArr,mediumIndex+1, end);
			if(leftCount>=0){
				count+=leftCount;
			}
			if(rightCount>=0){
				count+=rightCount;
			}
			//合并
			int j=end,i=mediumIndex,k=end;
			while(i>=first && j>mediumIndex)
			{
				while(i>=first && j>mediumIndex && dataArr[i]>dataArr[j])
				{
					copy[k--]=dataArr[i--];
					count+=j-mediumIndex; //注意不能加1
				}
				while(j>mediumIndex && i>=first && dataArr[i]<=dataArr[j])
				{
					copy[k--]=dataArr[j--];
				}
			}
			while(i>=first)
			{
				copy[k--]=dataArr[i--];
			}
			while(j>mediumIndex)
			{
				copy[k--]=dataArr[j--];
			}
			return count;
		}
	}

}
