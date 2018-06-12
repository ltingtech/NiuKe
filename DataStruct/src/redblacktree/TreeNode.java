package redblacktree;

public class TreeNode {
	private int key;
	private TreeNode leftNode;
	private TreeNode rightNode;
	private TreeNode parent;
	private String color;

	public TreeNode(){
	}
	public TreeNode(int key){
		this.key=key;
	}
	public TreeNode(int key,String color){
		this.key=key;
		this.color=color;
	}
	public int getKey(){
		return key;
	}
	public void setKey(int key){
		this.key=key;
	}
	public TreeNode getLeftNode(){
		return leftNode;
	}
	public void setLeftNode(TreeNode node){
		this.leftNode=node;
	}
	public TreeNode getRightNode(){
		return rightNode;
	}
	public void setRightNode(TreeNode node){
		this.rightNode=node;
	}
	public TreeNode getParent(){
		return parent;
	}
	public void setParent(TreeNode parent){
		this.parent=parent;
	}
	public String getColor(){
		return color;
	}
	public void setColor(String color){
		this.color=color;
	}
	
	public boolean equals(TreeNode node){
		if(node==this){
			return true;
		}
		if(node==null){
			return false;
		}
		if(node.getKey()==this.key){
			return true;
		}
		else {
			return false;
		}
	}
	public int hashCode(){
		return 1000;
	}

}
