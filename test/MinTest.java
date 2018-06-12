package test;

public class MinTest {

	public static void main(String[] args) {
//		double[] data=new double[]{1,1,1,0,1};
//		MinTest test=new MinTest();
//		double min=test.minFind(data);
//		System.out.println(min);
		double a=0.000000000000000000007;
		double b=0.00000000000000000006;
		System.out.println(a==b);

	}
	public double minFind(double[] data){
		int index1=0,mediumInd=0,index2=data.length-1;
		if(data[mediumInd]>=data[index2]){
			while(index2-index1>1){
				mediumInd=(index1+index2)/2;
				if(data[index1]==data[mediumInd] && data[mediumInd]==data[index2]){
					return minInOrder(data, index1, index2);
				}
				else {
					if(data[mediumInd]>=data[index1]){
						index1=mediumInd;
					}
					if(data[mediumInd]<=data[index2]){
						index2=mediumInd;
					}
				}
			}
			if(index2==index1+1){
				return data[index2];
			}
		}
		return data[index1];
	}
	private double minInOrder(double[] data,int index1,int index2){
		double min=data[index1];
		for(int i=index1+1;i<=index2;i++){
			if(data[i]<min){
				min=data[i];
			}
		}
		return min;
	}

}
