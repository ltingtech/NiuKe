package onlinetest;

import java.util.Scanner;

public class MinCutToHuiwenSubStr {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		while(in.hasNext()){
			String str=in.nextLine();
			boolean[][] huiwenMatrix=constructHuiwenMatrix(str);
			int result=getMinCutCount(huiwenMatrix);
			System.out.println(result);
		}
		in.close();

	}
	public static  boolean[][]  constructHuiwenMatrix(String str){
		boolean[][] result=null;
		if(str!=null && str.length()>0){
			int len=str.length();
			result=new boolean[len][len];
			for(int k=0;k<len;k++){
				for(int i=0,j=k;j<len;i++,j++){
					if(i==j){
						result[i][j]=true;
					}
					else{
						if((j-i)>1){ //大于2个
							if(str.charAt(i)==str.charAt(j)){
								result[i][j]=result[i+1][j-1];
							}
							else{
								result[i][j]=false;
							}
						}
						else{ //2个
							if(str.charAt(i)==str.charAt(j)){
								result[i][j]=true;
							}
							else{
								result[i][j]=false;
							}
						}
					}
				}
			}
		}
		return result;
	}

	public static int getMinCutCount(boolean[][] huiwenMatrix){
		int result=0;
		if(huiwenMatrix!=null&&huiwenMatrix.length>0){
			int len=huiwenMatrix.length;
			int[] countArr=new int[len];
			for(int i=0;i<len;i++){
				if(huiwenMatrix[0][i]==true){  //如果直接是回文串，则直接记切割数为0
					countArr[i]=0;
				}
				else{
					int min=Integer.MAX_VALUE;
					boolean flag=false;
					for(int j=i-1;j>=0;j--){
						if(huiwenMatrix[j][i]==true&&countArr[j]+1<min){   //利用得到的回文矩阵的关键代码
							///注意是j-1,不用担心j=0的情况，前面已经处理了，要理解countArr[j-1]是包含了标号为j-1的那个数
							min=countArr[j-1]+1;  
							flag=true;
							break;
						}
					}
					if(!flag){
						min=countArr[i-1]+1;
					}
					countArr[i]=min;
				}
			}
			result=countArr[len-1];
		}
		return result;
	}
}
