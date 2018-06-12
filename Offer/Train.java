package Offer;

import java.util.*;

public class Train {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		while(in.hasNext()){
			String strArrString=in.nextLine();
			char[] strArr=strArrString.toCharArray();
			char[] str1=in.nextLine().toCharArray();
			char[] str2=in.nextLine().toCharArray();
			boolean isForward=process(strArr, str1, str2);
			reverse(strArr);
			reverse(str1);
			reverse(str2);
			boolean isInverse=process(strArr, str1, str2);
			if(isForward==true&&isInverse==false){
				System.out.println("forward");
			}
			else{
				if(isForward==true&&isInverse==true){
					System.out.println("both");
				}
				else{
					System.out.println("invalid");
				}
			}
			
		}
		in.close();

	}
	public static boolean process(char[] strArr,char[] str1,char[] str2){
		if(strArr==null && str1==null && str2==null){
			return true;
		}
		boolean result=false;
		if(strArr!=null){
			int loopFirst=0;
			while(loopFirst<strArr.length)
			{
				boolean isContainStr1=hasSubStr(strArr, str1, loopFirst, strArr.length-1);
				if(isContainStr1){
					boolean isContainStr2=hasSubStr(strArr, str2, newFirst, strArr.length-1);
					if(isContainStr2){
						result=true;
						break;
					}
				}
				loopFirst=newFirst;
			}
			return result;
		}
		return false;
	}
	
	
	public static boolean hasSubStr(char[] strArr,char[] subStr,int first,int end){
		newFirst=0;
		if(strArr==null && subStr==null){
			return true;
		}
		if(strArr!=null){
			if(subStr==null||subStr.length==0){
				return true;
			}
			else{
				for(int i=first;i<=end;i++){
					if(strArr[i]==subStr[0]){
						for(int j=0;j<subStr.length;j++){
							if(j==subStr.length-1&& strArr[i+j]==subStr[j]){
								newFirst=i+j+1;
								return true;
							}
							else{
								if(strArr[i+j]==subStr[j]){
									continue;
								}
								else{
									break;
								}
							}
						}
					}
					else{
						continue;
					}
				}
				newFirst=end+1; //结尾
			}
		}
		return false;
	}
	
	public static void reverse(char[] str){
		int len=str.length;
		for(int i=0,j=len-1;i<=j;i++,j--){
			char c=str[i];
			str[i]=str[j];
			str[j]=c;
		}
	}
	
	private static int newFirst=0;

}
