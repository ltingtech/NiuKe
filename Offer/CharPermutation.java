package Offer;


public class CharPermutation {

	public static void main(String[] args) {
		char[] charArr="abcdf".toCharArray();
		permutation(charArr, 0);

	}
	public static void permutation(char[] charArr,int first)
	{
		if(charArr==null||charArr.length==0)
		{
			return ;
		}
		else {
			int len=charArr.length;
			if(first==len-1){
				System.out.println(charArr);
			}
			else {
				int firstIndex=first;
				for(int currIndex=first;currIndex<len;currIndex++){
					char c=charArr[currIndex];
					charArr[currIndex]=charArr[firstIndex];
					charArr[firstIndex]=c;
					
					permutation(charArr, firstIndex+1);
					//注意需要调换回来
					c=charArr[currIndex];
					charArr[currIndex]=charArr[firstIndex];
					charArr[firstIndex]=c;
				}
			}
			
		}
	}

}
