package Offer;

public class ReorderArr {

	public static void main(String[] args) {
		ReorderArr instance=new ReorderArr();
//		int[] array=new int[]{2,4,6,1,3,5,7};
//		int[] array=new int[]{1,3,5,6,7};
		int[] array=new int[]{1,2,3,4,5,6,7,8};
		instance.reOrderArray(array);
		for (int i : array) {
			System.out.print(i+" ");
		}

	}
	public void reOrderArray(int [] array) {
        //确保第一个奇数在偶数的前面
        if(array==null || array.length==0){
            return ;
        }
        else{
            int len=array.length;
            int idxOdd=0,idxEven=0;
            while(idxOdd<len){
                if((array[idxOdd]&1)==1)  //若为奇数
                    {
                    break;
                }
                idxOdd++;
            }
            while(idxEven<len){
                if((array[idxEven]&1)==0){   //若为偶数
                    break;
                }
                idxEven++;
            }
            if(idxOdd==len||idxEven==len){    //全为偶数或者全为奇数
                return; 
            }
            else
                {
//                if(idxEven<idxOdd){
//                    int temp=array[idxOdd];
//                    array[idxOdd]=array[idxEven];
//                    array[idxEven]=temp;  //交换顺序
//                    temp=idxOdd;
//                    idxOdd=idxEven;
//                    idxEven=temp;
//                }
//                idxOdd++;
                //开始处理后面的数组
                while(idxOdd<len){
                    if((array[idxOdd]&1)==1){  //r若为奇数则处理
                        if(idxOdd>idxEven){
                            int temp=0;
                            for(int i=idxOdd;i>idxEven;i--){
                                temp=array[i];
                                array[i]=array[i-1];
                                array[i-1]=temp;
                            }
                            idxOdd=idxEven;
                            idxEven++;  //偶数位也要右移一位
                        }
                    }
                    idxOdd++;
                }
            }
        }
    }

}
