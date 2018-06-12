//package test;
//
//import java.awt.Menu;
//import java.util.*;
//
//public class Youdao {
//	
////	public static List<Integer> getLeastStep(int[] bowArr,int a,int b){
////		if(bowArr==null || bowArr.length==0){
////			return 0;
////		}
////		else{
////			int len=bowArr.length;
////			
////		}
////	}
////	private static int getScore(int[] bowArr,int currIdx){
////		int result=0;
////		if(bowArr[currIdx-1]>=0){
////			result+=(bowArr[currIdx-1]+1);
////		}
////		if(bowArr[currIdx]>=0){
////			result+=(bowArr[currIdx]+1);
////		}
////		if(bowArr[currIdx+1]>=0){
////			result+=bowArr[currIdx+1]
////		}
////	}
//	
//	private  static List<List<Integer>> totalPath=new ArrayList<List<Integer>>();
//    public static void minStep(int[] bowArr,List<Integer> list,int first,boolean isMust,int a,int b){
//    	int len=bowArr.length;
//    	for(int i=first;i<len;i++){
//    		if(first==0){
//    			if(bowArr[first]<0){
//    				minStep(bowArr, list, first+1, false,a,b); //必须攻击
//    			}
//    			else{
//    				minStep(bowArr, list, first+1, true,a,b);
//    			}
//    		}
//    		if(first==len-2){
//    			if(bowArr[len-1]<0){
//    				if(bowArr[first]>=0){
//    					list.add(first);
//    					if(first>0){
//    						bowArr[first-1]-=b;
//    					}
//    					bowArr[first]-=a;
//    					bowArr[first+1]-=b;
//    					if(isOk(bowArr)){
//    						List<Integer> list2=new ArrayList<Integer>();
//    						for(int k=0;k<list.size();k++){
//    							list2.add(list.get(k));
//    						}
//    						totalPath.add(list2);
//    						list.remove(list.size()-1);//出栈
//    					}
//    					else{
//    						minStep(bowArr, list, 0, false, a, b);
//    					}
//    					
//    				}
//    				else{
//    					continue;
//    				}
//    			}
//    			else{    //bowArr[len-1]>=0时
//    				list.add(first);
//					if(first>0){
//						bowArr[first-1]-=b;
//					}
//					bowArr[first]-=a;
//					bowArr[first+1]-=b;
//					if(isOk(bowArr)){
//						List<Integer> list2=new ArrayList<Integer>();
//						for(int k=0;k<list.size();k++){
//							list2.add(list.get(k));
//						}
//						totalPath.add(list2);
//						list.remove(list.size()-1);//出栈
//					}
//					else{
//						minStep(bowArr, list, 0, false, a, b);
//					}
//    			}
//    		}
//    		if(first<len-2&& first>0){
//    			if(isMust|| bowArr[first]>=0){
//    				list.add(first);
//					bowArr[first-1]-=b;
//					bowArr[first]-=a;
//					bowArr[first+1]-=b;
//					if(isOk(bowArr)){
//						List<Integer> list2=new ArrayList<Integer>();
//						for(int k=0;k<list.size();k++){
//							list2.add(list.get(k));
//						}
//						totalPath.add(list2);
//						list.remove(list.size()-1); //出栈
//					}
//					else{
//						minStep(bowArr, list, 0, false, a, b);
//					}
//    			}
//    			else{
//    				minStep(bowArr, list, first+1, false, a, b);
//    			}
//    		}
//    		
//    	}
//    }
//    
//    private static boolean isOk(int[] bowArr){
//    	int len=bowArr.length;
//    	boolean result=true;
//    	for(int i=0;i<len;i++){
//    		if(bowArr[i]>=0){
//    			result=false;
//    			break;
//    		}
//    	}
//    	return result;
//    }
//    
//    public static List<List<Integer>> getLeastPath(List<List<Integer>> path){
//    	if(path==null || path.size()==0){
//    		return null;
//    	}
//    	else{
//    		List<List<Integer>> result=new ArrayList<List<Integer>>();
//    		int count=Integer.MAX_VALUE;
//    		for(int i=0;i<path.size();i++){
//    			List<Integer> p=path.get(i);
//    			if(p.size()<count){
//    				count=p.size();
//    			}
//    		}
//    		for(int j=0;j<path.size();j++){
//    			if(path.get(j).size()==count){
//    				result.add(path.get(j));
//    			}
//    		}
//    		return result;
//    	}
//    }
//    
//    public static List<Integer> getBestPath(List<List<Integer>> pathList){
//    	if(pathList==null && pathList.size()==0){
//    		return null;
//    	}
//    	else{
//    		for(int i=0;i<pathList.get(0).size();i++){
//    			int min=pathList.get(0).get(i);
//    			for(int j=1;j<pathList.size();j++){
//    				
//    			}
//    		}
//    	}
//    }
//
//}
