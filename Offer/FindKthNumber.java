package Offer;
import java.util.*;

public class FindKthNumber {

	public static void main(String[] args) {
		FindKthNumber instance=new FindKthNumber();
		int[] array=new int[]{4,5,1,6,2,7,3,8};
		ArrayList<Integer> resultArrayList=instance.GetLeastNumbers_Solution(array, 0);
		System.out.println(resultArrayList);
	}
//	public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
//        ArrayList<Integer> result=null;
//        if(input.length>=k){
//        	result=new ArrayList<Integer>();
//            int tmp=0;
//            int partitionIdx=0;
//            int first=-1,end=-1;
//           	int len=input.length;
//            while(partitionIdx!=(k-1)){
//                if(partitionIdx<(k-1)){
//                    first=partitionIdx;
//                    end=len-1;
//                }
//                else{
//                    first=0;
//                    end=partitionIdx;
//                }
//                //开始类似快速排序查找
//                int temp=input[first];
//                int i=first,j=end;
//                while(i<j){
//                    while(i<j && input[j]>temp){
//                        j--;
//                    }
//                    input[i]=input[j];
//                    while(i<j && input[i]<=temp){ //一定得是<=
//                        i++;
//                    }
//                    input[j]=input[i];
//                }
//                if(i==j){
//                	input[i]=temp;
//                    partitionIdx=i;
//                }
//            }
//            for(int i=0;i<=partitionIdx;i++){
//                result.add(input[i]);
//            }
//        }
//        return result;
//        
//    }

	
	public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> result=new ArrayList<Integer>();
        if(input.length>=k&& k>0){
            ArrayList<Integer> heap=new ArrayList<Integer>();
            int len=input.length;
            heap.add(0);
            for(int i=1;i<=k;i++){
                heap.add(input[i-1]);
            }
            for(int j=k/2;j>=1;j--){  //初始化堆
                shift(heap,j);  
            }
            for(int m=k;m<len;m++){
                if(input[m]<heap.get(1)){ //如果不判断k值，当k值为0时会抛出空指针异常
                    heap.set(1,input[m]);
                    shift(heap,1);     //一直需要更新
                }
            }
            for(int ii=1;ii<=k;ii++){
                result.add(heap.get(ii));
            }
        }
        return result;
        
    }
    
   
     private void shift(ArrayList<Integer> data,int i)
        {
	        if(data!=null && i<=data.size()/2){
	        	
	            int len=data.size();
	            int temp=data.get(i);
	            int j=2*i;
	            while(j<len){
	                if(j<len-1 && data.get(j+1)>data.get(j)){
	                    j++;
	                }
	                if(temp<data.get(j)){
	                    data.set(i,data.get(j));
	                    i=j;
	                    j=2*i;
	                }
	                else{
	                    break;
	                }
	            }
	            data.set(i,temp); //最后放回去  
	        	}
        }
}
