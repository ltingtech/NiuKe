package Offer;

import java.util.*;

public class PermutateChar {

	public static void main(String[] args) {
		ArrayList<Integer> list=new ArrayList<Integer>();

	}

	 public ArrayList<String> Permutation(String str) {
	       if(str==null)
	           {
	           return null;
	       }
	        ArrayList<String> result=new ArrayList<String>();
	        if(str!=""){
	            char[] charArr=str.toCharArray();
	            insertSort(charArr);
	            permutate(charArr,0,result);
	        }
	        return result;
	    }
	    private void insertSort(char[] charArr){
	        int len=charArr.length;
	        char temp='a';
	        for(int i=1;i<len;i++)
	            {
	            for(int j=i-1;j>=0;j--){
	                if(charArr[i]<charArr[j]){
	                   	temp=charArr[i];
	                    charArr[i]=charArr[j];
	                    charArr[j]=temp;
	                }
	            }
	        }
	    }
	    private void permutate(char[] charArr,int firstIdx,ArrayList<String> strList){
	        int len=charArr.length;
	        if(firstIdx==len-1){
	            strList.add(new String(charArr));   //注意不能用toString()方法替代
	            return;
	        }
	        else
	            {
	            for(int i=firstIdx;i<len;i++){
	                if(i>firstIdx&&charArr[i]== charArr[firstIdx])
	                    {
	                    continue;
	                }
	                char temp=charArr[i];   //利用交换的方法进行排列组合
	                charArr[i]=charArr[firstIdx];
	                charArr[firstIdx]=temp;
	                permutate(charArr,firstIdx+1,strList);
	                //结束后记得调换回来
	                temp=charArr[i];
	                charArr[i]=charArr[firstIdx];
	                charArr[firstIdx]=temp;
	            }
	        }
	    }
}
