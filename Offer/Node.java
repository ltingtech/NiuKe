package Offer;
public class Node<T> {
	private T value;
	private Node<T> leftChild;
	private Node<T> rightChild;
	
	public T getValue(){
		return value;
	}
	public void setValue(T value){
		this.value=value;
	}
	public Node<T> getLeft(){
		return leftChild;
	}
	public void setLeft(Node<T> left){
		leftChild=left;
	}
	public Node<T> getRight(){
		return rightChild;
	}
	public void setRight(Node<T> right){
		rightChild=right;
	}
	public Node(T value)
	{
		this.value=value;
	}

}
