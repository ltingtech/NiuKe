package avltree;

public class AVLNode {
	private double key;
	private int bf;
	private AVLNode leftNode;
	private AVLNode rightNode;
	private AVLNode parent;
	public AVLNode(){}
	public AVLNode(double key){
		this.key=key;
	}
	
	public double getKey(){
		return key;
	}
	public void setKey(double key){
		this.key=key;
	}
	public int getBf(){
		return bf;
	}
	public void setBf(int bf){
		this.bf=bf;
	}
	public AVLNode getLeftNode(){
		return leftNode;
	}
	public void setLeftNode(AVLNode node){
		this.leftNode=node;
	}
	public AVLNode getRightNode(){
		return rightNode;
	}
	public void setRightNode(AVLNode node){
		this.rightNode=node;
	}
	public AVLNode getParent(){
		return parent;
	}
	public void setParent(AVLNode parent){
		this.parent=parent;
	}

}
