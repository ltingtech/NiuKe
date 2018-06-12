package Offer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class CircleChain {

	public static void main(String[] args) {
		int result=LastRemaining_Solution(5, 2);
		System.out.println(result);

	}
	public static int LastRemaining_Solution(int n, int m) {
		int result=-1;
        if(n>0 && m>0){
        	List<Integer> dataList=new ArrayList<Integer>();
        	for(int i=0;i<n;i++){
        		dataList.add(i);
        	}
        	Iterator<Integer> iter=dataList.iterator();
        	int count=0;
        	int data=0;
        	while(dataList.size()>1){
        		while(iter.hasNext()){
        			data=iter.next();
        			count++;
        			if(count==m){
        				iter.remove();
        				count=0;
        			}
        		}
        		iter=dataList.iterator();
        	}
        	if(dataList.size()==1){
        		result=dataList.get(0);
        	}
        }
        return result;
    }

}
