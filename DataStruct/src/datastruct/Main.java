package datastruct;

import java.util.*;


public class Main {

	public static void main(String[] args) {
		double[] data=new double[]{0,14.4,24.4,6.6,23.4,89.4,24.4,245.3,78.4,353.5,456.8,5.8};
//		double[] data=new double[]{3.3,1.4,0.6};
//		int len=data.length;
//		SortUtil.insertSort2(data);
//		SortUtil.shellSort2(data);
//		SortUtil.bubbleSort(data);
//		SortUtil.quickSort(data, 0, 11);
//		double[] temp=new double[len];
//		double[] a_data=new double[len];
//		SortUtil.mergeSort(data, a_data, 0, len-1);
		int len=data.length;
		double[] copy=new double[len];
		for(int i=0;i<len;i++){
			copy[i]=data[i];
		}
//		SortUtil.mergeSort2(copy, data, 0, len-1);
		SortUtil.bubbleSort3(data);
		
//		SortUtil.heapSort(data);
//		SortUtil2.insertSort(data);
//		SortUtil2.shellSort(data);
//		SortUtil2.bubbleSort(data);
//		SortUtil2.quickSort(data, 0, data.length-1);
//		SortUtil2.heapSort(data);
//		double[] a_data=new double[data.length];
//		SortUtil2.mergeSort(data, a_data, 0, data.length-1);
//		SortUtil3.insertSort(data);
//		SortUtil3.shellSort(data);
//		SortUtil3.bubbleSort(data);
//		SortUtil3.quickSort(data, 0, data.length-1);
//		double[] a_data=new double[data.length];
//		SortUtil3.mergeSort(data, a_data, 0, data.length-1);
//		SortUtil3.heapSort(data);
		for(int i=0;i<data.length;i++)
		{
			System.out.println(data[i]);
		}
//		for(int i=0;i<a_data.length;i++){
//			System.out.println(a_data[i]);
//		}
//		
		/*************二叉树**********************/
//		TreeOperation operation=new TreeOperation();
//		List<String> mediumList=Arrays.asList("D","B","E","A","F","C","G");
//		List<String> backList=Arrays.asList("D","E","B","F","G","C","A");
//		Node rootNode=operation.constructTree(mediumList, backList);
//		
//		List<String> mediumList2=Arrays.asList("D","B","E");
//		List<String> backList2=Arrays.asList("D","E","B");
//		Node rootNode2=operation.constructTree(mediumList2, backList2);
//		boolean flag=operation.hashSubTree(rootNode,rootNode2);
//		System.out.println(flag);
//		List<String> headList=operation.searchHeadList2(rootNode);
//		List<String> mediumList3=operation.searchMediumList3(rootNode);
//		System.out.println(mediumList3.toString());
//		List<String> backList3=operation.searchBackList3(rootNode);
//		System.out.println(backList3.toString());
//		List<String> bfsList=operation.searchBFS(rootNode);
//		List<String> dfsList=operation.searchDFS(rootNode);
//		System.out.println(bfsList.toString());
//		System.out.println("***************************");
//		Node2 node2=operation.getNextInMedium(rootNode.getLeftNode().getRightNode()) ;
//		System.out.println(node2.getContent());
//		operation.inverseTree(rootNode);
//		bfsList=operation.searchBFS(rootNode);
//		System.out.println(bfsList.toString());
//		System.out.println("***************************");
//		System.out.println(dfsList.toString());
//		System.out.println("***************************");
//		List<String> headList=operation.searchHeadList(rootNode);
//		System.out.println(headList.toString());
		
//		Node2 node1=rootNode.getRightNode().getRightNode();
//		Node2 node2=rootNode.getLeftNode().getLeftNode();
//		Node2 sameParent=operation.searchSameParent(node1, node2);
//		System.out.println(sameParent.getContent());
		
	}

}
