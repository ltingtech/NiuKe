package test;

import java.util.*;

public class TwoEgg100 {

	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		while(reader.hasNext()){
			int n=reader.nextInt();
			int result=process(n);
			System.out.println(result);
		}

	}
	public static int process(int n){
		if(n==1){
			return 1;
		}
		else{
			int[] minNum=new int[n+1];
			minNum[0]=0;
			minNum[1]=1;
			for(int i=2;i<=n;i++){
				int ele=Integer.MAX_VALUE;
				for(int j=1;j<=i;j++){
					int result=1+Math.max(j-1, minNum[i-j]);
					ele=ele>result?result:ele;
				}
				minNum[i]=ele;
			}
			return minNum[n];
		}
	}

}
