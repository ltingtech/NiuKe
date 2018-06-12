package Offer;

public class RotateArr {

	public static void main(String[] args) {
		int [] array=new int[]{9991,9992,21,56,65,97,129,130};
		int len=array.length;
		try {
			int min=findMinInRotateArr(array);
			System.out.println(min);
		} catch (Exception e) {
		}
		

	}
	public static int findMinInRotateArr(int[] array) throws Exception{
		if(array==null){
            throw new Exception("null array");
        }
		else {
			if(array.length==0){
				return 0;
			}
			else {
				int headIdx=0,tailIdx=array.length-1;
				if(array[headIdx]<array[tailIdx]){
					return array[headIdx];
				}
				else {
					int mediumIdx=0;
					while(tailIdx-headIdx>1){
						mediumIdx=(headIdx+tailIdx)/2;
						if(array[headIdx]==array[tailIdx]&&array[headIdx]==array[mediumIdx]){
							return minNumberInRotateArray(array);
						}
						else {
							if(array[mediumIdx]>=array[headIdx]){
								headIdx=mediumIdx;
								continue;
							}
							else {
								if(array[mediumIdx]<=array[tailIdx])
								{
									tailIdx=mediumIdx;
									continue;
								}
								else {
									throw new Exception("invalid input");
								}
							}
						}
					}
					return array[tailIdx];
				}
			}
		}
	}
	 public static  int minNumberInRotateArray(int [] array) throws Exception {
	        if(array==null){
	            throw new Exception("null array");
	        }
	        else{
	            if(array.length==0){
	            	return 0;
	        	}
	            else
	                {
	                int idx=0;
	                for(;idx<array.length-1;idx++){
	                	if(idx==203)
	                	{
	                		System.out.println();
	                	}
	                    if(array[idx]<=array[idx+1]){
	                        continue;
	                    }
	                    else{
	                        break;
	                    }
	                }
	                if(idx==array.length-1){
	                    return array[0];
	                }
	                else{
	                    return array[idx+1];
	                }
	            }
	        }
	        
	    
	    }

}
