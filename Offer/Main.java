package Offer;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Scanner in=new Scanner(System.in);
		int num=in.nextInt();
		List<int[]> resultList=new ArrayList<int[]>();
		int i=0;
		while(i<num){
			int n=in.nextInt();
			int[] list=new int[n];
			for(int j=1;j<=n;j++){
				list[j-1]=j;
			}
			resultList.add(listRestore(list));
			i++;
		}
		for (int[] l : resultList) {
			for(int index=0;index<l.length-1;index++){
				System.out.print(l[index]+" ");
			}
			System.out.println(l[l.length-1]);
		}
	}
	public static int[] listRestore(int[] initialList)
	{
		if(initialList.length==1){
			return initialList;
		}
		if(initialList.length>1)
		{
			int len=initialList.length;
			if(len%2==0)
			{
				int[] leftList=new int[len/2];
				int[] rightList=new int[len/2];
				for(int i=0;i<len/2;i++)
				{
					leftList[i]=initialList[i];
					rightList[i]=initialList[len/2+i];
				}
				int[] newRight=listRestore(rightList);
				int j=0;
				while(j<len)
				{
					for(int k=0;k<len/2;k++){
						initialList[j]=newRight[k];
						j++;
						initialList[j]=leftList[k];
						j++;
					}
				}
				return initialList;
				
			}
			else {
				int medium=initialList[len/2];
				int[] leftList=new int[len/2];
				int[] rightList=new int[len/2];
				for(int i=0;i<len/2;i++){
					leftList[i]=initialList[i];
				}
				for(int i=0;i<len/2;i++){
					rightList[i]=initialList[i+len/2+1];
				}
				int[] newRightList=listRestore(rightList);
				initialList[0]=medium;
				int j=1;
				while(j<len){
					initialList[j]=leftList[(j-1)/2];
					j++;
					initialList[j]=newRightList[j/2-1];
					j++;
				}
				return initialList;
			}
		}
		else {
			return null;
		}
		
	}

}
