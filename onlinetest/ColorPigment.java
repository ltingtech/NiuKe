package onlinetest;

import java.util.*;


public class ColorPigment {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		while(in.hasNext()){
			int n=in.nextInt();
			List<Integer> colorList=new ArrayList<Integer>();
			for(int i=0;i<n;i++){
				colorList.add(in.nextInt());
			}
			int result=colorPigment(colorList);
			System.out.println(result);
		}

	}
//	public static int colorPigment(List<Integer> colorList){
//		int result=0;
//		if(colorList!=null && colorList.size()>0){
//			HashMap<Integer, Integer> temp=new HashMap<Integer, Integer>();
//			//得到中间颜色
//			for(int i=0;i<colorList.size()-1;i++){
//				for(int j=i+1;j<colorList.size();j++){
//					int t=colorList.get(i)^colorList.get(j);
//					if(temp.containsKey(t)){
//						temp.put(t, temp.get(t)+1);
//					}
//					else{
//						temp.put(t, 1);
//					}
//				}
//			}
//			//中间颜色
//			List<Integer> tempList=new ArrayList<Integer>();
//			for (Integer key : temp.keySet()) {
//				if(temp.get(key)>1){
//					tempList.add(key);
//				}
//			}
//			//最终需要的颜色
//			List<Integer> color=new ArrayList<Integer>();
//			for(int k=0;k<tempList.size();k++){
//				color.add(tempList.get(k));
//			}
//			for(int i=0;i<colorList.size();i++){
//				for(int j=0;j<tempList.size();j++){
//					int mixCol=colorList.get(i)^tempList.get(j);
//					if(colorList.contains(mixCol)){
//						colorList.remove(new Integer(mixCol));
//					}
//				}
//				color.add(colorList.get(i));
//			}
//			result=color.size();
//			
//		}
//		return result;
//	}
	
	public static int colorPigment(List<Integer> colorList){
		int result=0;
		if(colorList!=null && colorList.size()>0){
			int len=colorList.size();
			if(len<=2){
				result=len;
			}
			else{
				Collections.sort(colorList);
				while(colorList.size()>2){
					int end=colorList.size()-1;
					int endPre=end-1;
					if(maxHighOf1(colorList.get(end))==maxHighOf1(colorList.get(endPre))){
						int temp=colorList.get(end)^colorList.get(endPre);
						if(!colorList.contains(temp)){
							colorList.add(temp);
							end++;
							endPre++;
							Collections.sort(colorList);
						}
						
					}
					else{
						result++;
					}
					colorList.remove(colorList.size()-1);
					end--;
					endPre--;
				}
				result+=2;
			}
		}
		return result;
	}
	private static int maxHighOf1(int n ){
		int result=0;
		while(n>0){
			n=n>>1;
			result++;
		}
		return result;
	}
}
