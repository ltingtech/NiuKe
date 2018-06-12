package test;

import java.util.Arrays;
import java.util.StringTokenizer;

public class StringTokenizerTest {

	public static void main(String[] args) {
		StringTokenizerTest test=new StringTokenizerTest();
		String[] result=test.SplitStringByCommand("1,2,3,4,5,6,7");
		Arrays.sort(result);
		for(int i=0;i<result.length;i++){
			System.out.println(result[i]);
		}

	}
	//°´¶ººÅ·Ö¸î
	public String[] SplitStringByCommand(String source){
		String[] result=null;
		if(source==null || source.trim().equals(""))
			return result;
		StringTokenizer token=new StringTokenizer(source, ",");
		result=new String[token.countTokens()];
		int i=0;
		while(token.hasMoreTokens()){
			result[i++]=token.nextToken();
		}
		return result;
		
	}

}
