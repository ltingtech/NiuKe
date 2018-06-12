package test;

import java.util.*;

public class Test {

	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		while(reader.hasNext()){

			int num=reader.nextInt();
			int [] arr=new int[num];
			for(int i=0;i<num;i++){
				arr[i]=reader.nextInt();
			}
			int result=process(arr);
			System.out.println(result);
		}
		reader.close();
		
	}
	private static boolean canNotJump=true;
	public static int process(int[] arr){
		canNotJump=false;
		int lstIndex=arr.length-1;
		int min1=Integer.MAX_VALUE-100;
		for(int i=lstIndex-1;i>=0;i--){
			if(arr[i]>(lstIndex-i)){
				int a=getMinJump(arr, i)+1;
				min1=min1>a?a:min1;
			}
			else{
				continue;
			}
		}
		int min2=getMinJump(arr, lstIndex);
		if(canNotJump){
			return -1;
		}
		return Math.min(min1, min2+1);
	}
	public static  int getMinJump(int[] arr,int lstIndex){
		if(lstIndex==0){
			canNotJump=false;
			return 0;
		}
		int min1=Integer.MAX_VALUE-100000;
		if(arr[lstIndex]>0){
			for(int i=lstIndex-1;i>=0;i--){
				if(arr[i]==lstIndex-i){
					int a=getMinJump(arr, i)+1;
					min1=min1>a?a:min1;
				}
			}

		}
		else{
			canNotJump=true;
		}
		return min1;
	}
	
	
//	private static int lastIndex=0;
//	public static int process(String str){
//		int len=str.length();
//		
//		char[] charArr=str.toCharArray();
//		int minLen=Integer.MAX_VALUE;
//		for(int i=0;i<len;i++){
//			boolean[] allFind=new boolean[]{false,false,false,false,false};
//			char c=charArr[i];
//			if(c=='A'||c=='B'||c=='C'||c=='D'||c=='E'){
//				boolean isFind=false;
//				int j=i;
//				while(j<len&&!isFind){
//					char curr=charArr[j];
//					if(curr=='A'||curr=='B'||curr=='C'||curr=='D'||curr=='E'){
//						allFind[curr-'A']=true;
//						boolean l=true;
//						for(int m=0;m<5;m++){
//							l=l&&allFind[m];
//						}
//						isFind=l;
//						lastIndex=j;
//						j++;
//					}
//					else{
//						j++;
//						continue;
//					}
//					
//				}
//				if(isFind){
//					minLen=minLen>(lastIndex-i+1)?(lastIndex-i+1):minLen;
//				}
//				else{ //说明没找到，从头开始找
//					j=0;
//					while(j<i && !isFind){
//						char curr=charArr[j];
//						if(curr=='A'||curr=='B'||curr=='C'||curr=='D'||curr=='E'){
//							allFind[curr-'A']=true;
//							boolean l=true;
//							for(int m=0;m<5;m++){
//								l=l&&allFind[m];
//							}
//							isFind=l;
//							lastIndex=j;
//							j++;
//						}
//						else{
//							j++;
//							continue;
//						}
//					}
//					
//					if(isFind){
//						minLen=minLen>(len-(i-lastIndex-1))?(len-(i-lastIndex-1)):minLen;
//					}
//					else{
//						minLen=len;
//					}
//				}
//			}
//			else{
//				continue;
//			}
//		}
//		return len-minLen;
//	}
//	
	
	
//	public static int process(long m){
//		int k=(int)Math.ceil((-1+Math.sqrt(1+8*m))/2);
//		long sumMod=0;
//		for(int i=1;i<=k;i++)
//		{
//			sumMod=(sumMod+i)%10;
//		}
////		int  sum=(int)((1+k)/2.0*k);
//		if(sumMod==(m%10)){
//			return k;
//		}
//		else{
//			if(m%2==0){
//				while(sumMod%2==1){
//					k++;
//					sumMod=(sumMod+k)%10;
//				}
//			}
//			else{
//				while(sumMod%2==0){
//					k++;
//					sumMod=(sumMod+k)%10;
//				}
//			}
//
//			
//			return k;
//		}	
//	}
    
 

}
