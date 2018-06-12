package datastruct;


public class SortUtil {
	/****自己写的**************/
	public static double[] insertSort(double[] originalData)
	{
		int len=originalData.length;
		double temp;
		for(int i=2;i<len;i++)
		{
			temp=originalData[i];
			int j=i-1;
			while(j>=1)
			{
				if(temp<originalData[j])
				{
					originalData[j+1]=originalData[j];
					j--;
				}
				else {
					break;
				}
			}
			originalData[j+1]=temp; //这里常出错
//			String str="";
//			for (double q : originalData) {
//				str+=q;
//				str+=" ";
//			}
//			System.out.println("***********************");
//			System.out.println(str);
		}
		return originalData;
	}
    
	public static double[] insertSort2(double[] originalData){
		int len=originalData.length;
		for(int i=2;i<len;i++)
		{
			int j=i-1;
			originalData[0]=originalData[i];
			while(originalData[0]<originalData[j])
			{
				originalData[j+1]=originalData[j];
				j--;
			}
			j++;
			originalData[j]=originalData[0];
		}
		return originalData;
	}
	
	/*****自己写的*****/
 	public static double[] shellSort(double[] originalData){
		int len=originalData.length;
		double temp=0;
		for(int d=len/2;d>=1;d=d/2)
		{
			for(int i=1;i<=d;i++)
			{
				for(int k=i+d;k<len;k+=d)
				{
					int j=k-d;
					temp=originalData[k];
					while(j>=1)
					{
						if(temp<originalData[j])
						{
							originalData[j+d]=originalData[j];
							j-=d;
						}
						else {
							break;
						}
					}
					originalData[j+d]=temp;
				}
			}
		}
		return originalData;
	}

 	public static double[] shellSort2(double[] originalData){
 		int len=originalData.length;
 		for(int d=len/2;d>=1;d/=2){
 			for(int i=d+1;i<len;i++)
 			{
 				originalData[0]=originalData[i];
 				int j=i-d;
 				while(j>0 && originalData[0]<originalData[j])  //j>0不要忘记了，容易出错
 				{
 					originalData[j+d]=originalData[j];
 					j-=d;
 				}
 				j=j+d;
 				originalData[j]=originalData[0];
 			}
 		}
 		return originalData;
 	}
 	
	public static double[] bubbleSort(double[] originalData){
		int len=originalData.length;
		double temp=0;
		int lastChange=len-1;
		for(int i=len-1;i>1;i--)
		{
			boolean isChanged=false;
			for(int j=2;j<=i;j++)
			{
				if(originalData[j]<originalData[j-1]){
					temp=originalData[j];
					originalData[j]=originalData[j-1];
					originalData[j-1]=temp;
					lastChange=j;
					isChanged=true;
				}
			}
			if(isChanged)
			{
				i=lastChange;
			}
		}
		return originalData;
	}

	public static void bublleSort2(double[] originalData){
		int len=originalData.length;
		boolean flag=false;
		for(int i=len-1;i>1;i--){
			flag=false;
			int exchangeIdx=1;
			for(int j=i;j>=1;j--){
				if(originalData[j]<originalData[j-1]){
					double temp=originalData[j];
					originalData[j]=originalData[j-1];
					originalData[j-1]=temp;
					if(!flag){
						exchangeIdx=j;
						flag=true;
					}
				}
			}
			i=exchangeIdx-1;
		}
	}
	
	public static void bubbleSort3(double[] originalData){
		int len=originalData.length;
		boolean flag=false;
		int lastExChanged=len-1;
		for(int i=len-1;i>=1;i--){
			flag=false;
			for(int j=0;j<i;j++){
				if(originalData[j]>originalData[j+1]){
					double temp=originalData[j+1];
					originalData[j+1]=originalData[j];
					originalData[j]=temp;
					lastExChanged=j;
					flag=true;
				}
			}
			if(flag){
				i=lastExChanged+1; 
				//由于for循环中的还会执行i--;语句，所以这里要看lastExchange是交换的两个数中的左值还是右值，
				//如果是左值就需要先加1，如果是右值就可以之间将lastExchange赋值给i就可以了；
			}
			
		}
	}
	
	public static void quickSort(double[] originalData,int first,int end){
		if(first==end){
			return;
		}
		if(end<first){
			System.out.println("parameter error");
		}
		if(first<end)
		{
			int i=first;
			int j=end;
			double temp=originalData[i];
			while(i<j)
			{
				/*
				while(i<j && temp<originalData[j])
				{
					j--;
				}
				if(i<j)
				{
					originalData[i++]=originalData[j];
				}
				while(i<j && originalData[i]<temp ){
					i++;
				}
				if(i<j){
					originalData[j]=originalData[i];
				}
				*/
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
			}
				
		}
	}

	//
	public static void merge(double[] b_data,double[] a_data,int first,int medium,int end){
		int i=first,k=first,j=medium+1;
		while(i<=medium && j<=end)
		{
			if(b_data[i]<b_data[j])
			{
				a_data[k++]=b_data[i++];
			}
			else{
				a_data[k++]=b_data[j++];
			}
		}
		while(i<=medium)
		{
			a_data[k++]=b_data[i++];
		}
		while(j<=end){
			a_data[k++]=b_data[j++];
		}
	}
	public static void mergeSort(double[] b_data,double[] a_data,int first,int end){
		if(first==end){
			a_data[first]=b_data[first];
			return;
		}
		if(end<first)
		{
			System.out.println("parameter error");
			return;
		}
		if(first<end){
			int medium=(first+end)/2;
			int len=b_data.length;
			double[] temp=new double[len];
			mergeSort(b_data,temp,first, medium);
			mergeSort(b_data, temp, medium+1,end);
			merge(temp, a_data, first, medium, end);
		}
	}

	
	public static void shift(double[] data,int k,int len){
		int j=2*k;
		double temp=data[k];
		while(j<len)
		{
			if(j<len-1 && data[j+1]>data[j])
			{
				j++;
			}
			if(temp<data[j])
			{
				data[k]=data[j];
				k=j;
				j*=2;
			}
			else {
				break;
			}
		}
		data[k]=temp;
	}
	public static void heapSort(double[] data)
	{
		int len=data.length;
		for(int i=(len-1)/2;i>=1;i--)
		{
			shift(data, i,len);
		}
		for(int j=1;j<len;j++){
			System.out.println(data[1]);
			data[1]=data[len-j];
			shift(data, 1,len-j);
		}
	}

	//改进后的归并排序
	public static void mergeSort2(double[] copy,double[] dataArr,int first,int end)
	{
		if(first>end)
		{
			return ;
		}
		if(first==end)
		{
			dataArr[first]=copy[first];
		}
		if(end>first){
			int medium=(first+end)/2;
			mergeSort2(dataArr, copy, first, medium);  
			//方法调用时dataArr, copy两个参数的相对位置变了
			mergeSort(dataArr, copy, medium+1, end);
			int i=first,j=medium+1,k=first;
			while(i<=medium && j<=end)
			{
				if(copy[i]<copy[j]){
					dataArr[k++]=copy[i++];
				}
				else {
					dataArr[k++]=copy[j++];
				}
			}
			while(i<=medium)
			{
				dataArr[k++]=copy[i++];
			}
			while(j<=end){
				dataArr[k++]=copy[j++];
			}
		}
	}
}
