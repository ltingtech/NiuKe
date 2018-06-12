package onlinetest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		
		int priceNum=0;
		int goodNum=0;
		boolean flag=true;
		while(in.hasNext())
		{
			if(flag){
				priceNum=in.nextInt();
				goodNum=in.nextInt();
			}
			List<Integer> result=new ArrayList<Integer>();
			List<Integer> priceList=new ArrayList<Integer>();
			for(int ii=1;ii<=priceNum;ii++){
				priceList.add(in.nextInt());
			}
			String good="";
			HashMap<String, Integer> goodCountMap=new HashMap<String, Integer>();
			in.nextLine();
			for(int i=1;i<=goodNum;i++){
				
				good=in.nextLine().toString();
				if(goodCountMap.containsKey(good)){
					goodCountMap.put(good, goodCountMap.get(good)+1);
				}
				else{
					goodCountMap.put(good, 1);
				}
			}
			List<Integer> countList=new ArrayList<Integer>();
			for (String keyString : goodCountMap.keySet()) {
				countList.add(goodCountMap.get(keyString));
			}
			Object[] priceArr=priceList.toArray();
			Object[] countArr=countList.toArray();
			mount(priceArr, countArr);
			result.add(minMount);
			result.add(maxMount);
			minMount=0;
			maxMount=0;
//			if(in.hasNextLine()){
//				String l=in.nextLine();
//				if(l.isEmpty()){
//					break;
//				}
//				else{
//					priceNum=Integer.parseInt(l.split(" ")[0]);
//					goodNum=Integer.parseInt(l.split(" ")[1]);
//					flag=false;
//				}
//			}
//			else{
//				break;
//			}
			for(int i=0;i<result.size();i++){
				System.out.println(result.get(i+1)+" "+result.get(i));
				i++;
			}
//			
			
		}
		
			

	}
	private static int maxMount=0;
	private static int minMount=0;
	public static void mount(Object[] priceArr, Object [] countArr){
		if(priceArr!=null && priceArr.length>0 && countArr!=null && countArr.length>0){
			Arrays.sort(priceArr);
			Arrays.sort(countArr);//小的在前
			int j=0;
			for(int i=countArr.length-1;i>=0;i--){
				maxMount+=((Integer)priceArr[j]*(Integer)countArr[i]);
				j++;
			}
			int m=priceArr.length-1;
			for(int k=countArr.length-1;k>=0;k--){
				minMount+=((Integer)priceArr[m]*(Integer)countArr[k]);
				m--;
			}
			
		}
	}

}
