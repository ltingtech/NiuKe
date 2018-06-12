package test;

import java.util.*;

public class DiDi {

	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		while(reader.hasNext()){
			/*
			int M=reader.nextInt();
			int N=reader.nextInt();
			List<Integer> list=process(M, N);
			if(M<0){
				System.out.print('-');
			}
			for(int i=list.size()-1;i>=0;i--){
				int ele=list.get(i);
				if(ele>9&& N>9){
					System.out.print((char)(ele-10+'A'));
				}
				else{
					System.out.print(ele);
				}
			}
			System.out.println();
			*/
			
			int n=reader.nextInt();
			int sum=reader.nextInt();
			int[] arr=new int[n];
			for(int i=0;i<n;i++){
				arr[i]=reader.nextInt();
			}
			int count=0;
			if(sum==0){
				for(int i=0;i<n;i++){
					if(arr[i]==0){
						count++;
					}
				}
			}
			else {
				Arrays.sort(arr);
				for(int i=0;i<n/2;i++){
					int temp=arr[i];
					arr[i]=arr[n-1-i];
					arr[n-1-i]=temp;
				}
				count=process(arr, n-1, sum);
			}
			System.out.println(count);
		}

	}

//	public static List<Integer> process(int M,int N){
//		if(N>=2 && N<=16)
//		{
//			if(M<0){
//				M=Math.abs(M);
//			}
//			List<Integer> result=new ArrayList<Integer>();
//			while(M>N){
//				int mod=M%N;
//				result.add(mod);
//				M=M/N;
//			}
//			if(M>0){
//				result.add(M);
//			}
//			return result;
//		}
//		else{
//			return null;
//		}
//	}
	
	public static int process(int[] arr,int end,int sum){
		
		if(end==0){
			if(sum==0){
				return 1;
			}
			if(arr[0]==sum){
				return 1;
			}
			else{
				return 0;
			}
		}
		else{
			if(sum==0){
				return 1;
			}
			else{
				if(arr[end]>sum){
					return 0;
				}
				else{
					int newSum=sum-arr[end];
					int r1=process(arr, end-1, newSum);
					int r2=process(arr, end-1, sum);
					return r1+r2;
				}
			}
			
		}
		
	}

}
