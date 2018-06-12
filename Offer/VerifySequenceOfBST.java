package Offer;

public class VerifySequenceOfBST {

	public static void main(String[] args) {
		double[] data=new double[]{8,9.5,9,6};
		boolean result=verifySequenceOfBST(data, 0, data.length-1);
		System.out.println(result);

	}
	public static boolean verifySequenceOfBST(double[] sequence,int first,int end){
		if(sequence==null|| first>end){
			return false;
		}
		if(first==end)
		{
			return true;
		}
		else {
			double parentNum=sequence[end];
			boolean leftFlag=false;
			boolean rightFlag=false;
			int i=first;
			while(sequence[i]<parentNum)
			{
				i++;
			}
			int j=i;
			while(j<end)
			{
				if(sequence[j]<parentNum)
				{
					return false;
				}
				j++;
			}
			if(i==first)
			{
				leftFlag=true;
				rightFlag=verifySequenceOfBST(sequence, first, end-1);		
			}
			if(i==end)
			{
				rightFlag=true;
				leftFlag=verifySequenceOfBST(sequence, first, end-1);
			}
			if(i<end && i>first){
				leftFlag=verifySequenceOfBST(sequence, first, i-1);
				rightFlag=verifySequenceOfBST(sequence, i, end-1);
			}
			
			return leftFlag&&rightFlag;
		}
	}

}
