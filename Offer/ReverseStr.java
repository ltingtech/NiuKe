package Offer;

import java.util.Collections;

public class ReverseStr {

	public static void main(String[] args) {
		String str="I am a studeng.";
		String resultStr=ReverseSentence(str);
		System.out.println(resultStr);


	}
	public static String ReverseSentence(String str) {
        if(str==null || str.length()<=0){
            return str;
        }
        else{
            char[] charArr=str.toCharArray();
            int len=charArr.length;
            reverse(charArr,0,len-1);
            int first=0,end=0;
            while(end<len){
                if(charArr[first]==' '&& charArr[end]==' '){
                    first++;
                    end++;
                    continue;
                }
                if(charArr[first]!=' '&& charArr[end]==' ')
                    {
                    reverse(charArr,first,end-1);
                    end++;
                    first=end;
                    continue;
                }
                if(charArr[first]==' ' && charArr[end]!=' ')
                    {
                    first++;
                    end++;
                    continue;
                }
                if(charArr[first]!=' '&& charArr[end]!=' '){
                    end++;
                    continue;
                }
                
            }
            return new String(charArr);
        }
        
    }
    private  static void reverse(char[] charArr,int first,int end){
        if(first>=end){
            return;
        }
        else{
        	while(first<end){
	            char c=charArr[first];
	            charArr[first]=charArr[end];
	            charArr[end]=c;
	            first++;
	            end--;
        	}
        }
    }

}
