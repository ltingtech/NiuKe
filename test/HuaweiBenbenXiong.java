package test;

import java.util.*;

public class HuaweiBenbenXiong {

	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		while(reader.hasNext()){
			int rows=Integer.parseInt(reader.nextLine());
			int cols=Integer.parseInt(reader.nextLine());
			boolean[][] visitMatrix=new boolean[rows][cols];
			char[][] map=new char[rows][cols];
			for(int i=0;i<rows;i++){
				String line=reader.nextLine();
				for(int j=0;j<cols;j++){
					map[i][j]=line.charAt(j);
				}
			}
			boolean result=process(visitMatrix, map);
			if(result){
				System.out.println("Y");
			}
			else{
				System.out.println("N");
			}
		}
		reader.close();

	}
	private static boolean process(boolean[][] visitMatrix,char[][] map){
		boolean result=false;
		int rows=map.length;
		int colums=map[0].length;
		int homeRow=0;
		int homeCol=0;
		for(int i=0;i<rows;i++){
			for(int j=0;j<colums;j++){
				if(map[i][j]=='B'){
					homeRow=i;
					homeCol=j;
					break;
				}
			}
		}
		visitMatrix[homeRow][homeCol]=true;
		Queue<Integer> stack=new LinkedList<Integer>();
		stack.offer(homeRow);
		stack.offer(homeCol);
		while(!stack.isEmpty()&&!result){
			int row=stack.poll();
			int col=stack.poll();
			if(row>0){  //向上
				if(map[row-1][col]=='-'&& visitMatrix[row-1][col]==false){
					stack.offer(row-1);
					stack.offer(col);
					visitMatrix[row-1][col]=true;
				}
				if(map[row-1][col]=='H'){
					result=true;
				}
			}
			if(row<rows-1){  //向下
				if(map[row+1][col]=='-'&& visitMatrix[row+1][col]==false){
					stack.offer(row+1);
					stack.offer(col);
					visitMatrix[row+1][col]=true;
				}
				if(map[row+1][col]=='H'){
					result=true;
				}
			}
			if(col>0){  //向左
				if(map[row][col-1]=='-'&& visitMatrix[row][col-1]==false){
					stack.offer(row);
					stack.offer(col-1);
					visitMatrix[row][col-1]=true;
				}
				if(map[row][col-1]=='H'){
					result=true;
				}
			}
			if(col<colums-1){  //向右
				if(map[row][col+1]=='-'&& visitMatrix[row][col+1]==false){
					stack.offer(row);
					stack.offer(col+1);
					visitMatrix[row][col+1]=true;
				}
				if(map[row][col+1]=='H'){
					result=true;
				}
			}
		}
		return result;
	}

}
