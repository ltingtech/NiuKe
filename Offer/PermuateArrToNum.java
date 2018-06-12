package Offer;

public class PermuateArrToNum {

	public static void main(String[] args) {
		
		int[] numbers=new int[]{3,5,1,4,2};
		String str=PrintMinNumber(numbers);
		System.out.println(str);
	}
	 public  static String PrintMinNumber(int [] numbers) {
	        /*
	        String[] numStr=new String[]();
	        for(int i=0;i<numbers.length;i++){
	            numStr.add(new String(numbers[i]));
	        }
	        */
	        //插入排序
	        for(int j=1;j<numbers.length;j++){
	            int temp=numbers[j];
	            int k=j-1;
	            while(k>=0){
	                if(isAHeaderThanB(temp,numbers[k])){
	                    numbers[k+1]=numbers[k];
	                    k--;
	                }
	                else{
	                    break;
	                }
	            }
	            numbers[k+1]=temp;
	        }
	        StringBuffer strBuff=new StringBuffer();
	        for(int index=0;index<numbers.length;index++){
	            strBuff.append(numbers[index]);
	        }
	        return strBuff.toString();

	    }
	private  static boolean isAHeaderThanB(int A,int B){  //小的放前面
        boolean result=false;
        if(A>0&&B>0){
            String strA=Integer.toString(A);
            String strB=Integer.toString(B);
            String AB=strA+strB;   //要保证AB<BA才返回true；
            String BA=strB+strA;
            char[] arrA=AB.toCharArray();
            char[] arrB=BA.toCharArray();
            int minLen=arrA.length>arrB.length?arrB.length:arrA.length;
            int idx=0;
            for(;idx<minLen;idx++){
                if(arrA[idx]>arrB[idx]){
                    result=false;
                    break;
                }
                if(arrA[idx]<arrB[idx]){
                    result=true;
                    break;
                }
                else{
                    continue;
                }
            }
        }
        return result;
    }

}
