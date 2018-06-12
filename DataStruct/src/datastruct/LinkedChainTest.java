package datastruct;

import java.util.Stack;

public class LinkedChainTest {
	public static void main(String[] args) {
//		double[] keyList=new double[]{2.3,4,6.7,2.1,3.6,6.3,4.5};
//		LinkedChainTest test=new LinkedChainTest();
//		ChainNode root=test.createChain(keyList);
//		test.insertToChain(root, 10.8);
//		test.printChainInversely2(root);
//		ChainNode node=test.findeKthToTail(root, 1);
//		if(node!=null){
//			System.out.println(node.getKey());
//		}
//		else {
//			System.out.println("it is null");
//		}
		Integer.valueOf(4);
		ChainNode node1=new ChainNode();
		node1.setKey(2.7);
		ChainNode node2=new ChainNode();
		node2.setKey(4.7);
		ChainNode node3=new ChainNode();
		node3.setKey(6.8);
		node1.setNextNode(node2);
		node2.setNextNode(node3);
		node3=null;
		if(node2.getNextNode()==null)
		{
			System.out.println("true");
		}
		else {
			System.out.println("false");
			System.out.println(node2.getNextNode().getKey());
		}

	}

	public ChainNode findeKthToTail(ChainNode head,int k){
		if(head==null||k<=0){return null;}   //链表为空
		else {
			ChainNode behinedNode =head;
			for(int i=0;i<k-1;i++){
				if(behinedNode.getNextNode()!=null){
					behinedNode=behinedNode.getNextNode();
				}
				else {
					return null;  //链表长度小于k值
				}
			}
			while(behinedNode.getNextNode()!=null){
				head=head.getNextNode();
				behinedNode=behinedNode.getNextNode();
			}
			return head;  //返回值
		}
	}
	
	public ChainNode createChain(double[] keyList){
		if(keyList.length==0){return null;}
		else {
			ChainNode root=new ChainNode();
			root.setKey(keyList[0]);
			ChainNode lastNode=root;
			for(int i=1;i<keyList.length;i++){
				ChainNode newNode=new ChainNode();
				newNode.setKey(keyList[i]);
				lastNode.setNextNode(newNode);
				lastNode=newNode;
			}
			return root;
		}
	}
	public void insertToChain(ChainNode head,double value){
		if(head==null){
			head=new ChainNode();
			head.setKey(value);
			return;
		}
		else {
			while(head.getNextNode()!=null){
				head=head.getNextNode();
			}
			ChainNode newNode=new ChainNode();
			newNode.setKey(value);
			head.setNextNode(newNode);
			return ;
		}
	}

	//利用栈结构反向打印
	public void printChainInversely(ChainNode head){
		if(head==null){
			System.out.println("this chain is empty");
			return;
		}
		else {
			Stack<Double> stack=new Stack<>();
			while(head!=null)
			{
				stack.push(head.getKey());
				head=head.getNextNode();
			}
			while(!stack.isEmpty()){
				System.out.println(stack.pop());
			}
		}
	}
	
	//利用递归反向打印
	public void printChainInversely2(ChainNode head){
		if(head==null)
		{
			System.out.println("this chain is empty");
		}
		else {
			if(head.getNextNode()==null){
				System.out.println(head.getKey());
			}
			else {
				printChainInversely2(head.getNextNode());
				System.out.println(head.getKey());
			}
		}
	}
}

class ChainNode{
	private double key;
	private ChainNode nextNode;
	public ChainNode(){}
	public ChainNode(double key){
		this.key=key;
	}
	public double getKey(){
		return key;
	}
	public void setKey(double key){
		this.key=key;
	}
	public ChainNode getNextNode(){
		return nextNode;
	}
	public void setNextNode(ChainNode node){
		this.nextNode=node;
	}
}
