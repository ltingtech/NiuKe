

package test;
//
//import java.util.*;
//
//public class AAA{
//    public static void main(String[] args){
////        Scanner reader=new Scanner(System.in);
////        while(reader.hasNext()){
////            int N=reader.nextInt();
////            int A=reader.nextInt();
////            int B=reader.nextInt();
////            int[] arr=new int[N+1];
////            for(int i=1;i<=N;i++){
////            	arr[i]=reader.nextInt();
////            }
////            int[] upArr=new int[N+1];
////            int[] downArr=new int[N+1];
////            for(int i=1;i<=N;i++){
////            	if((i+arr[i])<=N){
////            		upArr[i]=i+arr[i];
////            	}
////            	else{
////            		upArr[i]=-1;
////            	}
////            	if(i-arr[i]>0){
////            		downArr[i]=i-arr[i];
////            	}
////            	else{
////            		downArr[i]=-1;
////            	}
////            }
////            totalPath=new ArrayList<List<Integer>>();
////            List<Integer> list=new ArrayList<Integer>();
////            minStep(upArr, downArr, A, B, list);
////            List<Integer> result=getLeastPath(totalPath);
////            if(result==null){
////            	System.out.println(-1);
////            }
////            else{
////            	System.out.println(result.size()-1);
////            	for(int i=0;i<result.size();i++){
////            		if(i==0){
////            			System.out.print(result.get(i));
////            		}
////            		else{
////            			System.out.print(" "+result.get(i));
////            		}
////            	}
////            	System.out.println();
////            }
////            
////        }
////        reader.close();
//    	List<Integer> list=new ArrayList<Integer>();
//    	List<Integer> list2=new ArrayList<Integer>();
//    	list.add(8);
//    	list.add(9);
//    	list.add(10);
//    	list2.add(8);
//    	list2.add(9);
//    	list2.add(9);
//    	List<List<Integer>> result=new ArrayList<List<Integer>>();
//    	result.add(list);
//    	result.add(list2);
////    	System.out.println(list-list2);
//    	Collections.sort(result);
//
//    }
//    private  static List<List<Integer>> totalPath=new ArrayList<List<Integer>>();
//    public static void minStep(int[] upArr,int[] downArr, int from,int to,List<Integer> list){
//    	list.add(from);
//    	if(upArr[from]>0){
//    		if(upArr[from]==to){
//    			list.add(to);
//    			List<Integer> copy=new ArrayList<Integer>();
//    			for(int i=0;i<list.size();i++){
//    				copy.add(list.get(i));
//    			}
//    			totalPath.add(copy);
//    			list.remove(list.size()-1);
//    		}
//    		else{
//    			minStep(upArr, downArr, upArr[from], to, list);
//    		}
//    		
//    	}
//    	if(downArr[from]>0){
//    		if(downArr[from]==to){
//    			list.add(to);
//    			totalPath.add(list);
//    			List<Integer> copy=new ArrayList<Integer>();
//    			for(int i=0;i<list.size();i++){
//    				copy.add(list.get(i));
//    			}
//    			totalPath.add(copy);
//    			list.remove(list.size());
//    		}
//    		else{
//    			minStep(upArr, downArr, downArr[from], to, list);
//    		}
//    	}
//    	
//    }
//    public static List<Integer> getLeastPath(List<List<Integer>> path){
//    	if(path==null || path.size()==0){
//    		return null;
//    	}
//    	else{
//    		List<Integer> min=new ArrayList<Integer>();
//    		int count=Integer.MAX_VALUE;
//    		for(int i=0;i<path.size();i++){
//    			List<Integer> p=path.get(i);
//    			if(p.size()<count){
//    				count=p.size();
//    				min=p;
//    			}
//    		}
//    		return min;
//    	}
//    }
///

public class AAA{
	public static void main(String[] args){
		AAA instance=new AAA();
		Thread[] threadList=new MyThread[]{
				instance.new MyThread(),
				instance.new MyThread(),
				instance.new MyThread()
		};
		
		instance.diaodu(threadList);
	}
	private void diaodu(Thread[] threadList){
		if(threadList.length>0){
			int len=threadList.length;
			for(int i=0;i<len;i++){
				threadList[i].start();
				try {
					Thread.sleep(100);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				if(i==len-1){
					try {
						threadList[0].join();
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
				else{
					try {
						threadList[i+1].join();
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
			}
		}
	}
	private class MyThread extends Thread{
		public void run(){
			print();
		}
	}
	private void print(){
		System.out.println(Thread.currentThread().getName()+"is doing");
	}
}



