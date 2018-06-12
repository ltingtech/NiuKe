package onlinetest;

import java.util.*;

public class HuiWenSubStr {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		while(in.hasNext()){
			String str=in.nextLine();
			int result=huiWenSubStrLen(str);
			System.out.println(result);
		}

	}
	public static int huiWenSubStrLen(String str){
		int result=0;
		if(str!=null){
			int len=str.length();
			//利用动态规划的方法进行处理
			/*
			 * huiWenLen[i][j]保存字符串中下标i到j的子字符串中最长回文长度。
			初始条件：if(i==j) huiWenLen[i][j] = 1;
			如果str.charAt(i) = str.charAt(j),当然如果i到j只有2个字符，huiWenLen[i][j] = 2;
			huiWenLen[i][j] =max( huiWenLen[i+1][j-1]+2,huiWenLen[i+1][j],huiWenLen[i][j-1]);
			如果str.charAt(i)!=str.charAt(j);huiWenLen[i][j] = max{huiWenLen[i+1][j],huiWenLen[i][j-1]};
			 * */
			int[][] huiWenMatrix=new int[len][len];
			for(int k=0;k<len;k++){
				for(int i=0,j=k;j<len;j++,i++){
					if(i==j){
						huiWenMatrix[i][j]=1;
					}
					else{
						if(str.charAt(i)==str.charAt(j)){
							if((j-1)>1)
							{
								int t=huiWenMatrix[i+1][j]>huiWenMatrix[i][j-1]?huiWenMatrix[i+1][j]:huiWenMatrix[i][j-1];
								huiWenMatrix[i][j]=(huiWenMatrix[i+1][j-1]+2)>t?(huiWenMatrix[i+1][j-1]+2):t;
							}
							else{
								huiWenMatrix[i][j]=2;
							}
						}
						else{
							if(huiWenMatrix[i+1][j]>huiWenMatrix[i][j-1]){
								huiWenMatrix[i][j]=huiWenMatrix[i+1][j];
							}
							else{
								huiWenMatrix[i][j]=huiWenMatrix[i][j-1];
							}
						}
					}
				}
			}
			result=len-huiWenMatrix[0][len-1];
		}
		return result;
	}

}
