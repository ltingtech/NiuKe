package Offer;

import java.util.*;
public class FindUglyNumber {

	public static void main(String[] args) {

	}
	public static  int GetUglyNumber_Solution(int index) {
        if(index<=0){
            return 0;
        }
        else
            {
            if(index==1){
                return 1;
            }
            else{
                int idx2=0,idx3=0,idx5=0;
                ArrayList<Integer> numbers=new ArrayList<Integer>();
                numbers.add(1);
                int num2=0,num3=0,num5=0;
                for(int i=1;i<=index;i++){
                    num2=2*numbers.get(idx2);
                    num3=3*numbers.get(idx3);
                    num5=5*numbers.get(idx5);
                    int minNum=Math.min(Math.min(num2,num3),num5);
                    numbers.add(minNum);
                    if(num2==minNum){
                        idx2++;
                    }
                    if(num3==minNum){
                        idx3++;
                    }
                    if(num5==minNum){
                        idx5++;
                    }
                }
            	return numbers.get(numbers.size()-1);
            }
        }
	}
}
