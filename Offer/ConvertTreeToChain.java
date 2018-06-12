package Offer;

public class ConvertTreeToChain {
	private static Node<Double> lastNode=null;
	public static void main(String[] args) {
		Node<Double> node1=new Node<Double>(10.0);
		Node<Double> node2=new Node<Double>(6.0);
		Node<Double> node3=new Node<Double>(14.0);
		Node<Double> node4=new Node<Double>(4.0);
		Node<Double> node5=new Node<Double>(18.0);
		node1.setLeft(node2);
		node1.setRight(node3);
		node2.setLeft(node4);
		node3.setRight(node5);
//		Node<Double> lastNode=null;
		Node<Double> head=convert(node1);
		while(head!=null ){
			System.out.println(head.getValue());
			head=head.getRight();
		}

	}
	
	public static Node<Double> convert(Node<Double> root){
		convertNode(root);
		Node<Double> headNode=lastNode;
		while(headNode!=null&& headNode.getLeft()!=null)
		{
			headNode=headNode.getLeft();
		}
		return headNode;
	}
	
	public static void convertNode(Node<Double> node){
		if(node==null){
			return;
		}
		else {
			Node<Double> currentNode=node;
			if(node.getLeft()!=null)
			{
				convertNode(node.getLeft());
			}
			currentNode.setLeft(lastNode);  //建立当前节点和前面的节点之间的联系
			if(lastNode!=null)
			{
				lastNode.setRight(currentNode);
			}                               //建立当前节点和前面的节点之间的联系
			lastNode=node;
			if(node.getRight()!=null)
			{
				convertNode(node.getRight());
			}
		}
	}

}
