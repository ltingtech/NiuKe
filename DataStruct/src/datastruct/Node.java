package datastruct;

public class Node{
	private String content;
	private Node leftNode;
	private Node rightNode;
	private boolean isVisited=false;
	public Node(){}
	public Node(String content,Node leftNode,Node rightNode){
		this.content=content;
		this.leftNode=leftNode;
		this.rightNode=rightNode;
	}
	public String getContent(){
		return content;
	}
	public void setContent(String content){
		this.content=content;
	}
	public Node getLeftNode(){
		return leftNode;
	}
	public void setleftNode(Node node){
		this.leftNode=node;
	}
	public Node getRightNode(){
		return rightNode;
	}
	public void setRightNode(Node node){
		this.rightNode=node;
	}
	public boolean getIsVisited(){
		return isVisited;
	}
	public void setIsVisited(boolean isVisited){
		this.isVisited=isVisited;
	}
	public boolean equals(Node node){
		if(this==node){
			return true;
		}
		if(node==null|| this==null){
			return false;
		}
		if((content==node.getContent()) && (this.leftNode== node.getLeftNode()) && (this.rightNode==node.getRightNode())){
			return true;
		}
		else {
			return false;
		}
		
	}
	public int hashCode(){
		return 10000;
	}
}
