package Offer;

public class InversePairCount2 {
	public static void main(String[] args){
		InversePairCount2 instance=new InversePairCount2();
		int[] array=new int[]{1,2,3,4,5,6,7,0};
		int count=instance.InversePairs(array);
		System.out.println(count);
		
	}
	public int InversePairs(int [] array) {
	       int result=0;
	        if(array!=null){
	            int len=array.length;
	            int[] copy=new int[len];
	            for(int i=0;i<len;i++){
	                copy[i]=array[i];
	            }
	            result=getInversePairs(copy,array,0,len-1);
	        }
	        return result;
	        
	    }
    private int getInversePairs(int[] copy,int[] array,int first,int end){
        if(first>=end){
            return 0;
        }
        else{
            int medium=(first+end)/2;
            int left=getInversePairs(array,copy,first,medium);
            int right=getInversePairs(array,copy,medium+1,end);
            int count=0;
            int i=first,j=medium+1,k=first;
            while(i<=medium && j<=end){
                if(copy[i]<copy[j]){
                    array[k++]=copy[i++];
                }
                else{
                    array[k++]=copy[j++];
                    count+=(medium-i+1);
                }
            }
            while(i<=medium){
                array[k++]=copy[i++];
            }
            while(j<=end){
                array[k++]=copy[j++];
            }
            return left+right+count;
        }
    }

}
