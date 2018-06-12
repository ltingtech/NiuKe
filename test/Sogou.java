package test;

import java.util.*;

public class Sogou {

	public static void main(String[] args) {
//		LinkedHashMap<Integer, Integer> map=new LinkedHashMap<Integer, Integer>();
//		
//		Scanner reader=new Scanner(System.in);
//		while(reader.hasNext()){
//			int len=reader.nextInt();
//			int r=reader.nextInt();
//			int[] arr=new int[len];
//			for(int i=0;i<len;i++){
//				arr[i]=reader.nextInt();
//			}
//			int result=process(arr, r);
//			System.out.println(result);
//		}
//		reader.close();
		SingleTon singleTon = SingleTon.getInstance();
	    System.out.println("count1=" + singleTon.count1);
	    System.out.println("count2=" + singleTon.count2);

	}
	
	public static int process(int[] arr,int r){
		int len=arr.length;
		int[] temp;
		int[] copy=new int[len];
		for(int i=r;i<=len;i++){
			temp=new int[i];
			for(int j=0;j<len;j++){
				int count=1;
				while(count<=i){
					int index=j+count-1;
					if(index<len){
						temp[count-1]=arr[index];
					}
					else{
						temp[count-1]=arr[index-len];
					}
					count++;
				}
				System.out.println();
				Arrays.sort(temp);
				copy[j]=temp[i/2];  //i即表示r
				if(j==len-1){
					int[] t=copy;
					copy=arr;
					arr=t;
				}
				
			}
			
			
		}
		return arr[0];
	}

	
}
class SingleTon {
	 public static int count2 = 0;
	  private static SingleTon singleTon = new SingleTon();
	  public static int count1;
	 

	  private SingleTon() {
	    count1++;
	    count2++;
	  }

	  public static SingleTon getInstance() {
	    return singleTon;
	  }
	}
