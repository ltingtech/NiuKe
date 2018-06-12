package Offer;

import java.util.Scanner;

public class PrintToMaxDigit {

	public static void main(String[] args) {
		PrintToMaxDigit test=new PrintToMaxDigit();
		Scanner in=new Scanner(System.in);
		while(in.hasNextInt())
		{
			int n=in.nextInt();
			test.printToMax(n);
		}

	}
	public void printToMax(int n)
	{
		if(n<=0){
			return;
		}
		else {
			char[] digitCharArr=new char[n];
			for(int i=0;i<=9;i++)
			{
				digitCharArr[0]=(char)('0'+i);
				printCursorly(digitCharArr,n,0);
			}
		}
	}
	
	private void printCursorly(char[] digitCharArr,int len,int index){
		if(index<len-1)
		{
			index+=1;
			for(int i=0;i<10;i++){   //
				digitCharArr[index]=(char)(i+'0');
				printCursorly(digitCharArr, len, index);
			}
		}
		else {
			printDigit(digitCharArr);
			System.out.println("");
		}
		
	}
	private void printDigit(char[] digitCharArr){
		int len=digitCharArr.length;
		boolean isFirstNoZero=false;
		for(int i=0;i<len;i++){
			if(!isFirstNoZero)
			{
				if(digitCharArr[i]=='0')
				{
					continue;
				}
				else {
					isFirstNoZero=true;
					System.out.print(digitCharArr[i]);
				}
			}
			else {
				System.out.print(digitCharArr[i]);
			}
		}
	}

}
