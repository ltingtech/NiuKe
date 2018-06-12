package Offer;

public class RegrexMatch {

	public static void main(String[] args) {
		char[] str="bb".toCharArray();
		char[] pattern="ba*b.".toCharArray();
		boolean result=match(str, 0, pattern, 0);
		System.out.println(result);
		

	}
	public static boolean match(char[] str,int first1,char[] pattern,int first2){
		if(str==null || pattern==null){
			return false;
		}
		else {
			int strLen=str.length;
			int patternLen=pattern.length;
			if(strLen==0|| patternLen==0){
				return false;
			}
			else {
				if(first1<strLen&& first2<patternLen){
					while(first2<patternLen-1 && pattern[first2+1]=='*'){
						if(str[first1]==pattern[first2])
						{
							first1+=1;
						}
						else {
							first2+=2;
						}
					}
					if(str[first1]==pattern[first2]||pattern[first2]=='.')
					{
						return match(str, first1+1, pattern, first2+1);
					}
				}
				else {
					if(first1==strLen&&first2==patternLen)
					{
						return true;
					}
					else {
						if(first1==strLen)
						{
							if(pattern[first2]=='.')
							{
								return match(str, first1, pattern, first2+1);
							}
							else {
								return false;
							}
						}
					}
				}
				return false;
			}
		}
	}

}
