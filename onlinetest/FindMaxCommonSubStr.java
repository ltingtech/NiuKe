package onlinetest;

import java.util.*;

public class FindMaxCommonSubStr {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		while(in.hasNext()){
			String str1=in.nextLine();
			String str2=in.nextLine();
			String result=findMaxCommonSubStr(str1, str2);
			System.out.println(result);
		}

	}
	public static String findMaxCommonSubStr(String str1,String str2){
		String resultString="";
		if(str1!=null && str1.length()>0 && str2!=null && str2.length()>0){
			int len1=str1.length();
			int len2=str2.length();
			int [][] matrix=new int[len1][len2]; //matrix[i][j]表示以str1[i]和str2[j]结尾的两个子串的公共长度
			for(int i=0;i<len1;i++){
				if(str1.charAt(i)==str2.charAt(0)){
					matrix[i][0]=1;
				}
			}
			for(int j=0;j<len2;j++){
				if(str1.charAt(0)==str2.charAt(j)){
					matrix[0][j]=1;
				}
			}
			for(int i=1;i<len1;i++){
				for(int j=1;j<len2;j++){
					if(str1.charAt(i)==str2.charAt(j)){
						matrix[i][j]=matrix[i-1][j-1]+1;
					}
					else{
						matrix[i][j]=0;
					}
				}
			}
			//在已得到的矩阵中得到最长子串
			int maxLen=0;
			int endIdxInStr1=0;
			for(int i=0;i<len1;i++){
				for(int j=0;j<len2;j++){
					if(matrix[i][j]>maxLen){
						maxLen=matrix[i][j];
						endIdxInStr1=i;
					}
				}
			}
			if(maxLen>0){
				resultString=str1.substring(endIdxInStr1-maxLen+1, endIdxInStr1+1);
			}
		}
		return resultString;
	}

}
