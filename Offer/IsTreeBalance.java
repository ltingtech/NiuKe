package Offer;

public class IsTreeBalance {

	public static void main(String[] args) {
		Node<Double> node1=new Node<Double>(7.0);
		Node<Double> node2=new Node<Double>(2.0);
		Node<Double> node3=new Node<Double>(8.0);
		Node<Double> node4=new Node<Double>(5.0);
		Node<Double> node5=new Node<Double>(6.0);
//		node1.setLeft(node2);
//		node1.setRight(node3);
//		node2.setLeft(node4);
//		node4.setRight(node5);
//		boolean result=isBalance(null);
//		System.out.println(result);
		System.out.println((-2)%5);

	}
	private static int depth;   //定义一个静态全局变量
	public static boolean isBalance(Node<Double> root)
	{
		int left=0,right=0;
		if(root==null)
		{
			depth=0;
			return true;
		}
		else {
			if(isBalance(root.getLeft())){
				left=depth;
			}
			else {
				return false;
			}
			if(isBalance(root.getRight())){
				right=depth;
			}
			else {
				return false;
			}
			if(left-right>1 || right-left>1)
			{
				return false;
			}
			else {
				depth=left>right?left+1:right+1;
				return true;
			}
		}
		
	}

}
