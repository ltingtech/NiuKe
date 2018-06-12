package Offer;

public class FindNumAppearOnece {

	public static void main(String[] args) {
//		int[] array=new int[]{2,4,3,6,3,2,5,5};
//		int[] num1=new int[1];
//		int[] num2=new int[1];
//		FindNumsAppearOnce(array, num1, num2);
	}
	 public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
	        if(array==null || array.length<=0||num1==null || num1.length<=0||num2==null||num2.length<=0){
	            return ;
	        }
	        else{
	            int xorResult=0;
	            for(int i=0;i<array.length;i++){
	                xorResult^=array[i];
	            }
	            int firstIndexOf1=0;
	            while(firstIndexOf1<32)
	                {
	                if((xorResult&(1<<firstIndexOf1))!=0){
	                    firstIndexOf1++;
	                }
	                else{
	                    break;
	                }
	            }
	            if(firstIndexOf1>31){
	                return;
	            }
	            else{
	                num1[0]=0;
	                num2[2]=0;
	                for(int j=0;j<array.length;j++){
	                    if((array[j]&(1<<firstIndexOf1))==0){
	                        num1[0]^=array[j];
	                    }
	                    else{
	                        num2[0]^=array[j];
	                    }
	                }
	            }
	        }
	        return;

	 }
}
