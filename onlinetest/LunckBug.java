package onlinetest;

import java.util.*;


public class LunckBug {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		while(in.hasNext()){
			int num=in.nextInt();
			List<Integer> numList=new ArrayList<Integer>();
			for(int i=0;i<num;i++){
				numList.add(in.nextInt());
			}
			int result=luckCount(numList);
			System.out.println(result);
		}
		in.close();

	}
	
	public static int luckCount(List<Integer> numList){
		int result=0;
		if(numList!=null && numList.size()>1){
//			Collections.sort(numList);
//			if(isLuck(numList)){
//				result++;
//			}
//			List<Integer> temp=new ArrayList<Integer>();
//			for(int k=0;k<numList.size();k++){
//				temp.add(numList.get(k));
//			}
//			int t=0;
//			for(int i=temp.size()-1;i>0;i--){
//				if(temp.get(i)==t){
//					continue;
//				}
//				else{
//					t=temp.get(i);
//					temp.remove(i);
//					result+=luckCount(temp);
//					temp.clear();
//					for(int m=0;m<numList.size();m++){
//						temp.add(numList.get(m));
//					}
//				}
//			}
			Collections.sort(numList);
			int i=0;
			boolean isFirst=true;
			while(i<numList.size()){
				if(numList.get(i)>1){
					break;
				}
				else{
					if(isFirst)
					{
						for(int j=i+1;j<numList.size();j++){
							if(isLuck(numList, i, j)){
								result++;
							}
							else{
								break;
							}
						}
						isFirst=false;
					}
					else{
						int j=i+1;
						while(j<numList.size()&& numList.get(j)<=1){
							j++;
						}
						for(;j<numList.size();j++){
							if(isLuck(numList, i, j)){
								result++;
							}
							else{
								break;
							}
						}
					}

				}
				i++;
			}

		}
		return result;
	}
	
	private static boolean isLuck(List<Integer> numList,int first,int end){
		boolean luck=false;
		if(numList!=null&& numList.size()>0){
			int sum=0;
			int mult=1;
			for(int i=first;i<=end;i++){
				sum+=numList.get(i);
				mult*=numList.get(i);
			}
			if(sum>mult){
				luck=true;
			}
		}
		return luck;
	}

}
