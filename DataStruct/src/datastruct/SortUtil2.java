package datastruct;

public class SortUtil2 {
	public static void insertSort(double[] data){
		int len=data.length;
		for(int i=1;i<len;i++){
			double temp=data[i];
			int j=i-1;
			while(j>=0&& data[j]>temp){
				data[j+1]=data[j];
				j--;
			}
			data[j+1]=temp;
		}
	}

	public static void shellSort(double[] data){
		int len=data.length;
		for(int d=len/2;d>=1;d--){
			for(int i=d;i<len;i++){
				int j=i-d;
				double temp=data[i];
				while(j>=0 && temp<data[j])  //注意是j>=0
				{
					data[j+d]=data[j];
					j-=d;
				}
				j+=d;
				data[j]=temp;
			}
		}
	}

	public static void bubbleSort(double[] data){
		int len=data.length;
		int lastChangeIndex=len-1;
		for(int i=len-1;i>=1;i--){
			boolean isChange=false;
			for(int j=1;j<=i;j++){
				if(data[j]<data[j-1]){
					double temp=data[j];
					data[j]=data[j-1];
					data[j-1]=temp;
					isChange=true;
					lastChangeIndex=j;
				}
			}
			if(isChange)
			{
				i=lastChangeIndex;
			}
			else {
				break;
			}
		}
	}

	public static void quickSort(double[] data,int first,int end){
		if(end<first){System.out.println("error");}
		if(end==first){return;}
		if(first<end){
			double temp=data[first];
			int i=first,j=end;
			while(i<j){
				while(i<j && data[j]>temp){//@1
					j--;
				}
				data[i]=data[j];
				while(i<j&& data[i]<=temp){ //@2 @1和@2条件中与temp的比较必须有data[j]>=temp 或data[i]<temp，否则会死循环
					i++;
				}
				data[j]=data[i];
			}
			if(i==j){
				data[i]=temp;
				if(i>first){
					quickSort(data, first, i-1);
				}
				if(i<end){
					quickSort(data, i+1, end);
				}
			}
		}
	}

	public static void merge(double[] b_data,double[] a_data,int first,int medium,int end){
		int i=first,j=medium+1,k=first;
		while(i<=medium && j<=end){
			if(b_data[i]<b_data[j])
			{
				a_data[k++]=b_data[i++];
			}
			else {
				a_data[k++]=b_data[j++];
			}
		}
		while(i<=medium){
			a_data[k++]=b_data[i++];
		}
		while(j<=end){
			a_data[k++]=b_data[j++];
		}
	}
	public static void mergeSort(double[] b_data,double[] a_data,int first,int end)
	{
		if(first==end){
			a_data[first]=b_data[first];
			return;
		}
		if(end<first){
			System.out.println("error");
		}
		if(end>first){
			int medium=(first+end)/2;
			int len=b_data.length;
			double[] temp=new double[len];
			mergeSort(b_data, temp, first, medium);
			mergeSort(b_data, temp, medium+1, end);
			merge(temp, a_data, first, medium, end);	
		}
	}
	
	public static void shift(double[] data,int k,int end){
		int i=k,j=2*i;
		double temp=data[k];
		while(j<=end){
			if(j<end && data[j+1]>data[j]){
				j++;
			}
			if(temp<data[j]){
				data[i]=data[j];
				i=j;
				j=2*i;
			}
			else {
				break;
			}
		}
		data[i]=temp;
	}
	public static void heapSort(double[] data){
		int len=data.length;
		for(int i=(len-1)/2;i>=1;i--){
			shift(data, i, len-1);
		}
		for(int i=len-1;i>1;i--){
			double temp=0;
			temp=data[1];
			data[1]=data[i];
			data[i]=temp;
			shift(data, 1, i-1);
		}
	}
}
