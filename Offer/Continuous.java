package Offer;

public class Continuous {

	public static void main(String[] args) {
		int[] numbers=new int[]{1,3,2,5,4};
		boolean result=isContinuous(numbers);
		System.out.println(result);
	}
	 public static  boolean isContinuous(int [] numbers) {
	        boolean result=false;
	        bubleSort(numbers);
	        int lstIdxOf0=-1;
	        for(int i=0;i<numbers.length;i++){
	            if(numbers[i]!=0){
	                lstIdxOf0=i-1;
	                break;
	            }
	        }
	        int countOf0=lstIdxOf0+1;
	        int countOfGap=0;
	        for(int j=lstIdxOf0+1;j<numbers.length-1;j++){
	            if(numbers[j]==numbers[j+1])
	            {
	                result=false;
	            	return result;
	            }
	            else{
	                countOfGap+=(numbers[j+1]-numbers[j]-1);
	            }
	        }
	        if(countOfGap<=countOf0){
	            result=true;
	        }
	        return result;
	        
	    }
	    private static  void bubleSort(int[] numbers){
	        if(numbers!=null&& numbers.length>0){
	            int lstChanged=numbers.length-1;
	            boolean isChanged=false;
	            for(int i=numbers.length-1;i>=1;i--){
	            	isChanged=false;
	                for(int j=1;j<=i;j++){
	                    if(numbers[j]<numbers[j-1])
	                    {
	                        int temp=numbers[j];
	                        numbers[j]=numbers[j-1];
	                        numbers[j-1]=temp;
	                        lstChanged=j;
	                        if(!isChanged){
	                            isChanged=true;
	                        }
	                    }
	                }
	                if(isChanged){
	                    i=lstChanged;
	                }
	            }
	        }
	    }

}
