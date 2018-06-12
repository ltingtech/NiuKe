package datastruct;

public class Node2  {
	private Node2 parent;
	private String content;
	private Node2 leftNode;
	private Node2 rightNode;
	public Node2 getParent(){
		return parent;
	}
	public void setParent(Node2 node){
		this.parent=node ;
	}

	public Node2(){}
	

	public String getContent(){
		return content;
	}
	public void setContent(String content){
		this.content=content;
	}
	public Node2 getLeftNode(){
		return leftNode;
	}
	public void setleftNode(Node2 node){
		this.leftNode=node;
	}
	public Node2 getRightNode(){
		return rightNode;
	}
	public void setRightNode(Node2 node){
		this.rightNode=node;
	}
	public boolean equals(Node2 node){
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
