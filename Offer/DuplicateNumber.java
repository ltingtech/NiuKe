package Offer;

public class DuplicateNumber {

	public static void main(String[] args) {
		int[] dataArr=new int[]{2,3,1,0,2,5,3};
		int result=findDuplicateNumber(dataArr);
		if(isFind)
		{
			System.out.println(result);
		}
		else {
			System.out.println("not found");
		}

	}
	private static boolean isFind=false;
	public static  int findDuplicateNumber(int[] dataArr){
		if(dataArr==null|| dataArr.length<=0){
			return -1;
		}
		else {
			for(int i=0;i<dataArr.length;i++)
			{
				if(dataArr[i]<0 || dataArr[i]>=dataArr.length){
					return -1;
				}
			}
			for(int j=0;j<dataArr.length;j++)
			{
				int num=dataArr[j];
				int temp=0;
				while(dataArr[j]!=j){
					temp=dataArr[j];
					if(dataArr[temp]==temp)
					{
						isFind=true;
						return temp;
					}
					else {
						dataArr[j]=dataArr[dataArr[j]];
						dataArr[temp]=temp;
					}
					
				}
				
			}
			return -1;
		}
	}

}
