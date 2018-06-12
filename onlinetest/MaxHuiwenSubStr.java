package onlinetest;

import java.util.Scanner;

public class MaxHuiwenSubStr {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		while(in.hasNext()){
			String str=in.nextLine();
			String result=findMaxHuiwenSubStr(str);
			System.out.println(result);
		}

	}
	public static String findMaxHuiwenSubStr(String str){
		String result="";
		if(str!=null && str.length()>0){
			int len=str.length();
			int maxLen=-1;
			int firstIdx=0;
			int endIdx=0;
			//动态规划思想
			boolean[][] huiwenMatrix=new boolean[len][len];
			for(int k=0;k<len;k++){
				for(int i=0,j=k;j<len;j++,i++){
					if(i==j){
						huiwenMatrix[i][j]=true;
					}
					else{
						if((j-i)>1){  //长度大于3
							if(str.charAt(i)==str.charAt(j)){
								huiwenMatrix[i][j]=huiwenMatrix[i+1][j-1];
							}
							else{
								huiwenMatrix[i][j]=false;
							}
						}
						else{   //长度等于2
							if(str.charAt(i)==str.charAt(j)){
								huiwenMatrix[i][j]=true;
							}
							else{
								huiwenMatrix[i][j]=false;
							}
						}
					}
				}
			}
			//取出最大的子串
			for(int i=0;i<len;i++){
				for(int j=i;j<len;j++){
					if(huiwenMatrix[i][j]==true){
						if((j-i+1)>maxLen){
							maxLen=j-i+1;
							firstIdx=i;
							endIdx=j;
						}
					}
				}
			}
			result=str.substring(firstIdx, endIdx+1);
		}
		return result;
	}

}
