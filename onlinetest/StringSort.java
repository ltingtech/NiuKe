package onlinetest;

import java.util.*;

public class StringSort {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		while(in.hasNext()){
			String str=in.nextLine();
			String result=strSort(str);
			System.out.println(result);
		}

	}
	public static String strSort(String str){
		if(str==null){
			return null;
		}
		else{
			char[] charArr=str.toCharArray();
			int len=charArr.length;
			int lastIndex=0;
			if(charArr[len-1]>'A'&& charArr[len-1]<'Z'){
				lastIndex=len-1;
			}
			else{
				lastIndex=len;
			}
			for(int i=len-2;i>=0;i--){
				if(charArr[i]>='A'&& charArr[i]<='Z'){
					char temp=charArr[i];
					for(int j=i+1;j<lastIndex;j++){
						charArr[j-1]=charArr[j];
					}
					charArr[lastIndex-1]=temp;
					lastIndex--;
				}
			}
			return new String(charArr);
		}
	}

}
