package Offer;

import java.util.*;

public class TreeDepthStr {

	public static void main(String[] args) {
		Scanner cin=new Scanner(System.in);
		while(cin.hasNext()){
			String treeStr=cin.nextLine();
			String nodeStr=cin.nextLine();
			String resultString=getDepth(treeStr, nodeStr);
			System.out.println(resultString);
		}
		cin.close();

	}
	public static String getDepth(String treeStr,String nodeStr){
		StringBuffer buff=new StringBuffer();
		int len=treeStr.length()/2;  //纯字符的长度
		for(int i=0;i<nodeStr.length();i++){
			int first=0;
			for(;first<treeStr.length();first++){
				if(treeStr.charAt(first)!=nodeStr.charAt(i)){
					continue;
				}
				else{
					break;
				}
			}
			if(first<treeStr.length()){
				int c1=Integer.parseInt(treeStr.substring(first+1, first+2));
				int end=first/2;
				while(end<len){
					end=(end+1)*2-1;
				}
				end=end/2;
				int c2=Integer.parseInt(treeStr.substring(end*2+1,end*2+2));
				buff.append(c2-c1+1);
				buff.append(" ");
			}
			else{
				buff.append(0);
				buff.append(" ");
			}
			
		}
		String result=buff.toString();
		if(result!=null&& result.length()>0){
			result=result.substring(0,result.length()-1);
		}
		return result;
	}

}
