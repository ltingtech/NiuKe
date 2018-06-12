package test;

import java.util.*;

public class JinRTT {

	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		while(reader.hasNext()){
			String line=reader.nextLine();
			String str1="";
			String str2="";
			StringBuilder strB1=new StringBuilder();
			StringBuilder strB2=new StringBuilder();
			boolean flag=false;
			for(int i=0;i<line.length();i++){
				if(!flag){
					if(line.charAt(i)!=' '){
						strB1.append(line.charAt(i));
					}
					else{
						str1=strB1.toString();
						flag=true;
					}
				}
				else{
					if(line.charAt(i)!=' '){
						strB2.append(line.charAt(i));
					}
				}
			}
			str2=strB2.toString();
			boolean result=process(str1, str2);
			System.out.println(result);
//			String[] strArr=line.split("  ");
//			if(strArr.length==2){
//				String str1=strArr[0];
//				String str2=strArr[1];
//				boolean result=process(str1, str2);
//				System.out.println(result);
//			}
//			else{
//				System.out.println("error input");
//			}
		}
		reader.close();

	}
	public static boolean process(String str1,String str2){
		if(str1==null|| str2==null){
			return false;
		}
		else{
			boolean[] map1=new boolean[26];
			boolean[] map2=new boolean[26];
			for(int i=0;i<str1.length();i++){
				char c=str1.charAt(i);
				if(!map1[c-'A']){
					map1[c-'A']=true;
				}
				else{
					continue;
				}
			}
			for(int i=0;i<str2.length();i++){
				char c=str2.charAt(i);
				if(!map2[c-'A']){
					map2[c-'A']=true;
				}
				else{
					continue;
				}
			}
			boolean result=true;
			for(int i=0;i<26;i++){
				if(map1[i]!=map2[i]){
					result=false;
					break;
				}
			}
			return result;
			
		}
	}

}
