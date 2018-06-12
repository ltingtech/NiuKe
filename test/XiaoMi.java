package test;

import java.util.HashMap;
import java.util.Scanner;



public class XiaoMi {
	public static void main(String[] args){
		Scanner reader=new Scanner(System.in);
		while(reader.hasNext()){
			int n=reader.nextInt();
			HashMap<Integer, Node> map=new HashMap<Integer, Node>();
			for(int i=0;i<n-1;i++){
				Node node=new Node();
				map.put(i, node);
			}
			for(int i=0;i<n-1;i++){
				Node node=new Node();
				int root=reader.nextInt();
				Node node2=map.get(root);
				int ele=reader.nextInt();
				if(node2.left==Integer.MAX_VALUE){
					node2.left=ele;
				}
				else{
					if(node2.right==Integer.MAX_VALUE){
						node2.right=ele;
					}
				}
				i++;
			}
			for(int i=0;i<n;i++){
				if(!map.containsKey(i)){
					Node node=new Node();
					map.put(i, node);
				}
			}
			int result=getDepth(map, n);
			System.out.println(result);
		}
	}
	
	public static int getDepth(HashMap<Integer, Node> map,int n){
		for(int i=0;i<n;i++){
			Node node=map.get(i);
			if(isLeaf(node)){
				node.isVisited=true;
				node.depth=1;
			}
		}
		boolean isAllVisited=false;
		int result=0;
		while(!isAllVisited)
		{
			for(int i=0;i<n;i++){
				Node node=map.get(i);
				if(!node.isVisited){
					if(node.left==Integer.MAX_VALUE|| node.right==Integer.MAX_VALUE){  //有一一个孩子是空
						node.isVisited=true;
						if(node.left!=Integer.MAX_VALUE){
							Node l=map.get(node.left);
							node.depth=l.depth+1;
							if(node.depth>result){
								result=node.depth;
							}
						}
						if(node.right!=Integer.MAX_VALUE){
							Node r=map.get(node.left);
							node.depth=r.depth+1;
							if(node.depth>result){
								result=node.depth;
							}
						}
					}
					else{
						node.isVisited=true;
						Node l=map.get(node.left);
						Node r=map.get(node.right);
						if(l.depth==-1&& r.depth==-1){
							continue;
						}
						else{
							node.depth=Math.max(l.depth, r.depth)+1;
							if(node.depth>result){
								result=node.depth;
							}
						}
					}
					
				}
				else{
					continue;
				}
			}
			isAllVisited=true;
			for(int i=0;i<n;i++){
				Node node=map.get(i);
				if(node.isVisited=false){
					isAllVisited=false;
					break;
				}
			}
		}
		return result;
		
	}
	private static boolean isLeaf(Node node){
		return node.left==Integer.MAX_VALUE&& node.right==Integer.MAX_VALUE;
	}

}
class Node{
	public int left=Integer.MAX_VALUE;
	public int right=Integer.MAX_VALUE;
	public int depth=-1;
	public boolean isVisited=false;
}
