package test;

import java.util.*;


public class VMWare {
	public static void main(String[] args){
//		Scanner sc=new Scanner(System.in);
//		while(sc.hasNext()){
//			int row=sc.nextInt();
//			int col=sc.nextInt();
//			int[][] data=new int[row][col];
//			for(int i=0;i<row;i++){
//				for(int j=0;j<col;j++){
//					data[i][j]=sc.nextInt();
//				}
//			}
//			int result=process(data);
//			System.out.println(result);
//		}
//		sc.close();
////		
//		int a=109;
//		a=a>>1;
//		System.out.println(a);
		Integer a=9;
		method(a);
		System.out.println(a);
		/*
		try {
			method();
			System.out.println("A");
		} catch (RuntimeException e) {
			System.out.println("B");
		}
		catch (Exception e) {
			System.out.println("C");
		}
		finally{
			System.out.println("D");
		}
		System.out.println("E");
		*/
		
	}
	public  static void method(Integer a){
		a=8;
	}
	
	
	public static int process(int[][] data){
		int colums=data.length;
		int rows=data[0].length;
		int totalNum=rows*colums;
		int[] eleArr=new int[totalNum];
		HashMap<Integer,PointEle> map=new HashMap<Integer, PointEle>();
		int count=0;
		for(int i=0;i<rows;i++){
			for(int j=0;j<colums;j++){
				eleArr[count++]=data[i][j];
				map.put(data[i][j], new PointEle(i, j));
			}
		}
		Arrays.sort(eleArr);
		HashMap<Integer, Integer> countMap=new HashMap<Integer, Integer>();
		for(int i=0;i<eleArr.length;i++){
			if(i==0){
				countMap.put(eleArr[i], 1);
			}
			else{
				PointEle p=map.get(eleArr[i]);
				int num=eleArr[i];
				countMap.put(num, 1);
				if(p.row>0&& data[p.row-1][p.col]<num){
					if(countMap.get(data[p.row-1][p.col])+1>countMap.get(data[p.row][p.col])){
						countMap.put(num,countMap.get(data[p.row-1][p.col])+1);
					}
				}
				if(p.col>0&& data[p.row][p.col-1]<num){
					if(countMap.get(data[p.row][p.col-1])+1>countMap.get(data[p.row][p.col])){
						countMap.put(num,countMap.get(data[p.row][p.col-1])+1);
					}
				}
				if(p.row<rows-1&& data[p.row+1][p.col]<num){
					if(countMap.get(data[p.row+1][p.col])+1>countMap.get(data[p.row][p.col])){
						countMap.put(num,countMap.get(data[p.row+1][p.col])+1);
					}
				}
				if(p.col<colums-1&&data[p.row][p.col+1]<num){
					if(countMap.get(data[p.row][p.col+1])+1>countMap.get(data[p.row][p.col])){
						countMap.put(num,countMap.get(data[p.row][p.col+1])+1);
					}
				}
			}
		}
		int max=0;
		for (Integer key : countMap.keySet()) {
			if(countMap.get(key)>max){
				max=countMap.get(key);
			}
			
		}
		return max;
	}
	

}
class PointEle{
	public int row;
	public int col;
	public PointEle(int row,int col){
		this.row=row;
		this.col=col;
	}
}

