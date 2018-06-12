package Offer;

public class Main2 {

	public static void main(String[] args) {
		double[] data=new double[]{10,2,3,5,6};
		System.out.println(func2(data, 15));

	}
	public static double[] quickSort(double[] originalData,int first,int end){
		if(first==end){
			return originalData;
		}
		if(end<first){
			System.out.println("parameter error");
			return null;
		}
		if(first<end)
		{
			int i=first;
			int j=end;
			double temp=originalData[i];
			while(i<j)
			{
				while(i<j){
					while(i<j && originalData[j]>=temp)
					{
						j--;
					}
					originalData[i]=originalData[j]; //i=j的时候没有影响
					while(i<j && originalData[i]<temp)
					{
						i++;
					}
					originalData[j]=originalData[i];
				}
			}
			if(i==j)
			{
				originalData[i]=temp;
				if(i>first)
				{
					quickSort(originalData, first, i-1);
				}
				if(i<end)
				{
					quickSort(originalData, i+1, end);
				}
			}
			else {
				System.out.println("error in quick");
				return null;
			}
			
			return originalData;	
		}
		return originalData;
	}

	public static int func(double[] data,double number){
		if(data.length==1)
		{
			if(data[0]==number){
				return 1;
			}
			else {
				return 0;
			}
		}
		else {
			if(data[0]<=number/2)
			{
				double newNum=number-data[0];
				double[] restNum=new double[data.length-1];
				for(int i=1;i<data.length;i++)
				{
					restNum[i-1]=data[i];
				}
				return func(restNum, newNum)+func(restNum, number);
				
			}
			else 
			{
				int count=0;
				for(int i=0;i<data.length;i++)
				{
					if(data[i]==number)
					{
						count++;
					}
				}
				return count;
			}
		}
	}

	public static int func2(double[] originalData,double number)
	{
		double[] data=quickSort(originalData, 0, originalData.length-1);
		return func(data, number);
	}
}
