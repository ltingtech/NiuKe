package onlinetest;

public class UniquePathInMatrixWithStacle {

	public static void main(String[] args) {
//		int [][] initialMap=new int[][]{{0,1,0},{0,0,1},{0,1,0}};
		int[][] initialMap=new int[][]{{8,2,4,6},{4,-1,2,-1},{-1,6,4,10},{5,-1,8,8}};
		int minPath=getMinPathWithStacle(initialMap);
//		int result=getUniquePath(initialMap);
//		System.out.println(result);
		System.out.println(minPath);
	}
	public static int getUniquePath(int[][] initialMap){
		int result=0;
		if(initialMap!=null && initialMap.length>0){
			int len1=initialMap.length;
			int len2=initialMap[0].length;
			int[][] pathMatrix=new int[len1][len2];
			if(initialMap[0][0]==0&& initialMap[len1-1][len2-1]==0){
				//初始化
				pathMatrix[0][0]=1;
				for(int i=1;i<len1;i++){
					if(initialMap[i][0]==1){
						pathMatrix[i][0]=0;
					}
					else{
						pathMatrix[i][0]=pathMatrix[i-1][0];
					}
				}
				for(int j=1;j<len2;j++){
					if(initialMap[0][j]==1){
						pathMatrix[0][j]=0;
					}
					else{
						pathMatrix[0][j]=pathMatrix[0][j-1];
					}
				}
				//开始动态规划
				for(int i=1;i<len1;i++){
					for(int j=1;j<len2;j++){
						if(initialMap[i][j]==1){
							pathMatrix[i][j]=0;
						}
						else{
							pathMatrix[i][j]=pathMatrix[i-1][j]+pathMatrix[i][j-1];
						}
					}
				}
				result=pathMatrix[len1-1][len2-1];
			}
		}
		return result;
	}

	public static int getMinPathWithStacle(int[][] initialMap){
		int result=-1;
		if(initialMap!=null && initialMap.length>0){
			int len1=initialMap.length;
			int len2=initialMap[0].length;
			if(initialMap[0][0]>=0 && initialMap[len1-1][len2-1]>=0){
				int[][] pathMatrix=new int[len1][len2];
				//初始化化
				pathMatrix[0][0]=initialMap[0][0];
				for(int i=1;i<len1;i++){
					if(initialMap[i][0]<0||pathMatrix[i-1][0]<0){
						pathMatrix[i][0]=-1;
					}
					else{
						pathMatrix[i][0]=initialMap[i][0]+pathMatrix[i-1][0];
					}
				}
				for(int j=1;j<len2;j++){
					if(initialMap[0][j]<0 || pathMatrix[0][j-1]<0){
						pathMatrix[0][j]=-1;
					}
					else{
						pathMatrix[0][j]=initialMap[0][j]+pathMatrix[0][j-1];
					}
				}
				
				//开始动态规划
				for(int i=1;i<len1;i++){
					for(int j=1;j<len2;j++){
						if(initialMap[i][j]<0){
							pathMatrix[i][j]=-1;
						}
						else{
							if(pathMatrix[i-1][j]>=0 && pathMatrix[i][j-1]>=0){
								if(pathMatrix[i-1][j]>pathMatrix[i][j-1]){
									pathMatrix[i][j]=initialMap[i][j]+pathMatrix[i][j-1];
								}
								else{
									pathMatrix[i][j]=initialMap[i][j]+pathMatrix[i-1][j];
								}
							}
							if(pathMatrix[i-1][j]<0&&pathMatrix[i][j-1]>=0){
								pathMatrix[i][j]=initialMap[i][j]+pathMatrix[i][j-1];
							}
							if(pathMatrix[i-1][j]>=0&&pathMatrix[i][j-1]<0){
								pathMatrix[i][j]=initialMap[i][j]+pathMatrix[i-1][j];
							}
							if(pathMatrix[i-1][j]<0&&pathMatrix[i][j-1]<0)
							{
								pathMatrix[i][j]=-1;
							}
						}
					}
				}
				result=pathMatrix[len1-1][len2-1];
			}
		}
		return result;
	}
}
