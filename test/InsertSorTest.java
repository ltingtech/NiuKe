package test;

import java.util.ArrayList;
import java.util.List;

public class InsertSorTest {

	public static void main(String[] args) {
		List<Float> source=new ArrayList<Float>();
		float[] eleList={5,7,3,2,8,9,23,45,43,14,26};
		for (float ele : eleList) {
			source.add(ele);
		}
		InsertSort(source);
		for (Float ele : source) {
			System.out.println(ele);
		}

	}
	public static void InsertSort(List<Float> list){
		int num=list.size();
		if(num<=0){
			return;
		}
		for(int i=1;i<num;i++){
			int j=i-1;
			float temp=list.get(i);
			while(j>=0&&list.get(j)>temp){   //这里应该将判断大于0放在前面，否则会出错
				list.set(j+1, list.get(j));
				j=j-1;
			}
			list.set(j+1, temp);
		}
	}

}
