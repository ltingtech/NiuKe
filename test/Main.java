package test;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int m,n;
		while(in.hasNextInt()){
			m=in.nextInt();
			n=in.nextInt();
			printShuiXH(m, n);
		}

	}
	public static void printShuiXH(int m,int n){
		if(m<100){m=100;}
		else
		{
			if(m>999){m=999;}
		}
		if(n<100){n=100;}
		else {
			if(n>999){n=999;}
		}
		if(n>=m){
			boolean hasSXH=false;
			while(m<=n){
				if(isShuiXH(m))
				{
					System.out.print(m+" ");
					hasSXH=true;
				}
				m++;
			}
			if(hasSXH)
			{
				System.out.println("");
			}
			else {
				System.out.println("no");
			}
			
		}
	}
	public static boolean isShuiXH(int n){
		if(100<=n&& n<=999)
		{
			int a=n%10;
			int b=(n/10)%10;
			int c=n/100;
			if(n==(a*a*a+b*b*b+c*c*c)){
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}

}
