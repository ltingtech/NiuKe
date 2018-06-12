package Offer;

public class PrintProbability {

	public static void main(String[] args) {
		printProbality(4);

	}
	private static int [][] countNum=new int[2][];
	private static final int maxPoint=6;
	public static void calculateCount(int n)
	{
		int flag=0;
		
		for(int i=2;i<=n;i++){
			for(int d=0;d<=n*maxPoint;d++){  //初始化
				countNum[1-flag][d]=0;
			}
			for(int j=i;j<=maxPoint*i;j++){
				for(int k=(j-maxPoint)>(i-1)?j-maxPoint:i-1;k<j;k++){
					countNum[1-flag][j]+=countNum[flag][k];
				}
			}
			flag=1-flag;
		}
	}
	
	public static void printProbality(int n)
	{
		int maxLen=n*maxPoint+1;
		if(n<=0)
		{
			return;
		}
		else {
			countNum[0]=new int[maxLen];
			countNum[1]=new int[maxLen];
			for(int i=1;i<=maxPoint;i++)
			{
				countNum[0][i]=1;
				countNum[1][i]=1;
			}
			calculateCount(n);
		}
		double total=Math.pow(maxPoint, n);
		if(countNum[0][n-1]==0)
		{
			for(int i=n;i<maxLen;i++){
				System.out.println(countNum[0][i]/total);
			}
		}
		else {
			if (countNum[1][n-1]==0) {
				for(int i=n;i<maxLen;i++)
				{
					System.out.println(countNum[1][i]/total);
				}
			}
			else {
				System.out.println("error");
			}
		}
	}

}
