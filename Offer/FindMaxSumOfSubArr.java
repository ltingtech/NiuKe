package Offer;

public class FindMaxSumOfSubArr {
	private static boolean isDataValid=true;
	public static void main(String[] args) {
		double[] dataArr=new double[]{1,-2,3,10,-4,7,2,-5};
		double result=findMaxSum(dataArr);
		System.out.println(result);

	}

	public static double findMaxSum(double[] dataArr)
	{
		if(dataArr==null)
		{
			isDataValid=false;
			return 0;
		}
		else {
			double currentSum=0;
			double maxSum=0;
			for(int i=0;i<dataArr.length;i++)
			{
				if(currentSum<0)
				{
					currentSum=dataArr[i];
				}
				else {
					currentSum+=dataArr[i];
				}
				if(currentSum>maxSum)
				{
					maxSum=currentSum;
				}
			}
			isDataValid=true;
			return maxSum;
		}
		
		
	}
}
