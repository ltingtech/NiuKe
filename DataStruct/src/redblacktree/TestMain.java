package redblacktree;

import java.util.*;

public class TestMain {

	public static void main(String[] args) {
		TreeOperation operation=new TreeOperation();
		int[] keyArr=new int[]{45,24,56,35,25,67,43,27,49};
		TreeNode node1=new TreeNode(45);
		TreeNode node2=new TreeNode(32);
		TreeNode node3=new TreeNode(23);
		TreeNode node4=new TreeNode(34);
		TreeNode node5=new TreeNode(56);
		TreeNode node6=new TreeNode(51);
		TreeNode node7=new TreeNode(67);
		
		List<TreeNode> headList=Arrays.asList(node1,node2,node3,
				node4,node5,node6,node7);
		List<TreeNode> mediumList=Arrays.asList(node3,node2,node4,
				node1,node6,node5,node7);
		TreeNode rootNode=operation.constructTree(headList, mediumList);
//		TreeNode rootNode=operation.createTree(keyArr);
		List<TreeNode> backList=operation.getBackList(rootNode);
		for (TreeNode node : backList) {
			System.out.println(node.getKey());
		}
		System.out.println("**********************");
		operation.removeNode(rootNode, node5);
		backList=operation.getBackList(rootNode);
		for (TreeNode node : backList) {
			System.out.println(node.getKey());
		}
		
//		System.out.println("*************************");
//		operation.leftRotate(node5);
//		operation.rightRotate(rootNode.getLeftNode().getRightNode());
//		backList=operation.getBackList(rootNode);
//		for (TreeNode node : backList) {
//			System.out.println(node.getKey());
//		}
//		TreeNode root=null;
//		for(int i=0;i<9;i++){
//			TreeNode node=new TreeNode(keyArr[i]);
//			root=operation.rbInsert(root, node);
//		}
//		List<TreeNode> backList=operation.getBackList(root);
//		for (TreeNode node : backList) {
//			System.out.println(node.getKey()+ " "+node.getColor());
//		}

	}

}
