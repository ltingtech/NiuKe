package onlinetest;


public class MinPathInMatrix {

	public static void main(String[] args) {
		int [][] cost=new int[][]{{1,5,8},{3,4,6},{2,7,4}};
		int result=minPath(cost);
		System.out.println(result);

	}
	public static int minPath(int[][] cost){
		int result=0;
		if(cost!=null && cost.length>0){
			int len1=cost.length;
			int len2=cost[0].length;
			int[][] costMatrix=new int[len1][len2];
			//初始化
			int sum=0;
			for(int i=0;i<len1;i++){
				sum+=cost[i][0];
				costMatrix[i][0]=sum;
			}
			sum=0;
			for(int j=0;j<len2;j++){
				sum+=cost[0][j];
				costMatrix[0][j]=sum;
			}
			//动态规划
			for(int i=1;i<len1;i++){
				for(int j=1;j<len2;j++){
					if(costMatrix[i-1][j]<costMatrix[i][j-1]){
						costMatrix[i][j]=cost[i][j]+costMatrix[i-1][j];
					}
					else{
						costMatrix[i][j]=cost[i][j]+costMatrix[i][j-1];
					}
				}
			}
			result=costMatrix[len1-1][len2-1];
		}
		return result;
	}

}
