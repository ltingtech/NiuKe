package datastruct;

public class SortUtil3 {
	public static void insertSort(double[] data){
		int len=data.length;
		for(int i=1;i<len;i++){
			double temp=data[i];
			int j=i-1;
			while(j>=0 && data[j]>temp){
				data[j+1]=data[j];
				j--;
			}
			j++;
			data[j]=temp;
		}
	}

	public static void shellSort(double[] data){
		int len=data.length;
		for(int d=len/2;d>=1;d/=2){
			for(int i=d;i<len;i++){
				double temp=data[i];
				int j=i-d;
				while(j>=0 && data[j]>temp){
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
		for(int i=len-1;i>0;i--){
			boolean isChanged=false;
			int lastExchIndex=len-1;
			for(int j=1;j<=i;j++){
				if(data[j]<data[j-1]){
					double temp=data[j];
					data[j]=data[j-1];
					data[j-1]=temp;
					isChanged=true;
					lastExchIndex=j;
				}
			}
			if(isChanged){
				i=lastExchIndex;
			}
		}
	}

	public static void quickSort(double[] data,int first,int end){
		if(first>end){
			System.out.println("error in parameter");
		}
		if(first==end)
		{
			return;
		}
		if(first<end){
			int i=first,j=end;
			double temp=data[i];
			while(i<j){
				while(i<j && data[j]>=temp){
					j--;
				}
				data[i]=data[j];
				while(i<j && data[i]<temp){
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
		int i=first,k=first,j=medium+1;
		while(i<=medium && j<=end){
			if(b_data[j]>b_data[i]){
				a_data[k++]=b_data[j++];
			}
			else {
				a_data[k++]=b_data[i++];
			}
		}
		while(i<=medium){
			a_data[k++]=b_data[i++];
		}
		while(j<=end){
			a_data[k++]=b_data[j++];
		}
	}

	public static void mergeSort(double[] b_data,double[] a_data,int first,int end){
		if(first==end){a_data[first]=b_data[first];}
		if(first>end){System.out.println("error");}
		if(first<end){
			int medium=(first+end)/2;
			int len=b_data.length;
			double[] data=new double[len];
			mergeSort(b_data, data, first, medium);
			mergeSort(b_data, data, medium+1, end);
			merge(data, a_data, first, medium, end);
		}
	}

	public static void shift(double[] data,int k,int end){
		int i=k;
		int j=2*i;
		double temp=data[i];
		while(j<=end){
			if(j<end && data[j+1]>data[j])
			{
				j++;
			}
			if(temp<data[j]){
				data[i]=data[j];
				i=j;
				j=2*i;
			}
			else {
				break;  //容易忘记，导致死循环
			}
		}
		data[i]=temp;  //容易忘记，导致出错
	}
	
	public static void heapSort(double[] data){
		int len=data.length;
		if(len<1){
			return;
		}
		else {
			for(int i=(len-1)/2;i>=1;i--){
				shift(data, i, len-1);
			}
			for(int j=len-1;j>1;j--){
				double temp=data[j];
				data[j]=data[1];
				data[1]=temp;
				shift(data,1,j-1);
			}
		}
	}

}
