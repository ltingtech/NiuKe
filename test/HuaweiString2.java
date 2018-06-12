package test;

import java.util.*;

public class HuaweiString2 {

	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		while(reader.hasNext()){
			String str=reader.nextLine();
			String result=process(str);
			System.out.println(result);
		}
		reader.close();

	}
	public static String process(String str){
		StringBuilder result=new StringBuilder();
		int len=str.length();
		char c='.';
		boolean isBegin=true;
		int count=0;
		for(int i=0;i<len;i++){
			char currentChar=str.charAt(i);
			if(isBegin){
				if((currentChar>='a'&& currentChar<='z')||(currentChar>='A'&& currentChar<='Z')){
					c=currentChar;
					count++;
					isBegin=false;
				}
				else{
					continue;
				}
			}
			else{
				if(currentChar==c){
					count++;
				}
				else{
					if((currentChar>='a'&& currentChar<='z')||(currentChar>='A'&& currentChar<='Z')){
						result.append(c);
						result.append(count);
						c=currentChar;
						count=1;
						isBegin=false;
					}
					else{
						continue;
					}
					
				}
			}
		}
		if((c>='a'&& c<='z')||(c>='A'&& c<='Z')){  //处理末尾
			result.append(c);
			result.append(count);
		}
		return result.toString();
	}
}
