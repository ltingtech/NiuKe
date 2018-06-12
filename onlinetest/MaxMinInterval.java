package onlinetest;

import java.util.*;

public class MaxMinInterval {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		while(in.hasNext()){
			int num=in.nextInt();
			int[] dataArr=new int[num];
			for(int i=0;i<num;i++){
				dataArr[i]=in.nextInt();
			}
			Arrays.sort(dataArr);
			int minCount=getMinCount(dataArr);
			int maxCount=getMaxCount(dataArr);
			System.out.println(minCount+" "+maxCount);
		}

	}
	public static int getMinCount(int[] dataArr){
		int result=0;
		if(dataArr!=null && dataArr.length>0){
			int len=dataArr.length;
			if(dataArr[len-1]==dataArr[0]){
				result=len*(len-1)/2;
			}
			else{
				int min=Integer.MAX_VALUE;
				for(int i=0;i<len-1;i++){
					for(int j=i+1;j<len;j++){
						int minInterval=dataArr[j]-dataArr[i];
						if(minInterval<min){
							min=minInterval;
							result=1;
						}
						else{
							if(minInterval==min){
								result++;
							}
						}
						//
						if(dataArr[j]!=dataArr[i]){
							break;
						}
						else{
							continue;
						}
					}
				}
			}
			
		}
		return result;
	}
	
	public static int getMaxCount(int [] dataArr){
		int result=0;
		if(dataArr!=null && dataArr.length>0){
			int len=dataArr.length;
			if(dataArr[len-1]==dataArr[0]){
				result=len*(len-1)/2;
			}
			else{
				int min=dataArr[0];
				int max=dataArr[len-1];
				int minCount=0;
				int maxCount=0;
				for(int i=0;i<len;i++){
					if(dataArr[i]==min){
						minCount++;
					}
				}
				for(int j=len-1;j>0;j--){
					if(dataArr[j]==max){
						maxCount++;
					}
				}
				result=minCount*maxCount;
			}
		}
		return result;
	}

}
