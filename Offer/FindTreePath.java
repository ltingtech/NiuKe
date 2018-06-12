package Offer;

import java.util.*;

public class FindTreePath {

	public static void main(String[] args) {
		Node<Double> node1=new Node<Double>(7.0);
		Node<Double> node2=new Node<Double>(2.0);
		Node<Double> node3=new Node<Double>(8.0);
		Node<Double> node4=new Node<Double>(5.0);
		Node<Double> node5=new Node<Double>(6.0);
		node1.setLeft(node2);
		node1.setRight(node3);
		node2.setLeft(node4);
		node2.setRight(node5);
		Stack<Double> stack=new Stack<Double>();
		findPath(node1, stack, 0, 15);

	}
	//基本类型不可以泛型化
	public static void findPath(Node<Double> root,Stack<Double> stack,double currSum,double total)
	{
		if(root==null)
		{
			return;
		}
		else {
			stack.push(root.getValue());
			double num=currSum;
			num+=root.getValue();
			if(root.getLeft()==null && root.getRight()==null)
			{
				if(num==total)
				{
					for(Iterator iterator=stack.iterator();iterator.hasNext();)
					{
						Double eleDouble=(Double)iterator.next();
						System.out.println(eleDouble);
					}
					System.out.println("*******************");
				}
				stack.pop();//不管当前root满不满足要求，都要出栈
			}
			else {
				if(root.getLeft()!=null)
				{
					findPath(root.getLeft(), stack, num,total);
				}
				if(root.getRight()!=null)
				{
					findPath(root.getRight(), stack,num, total);
				}
				stack.pop();//遍历完左右子树后，记得把根节点出栈；
			}
			return;
		}
		
	}

}
