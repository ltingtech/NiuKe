package onlinetest;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class XiPai {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int countOfInstance=in.nextInt();
		for(int i=1;i<=countOfInstance;i++){
			int num=in.nextInt();
			int k=in.nextInt();
			List<Integer> data=new LinkedList<Integer>();
			for(int j=1;j<=2*num;j++){
				data.add(in.nextInt());
			}
			xiPai(data, k);
			
			System.out.print(data.get(0));
			for(int m=1;m<data.size();m++){
				System.out.print(" "+data.get(m));
			}
			System.out.println("");
		}
		

	}
	public static  void xiPai(List<Integer>data,int k){
		if(data!=null && data.size()>0){
			while(k>0){
				int start=data.size()/2-1;
				int end=data.size()-1;
				Stack<Integer> stack=new Stack<Integer>();
				while(end>=data.size()/2&& start>=0){
					stack.push(data.get(end));
					stack.push(data.get(start));
					end--;
					start--;
				}
				data.clear();
				while(!stack.isEmpty()){
					data.add(stack.pop());
				}
				k--;
			}
			
		}
	}

}
