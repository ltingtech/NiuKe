package Offer;

public class MaxBalanceNum {

	public static void main(String[] args) {
//		char[] charArr="abccba".toCharArray();
		char[] charArr="iqiyiyiq".toCharArray();
		int result=getMaxBalanceNum(charArr);
		System.out.println(result);

	}
	
	public static int getMaxBalanceNum(char[] charArr)
	{
		if(charArr==null ||charArr.length==0){
			return 0;
		}
		else {
			int maxLen=1;
			int len=charArr.length;
			for(int i=1;i<len;i++){
				//对称
				int k=i-1,m=i+1;
				int count=1;
				while(k>=0 && m<len)
				{
					if(charArr[k]==charArr[m])
					{
						count++;
						k--;
						m++;
					}
					else {
						break;
					}
				}
				maxLen=maxLen>count?maxLen:count;
				
				//不对称
				int kk=i,mm=i+1;
				count=0;
				while(kk>=0 && mm<len){
					if(charArr[kk]==charArr[mm])
					{
						kk--;
						mm++;
						count++;
					}
					else {
						break;
					}
				}
				maxLen=maxLen>count?maxLen:count;
				count=0;
			}
			return maxLen;
		}
	}

}
