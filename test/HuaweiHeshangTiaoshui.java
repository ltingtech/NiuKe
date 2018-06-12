package test;

import java.util.*;

public class HuaweiHeshangTiaoshui {

	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		while(reader.hasNext()){
			int[][] matrix=new int[7][7];
			for(int i=0;i<7;i++){
				for(int j=0;j<7;j++){
					matrix[i][j]=reader.nextInt();
				}
			}
			pathList.clear();
			boolean[] isBusy=new boolean[7];
			process(matrix, isBusy, 0);
			int len=pathList.size();
			System.out.println(len);
			for(int j=0;j<len;j++){
				System.out.println(pathList.get(j));
			}
			
		}
		reader.close();

	}
	private static List<String> pathList=new ArrayList<String>();
	private static List<Integer>  path=new ArrayList<Integer>();
	public static void process(int[][] matrix,boolean[] isBusy,int day){
		if(day==6){   //安排到第7天了
			for(int i=0;i<isBusy.length;i++){
				if(isBusy[i]==false){
					if(matrix[i][day]==1){
						isBusy[i]=true;
						path.add(i);
						StringBuilder s=new StringBuilder();
						s.append(path.get(0)+1);
						for(int k=1;k<path.size();k++){
							s.append(" "+(path.get(k)+1));
						}
						pathList.add(s.toString());
						isBusy[i]=false;
						path.remove(path.size()-1);
					}
				}
			}
		}
		else{
			for(int i=0;i<isBusy.length;i++){
				if(isBusy[i]==false&&matrix[i][day]==1){
					isBusy[i]=true;
					path.add(i);
					process(matrix, isBusy, day+1);
					isBusy[i]=false;
					path.remove(path.size()-1);
				}
				
			}
		}
	}
}
