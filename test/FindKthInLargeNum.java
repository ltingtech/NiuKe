package test;

import java.util.*;

public class FindKthInLargeNum {
	public static void main(String[] args) {
		FindKthInLargeNum instance=new FindKthInLargeNum();
//		int result=instance.process(10, 3);
		int[][] arr=new int[][]{
			new int[]{1,2,3,4},
			new int[]{4,3,2,1},
			new int[]{2,3,5,4},
			new int[]{3,7,8,2}
				
		};
		int result=instance.senTime(arr, 1);
		System.out.println(result);
	}
	/*
	public int process(int totalNum,int k){
		if(totalNum>=k){
			Scanner reader=new Scanner(System.in);
			int[] heap=new int[k+1];
			int count=1;
			for(int i=0;i<totalNum;i++){
				int num=reader.nextInt();
				if(count<=k){
					heap[count]=num;
					if(count==k){
						for(int j=k/2;j>=1;j--){
							shift(heap, j, k);
						}
					}
					count++;
				}
				else{
					if(num<heap[1]){
						heap[1]=num;
						shift(heap, 1, k);
					}
					count++;
				}
			}
			reader.close();
			return heap[1];
			
		}
		else{
			System.out.println("have not enough num");
			return -1;
		}
	}
	*/
	
	private static int count=1;
	public int senTime(int[][] arr,int k){
		count=1;
		int rows=arr.length;
		int colums=arr[0].length;
		int lastTotal=0;
		int[] heap=new int[k+1];
		process(arr, k, rows, colums, 0, heap, lastTotal);
		return heap[1];
	}
	public void process(int[][] arr,int k,int rows,int colums,int row,int[] heap,int lastTotal){
		if(row==rows-1){
			for(int i=0;i<colums;i++){
				int num=lastTotal+arr[row][i];
				if(count<=k){
					heap[count]=num;
					if(count==k){
						for(int j=k/2;j>=1;j--){
							shift(heap, j, k);
						}
					}
					count++;
				}
				else{
					if(num<heap[1]){
						heap[1]=num;
						shift(heap, 1, k);
					}
				}
			}
		}
		else{
			for(int i=0;i<colums;i++){
				lastTotal+=arr[row][i];
				process(arr, k, rows,colums,row+1, heap, lastTotal);
				lastTotal-=arr[row][i];
			}
		}
		
	}
	public void shift(int[] data,int k,int end){
		int i=k;
		int j=2*i;
		int temp=data[k];
		while(j<=end){
			if(j<end && data[j]<data[j+1]){
				j++;
			}
			if(temp<data[j]){
				data[i]=data[j];
				i=j;
				j=2*i;
			}
			else{
				break;
			}
		}
		data[i]=temp;
	}
}
