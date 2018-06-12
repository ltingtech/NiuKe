package onlinetest;

import java.util.*;
public class StringCombination {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		while(in.hasNext()){
			String str1=in.nextLine();
			String str2=in.nextLine();
			String str3=in.nextLine();
			boolean result=stringCombinate(str1, str2, str3);
			System.out.println(result);
		}
		in.close();

	}

	public static boolean stringCombinate(String str1,String str2,String str3){
		boolean result=false;
		if(str1!=null&& str2!=null &&str3!=null){
			int len1=str1.length();
			int len2=str2.length();
			//matrix[i][j]表示str1的前i个字母和str2的前j个字母可以组成str3的前（i+j）个字母字符串；
			boolean[][] matrix=new boolean[len1+1][len2+1];
			//初始化，处理边界条件
			matrix[0][0]=true;
			for(int i=1;i<=len1;i++){
				if(str1.charAt(i-1)==str3.charAt(i-1)){
					matrix[i][0]=matrix[i-1][0];
				}
				else{
					matrix[i][0]=false;
				}
			}
			for(int j=1;j<=len2;j++){
				if(str2.charAt(j-1)==str3.charAt(j-1)){
					matrix[0][j]=matrix[0][j-1];
				}
				else{
					matrix[0][j]=false;
				}
			}
			//开始正式处理，动态规划
			for(int i=1;i<=len1;i++){
				for(int j=1;j<=len2;j++){
					if(str1.charAt(i-1)==str2.charAt(j-1)&& str2.charAt(j-1)==str3.charAt(i+j-1)){
						matrix[i][j]=matrix[i-1][j]||matrix[i][j-1];
					}
					else{
						if(str1.charAt(i-1)==str3.charAt(i+j-1)){
							matrix[i][j]=matrix[i-1][j];
						}
						if(str2.charAt(j-1)==str3.charAt(i+j-1)){
							matrix[i][j]=matrix[i][j-1];
						}
						if(str1.charAt(i-1)!=str3.charAt(i+j-1)&& str2.charAt(j-1)!=str3.charAt(i+j-1)){
							matrix[i][j]=false;
						}
					}
				}
			}
			result=matrix[len1][len2];
		}
		return result;
	}
}
