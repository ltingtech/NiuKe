package test;

import java.util.*;

public class JinRTouTiao {

	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		while(reader.hasNext()){
			String str=reader.nextLine();
			int result=process2(str);
			System.out.println(result);
		}

	}
	public static int process(String str){
		if(str==null){
			return 0;
		}
		else{
			int len=str.length();
			int result=0;
			for(int i=0;i<len;i++){
				boolean flag=true;
				for(int j=0;j<len;j++){
					int k=(len-i+j)%len;
					if(str.charAt(j)==str.charAt(k)){
						continue;
					}
					else{
						flag=false;
						break;
					}
				}
				if(flag){
					result++;
				}
			}
			return result;
		}
	}
	
	public static int process2(String str){
		if(str==null){
			return 0;
		}
		else{
			int len=str.length();
			int result=1;
			boolean flag=isAllSame(str);
			if(flag){
				return len;
			}
			else{
				for(int j=2;j<=len/2;j++){
					if(len%j==0){
						if(isCycle(str, j)){
							result=j;
						}
					}
				}
			}
			return result;
		}
	}
	public static boolean isAllSame(String str){
		boolean result=true;
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)==str.charAt(0)){
				continue;
			}
			else{
				result=false;
				break;
			}
		}
		return result;
	}
	public static boolean isCycle(String str,int k){
		int len=str.length();
		boolean flag=true;
		for(int i=0;i<k;i++){
			for(int j=i;j<len;j+=k){
				if(str.charAt(j)==str.charAt(i)){
					continue;
				}
				else{
					flag=false;
					break;
				}
			}
			if(flag){
				continue;
			}
			else{
				break;
			}
		}
		return flag;
	}

}
