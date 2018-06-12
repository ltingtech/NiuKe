package redblacktree;

import java.util.*;

public class TreeOperation {
	public TreeNode constructTree(List<TreeNode> headList,List<TreeNode> mediumList){
		if(headList==null && mediumList==null)
		{
			return null;
		}
		else {
			TreeNode rootNode=headList.get(0);
			int parIndex=mediumList.indexOf(rootNode);
			List<TreeNode> leftTreeHeadList=null;
			List<TreeNode> leftTreeMediumList=null;
			List<TreeNode> rightTreeHeadList=null;
			List<TreeNode> rightTreeMediumList=null;
			if(parIndex>0){
				leftTreeHeadList=headList.subList(1, parIndex+1);
				leftTreeMediumList=mediumList.subList(0, parIndex);
			}
			if(parIndex<mediumList.size()-1){
				rightTreeHeadList=headList.subList(parIndex+1, headList.size());
				rightTreeMediumList=mediumList.subList(parIndex+1, mediumList.size());
			}
			TreeNode leftNode=constructTree(leftTreeHeadList, leftTreeMediumList);
			rootNode.setLeftNode(leftNode);
			if(leftNode!=null){
				leftNode.setParent(rootNode);
			}
			TreeNode rightNode=constructTree(rightTreeHeadList, rightTreeMediumList);
			rootNode.setRightNode(rightNode);
			if(rightNode!=null){
				rightNode.setParent(rootNode);
			}
			return rootNode;
		}
	}
	
	public List<TreeNode> getBackList(TreeNode rootNode){
		if(rootNode==null)
		{
			return null;
		}
		List<TreeNode> resultList=new ArrayList<>();
		if(getBackList(rootNode.getLeftNode())!=null)
		{
			resultList.addAll(getBackList(rootNode.getLeftNode()));
		}
		if(getBackList(rootNode.getRightNode())!=null){
			resultList.addAll(getBackList(rootNode.getRightNode()));
		}
		resultList.add(rootNode);
		return resultList;
	}
	
	public TreeNode createTree(int[] keyArr){
		if(keyArr==null){
			return null;
		}
		else {
			TreeNode rootNode=new TreeNode(keyArr[0]);
			for(int i=1;i<keyArr.length;i++){
				TreeNode node=rootNode;
				TreeNode newNode=null;
				int key=keyArr[i];
				while(node!=null){
					if(node.getKey()<key){
						if(node.getRightNode()==null)
						{
							newNode=new TreeNode(key);
							node.setRightNode(newNode);
							newNode.setParent(node);
							break;
						}
						else{
							node=node.getRightNode();
							continue;
						}
					}
					if(node.getKey()>key){
						if(node.getLeftNode()==null)
						{
							newNode=new TreeNode(key);
							node.setLeftNode(newNode);
							newNode.setParent(node);
							break;
						}
						else {
							node=node.getLeftNode();
						}
					}	
				}
			}
			return rootNode;
		}
	}
	
	//左旋
	public void leftRotate(TreeNode node){
		TreeNode node2=node.getRightNode();
		if(node2.getLeftNode()!=null)
		{
			node2.getLeftNode().setParent(node);
		}
		node2.setParent(node.getParent());
		node.setRightNode(node2.getLeftNode());
		if(node.getParent()!=null){
			if(node.getParent().getLeftNode()==node){
				node.getParent().setLeftNode(node2);
			}
			else {
				node.getParent().setRightNode(node2);
			}
		}
		node.setParent(node2);
		node2.setLeftNode(node);
		
	}

	//右旋
	public void rightRotate(TreeNode node){
		TreeNode node2=node.getLeftNode();
		if(node2.getRightNode()!=null){
			node2.getRightNode().setParent(node);
		}
		node.setLeftNode(node2.getRightNode());
		node2.setParent(node.getParent());
		if(node.getParent()!=null){
			if(node.getParent().getLeftNode()==node){
				node.getParent().setLeftNode(node2);
			}
			else {
				node.getParent().setRightNode(node2);
			}
		}
		node2.setRightNode(node);
		node.setParent(node2);
	}

