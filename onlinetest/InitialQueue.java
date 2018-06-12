package onlinetest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InitialQueue {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int countOfInstance=in.nextInt();
		int first=1;
		for(int i=1;i<=countOfInstance;i++){
			int end=in.nextInt();
			List<Integer> result=initialQueue(first, end);
			if(result.size()>0){
				System.out.print(result.get(0));
				for(int j=1;j<result.size();j++){
					System.out.print(" "+result.get(j));
				}
				System.out.println();
			}
		}

	}
	public static List<Integer> initialQueue(int first,int end){
		List<Integer> result=new ArrayList<Integer>();
		if(end>=first){
			if(end==first){
				result.add(end);
			}
			else{
				int len=end-first+1;
				if((len&1)==0){  //偶数
					int medium=(first+end)/2;
					List<Integer> left=new ArrayList<Integer>();
					List<Integer> right=new ArrayList<Integer>();
					for(int i=first;i<=medium;i++){
						left.add(i);
					}
					right=initialQueue(medium+1, end);
					for(int j=0;j<left.size();j++){
						result.add(right.get(j));
						result.add(left.get(j));
					}
				}
				else{  //奇数
					int medium=(first+end)/2;
					List<Integer> left=new ArrayList<Integer>();
					List<Integer> right=new ArrayList<Integer>();
					for(int i=first;i<medium;i++){
						left.add(i);
					}
					right=initialQueue(medium+1, end);
					result.add(medium);
					for(int j=0;j<left.size();j++){
						result.add(left.get(j));
						result.add(right.get(j));
					}				
				}
			}
		}
		return result;
	}

}
