package test;

import java.util.*;

public class HuaiweiString {

	public static void main(String[] args) {
		HuaiweiString instance=new HuaiweiString();
		Scanner reader=new Scanner(System.in);
		while(reader.hasNext()){
			String str=reader.nextLine();
			String result=instance.process(str);
			System.out.print(charSet.size()+" ");
			System.out.print(result.length()+" ");
			System.out.println(str.length()-result.length());
			System.out.println(result);
		}
		reader.close();

	}
	private static Set<Character> charSet=new HashSet<Character>();
	private static char[] charArr=new char[]{'a','A','e','E','i','I','o','O','u','U'};
	private boolean isContains(char c){
		boolean result=false;
		for(int i=0;i<charArr.length;i++){
			if(charArr[i]==c){
				result=true;
				break;
			}
		}
		return result;
	}
	private String process(String str){
		charSet.clear();
		StringBuilder result=new StringBuilder();
		for(int i=0;i<str.length();i++){
			if(isContains(str.charAt(i))){
				result.append(str.charAt(i));
				charSet.add(str.charAt(i));
			}
		}
		return result.toString();
		
	}

}