	public TreeNode rbInsert(TreeNode rootNode,TreeNode node){
		if(rootNode==null){
			rootNode=node;
		}
		else {
			TreeNode tempNode=rootNode;
			int key=0;
			while(tempNode!=null){
				key=tempNode.getKey();
				if(key>node.getKey()){
					if(tempNode.getLeftNode()==null){
						tempNode.setLeftNode(node);
						node.setParent(tempNode);
						break;
					}
					else {
						tempNode=tempNode.getLeftNode();
						continue;
					}
				}
				if(key<node.getKey()){
					if(tempNode.getRightNode()==null){
						tempNode.setRightNode(node);
						node.setParent(tempNode);
						break;
					}
					else {
						tempNode=tempNode.getRightNode();
						continue;
					}
				}
			}
		}
		node.setColor("red");
		TreeNode newRoot=rbInsertFixup(rootNode, node);
		return newRoot;
	}
	
	public TreeNode rbInsertFixup(TreeNode rootNode,TreeNode node){
		if(node.getParent()==null){  //说明node节点是根节点
			node.setColor("black");
			return node;
		}
		else {  //注意while循环的判断一定要先判断父节点是否存在，然后判断颜色，否则容易报空指针异常
			while(node.getParent()!=null && node.getParent().getColor()=="red"){
				TreeNode gfatherNode=node.getParent().getParent();
				TreeNode fatherNode=node.getParent();
				TreeNode uncleNode=null;
				//左子树情况
				if(fatherNode==gfatherNode.getLeftNode()){
					uncleNode=gfatherNode.getRightNode();
					if(uncleNode!=null && uncleNode.getColor()=="red"){   //叔叔节点为红色
						gfatherNode.setColor("red");
						uncleNode.setColor("black");
						fatherNode.setColor("black");
						node=gfatherNode;  //调节节点位置
						continue;
					}
					else {  //叔叔节点为黑色
						if(node==fatherNode.getRightNode()){
							node=fatherNode;  //调节节点位置
							leftRotate(node);
							gfatherNode=node.getParent().getParent();
							fatherNode=node.getParent();
							gfatherNode.setColor("red");
							fatherNode.setColor("black");
							rightRotate(gfatherNode);
						}
					}
				}
				else{   //右节点
					uncleNode=gfatherNode.getLeftNode();
					if(uncleNode!=null && uncleNode.getColor()=="red")
					{
						gfatherNode.setColor("red");
						fatherNode.setColor("black");
						uncleNode.setColor("black");
						node=gfatherNode;
						continue;
					}
					else {
						if(node==fatherNode.getLeftNode()){
							node=fatherNode;
							rightRotate(node);
							gfatherNode=node.getParent().getParent();
							fatherNode=node.getParent();
							gfatherNode.setColor("red");
							fatherNode.setColor("black");
							leftRotate(gfatherNode);
						}
					}
				}
			}
		}
		while(node.getParent()!=null){  //寻找到重新着色后的根节点
			node=node.getParent();
		}
		node.setColor("black");
		return node;
	}
	
	//二叉搜索树删除节点
	public void removeNode(TreeNode rootNode,TreeNode node){
		if(rootNode==null){return ;}
		else { 
			TreeNode parent=null;
			//若即无左节点，也无右节点
			if(node.getLeftNode()==null && node.getRightNode()==null)
			{
				parent=node.getParent();
				node.setParent(null);
				if(parent.getLeftNode()==node){
					parent.setLeftNode(null);
				}
				else {
					parent.setRightNode(null);
				}
			}
			else {  //左节点和右节点有一个为空
				if(node.getLeftNode()==null || node.getRightNode()==null){
					parent=node.getParent();
					node.setParent(null);
					if(parent.getLeftNode()==node){
						if(node.getLeftNode()!=null){
							parent.setLeftNode(node.getLeftNode());
							node.getLeftNode().setParent(parent);
							node.setLeftNode(null);
						}
						else {
							parent.setLeftNode(node.getRightNode());
							node.getRightNode().setParent(parent);
							node.setRightNode(null);
						}
					}
					else {
						if(node.getLeftNode()!=null){
							parent.setRightNode(node.getLeftNode());
							node.getLeftNode().setParent(parent);
							node.setLeftNode(null);
						}
						else {
							parent.setRightNode(node.getRightNode());
							node.getRightNode().setParent(parent);
							node.setRightNode(null);
						}
					}
				}
				else {  //左右子树都不为空
					parent=node.getParent();
					TreeNode rightMinNode=node.getLeftNode();
					while(rightMinNode.getLeftNode()!=null){
						rightMinNode=rightMinNode.getLeftNode();
					}
					node.setKey(rightMinNode.getKey());
					removeNode(rootNode, rightMinNode);				
				}
			}
			return;
		}
		
	}

}
