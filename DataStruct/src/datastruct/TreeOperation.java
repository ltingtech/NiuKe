package datastruct;

import java.util.*;


public class TreeOperation {
	
	/*根据中序序列和后序序列求前序序列
	 * 
	 */
	public Node constructTree(List<String> mediumList,List<String> backList){
		if(mediumList==null && backList==null){return null;}
		int len=backList.size();
		String rootContent=backList.get(len-1);
		int partIndex=mediumList.indexOf(rootContent);
		List<String> leftTreeMediumList=null;  //先初始化为Null,若不满足下面的条件，它集会传null值给递归函数
		List<String> rightTreeMediumList=null;
		List<String> leftTreeBackList=null;
		List<String> rightTreeBackList=null;
		if(partIndex>0)
		{
			leftTreeMediumList=mediumList.subList(0, partIndex); //第二个参数的索引本来就不包括在子序列中
			leftTreeBackList=backList.subList(0, partIndex);
		}
		if(partIndex<len-1)
		{
			rightTreeMediumList=mediumList.subList(partIndex+1, len);
			rightTreeBackList=backList.subList(partIndex, len-1);
		}
		Node root=new Node();
		root.setContent(rootContent);
		root.setleftNode(constructTree(leftTreeMediumList, leftTreeBackList));
		root.setRightNode(constructTree(rightTreeMediumList, rightTreeBackList));
		return root;
	}
	//树的广度优先
	public List<String> searchBFS(Node root)
	{
		if(root==null){return null;}
		List<String> result=new ArrayList<>();
		Queue<Node> nodeQueue =new LinkedList<>();
		nodeQueue.add(root);
		Node currentNode=new Node();
		while(!nodeQueue.isEmpty())
		{
			currentNode=nodeQueue.poll();  //取出队列头元素
			result.add(currentNode.getContent());
			if(currentNode.getLeftNode()!=null){
				nodeQueue.add(currentNode.getLeftNode());  //添加元素
			}
			if(currentNode.getRightNode()!=null){
				nodeQueue.add(currentNode.getRightNode());
			}
		}
		return result;
	}
	//树的深度优先
	public List<String> searchDFS(Node root){
		if(root==null){return null;}
		else {
			List<String> result=new ArrayList<>();
			Stack<Node> stack=new Stack<Node>();
			stack.push(root);
			Node currentNode=new Node();
			while(!stack.isEmpty()){
				currentNode=stack.pop();
				result.add(currentNode.getContent());
				if(currentNode.getRightNode()!=null)   //入栈顺序应该是先右子树再左子树
				{
					stack.push(currentNode.getRightNode());
				}
				if(currentNode.getLeftNode()!=null)
				{
					stack.push(currentNode.getLeftNode());
				}
			}
			return result;
		}
	}
	//树的前序序列
	public List<String> searchHeadList(Node root){
		if(root==null){return null;}
		else {
			List<String> result=new ArrayList<>();
			result.add(root.getContent());
			//必须记得先判断是否是空的
			if(searchHeadList(root.getLeftNode())!=null)
			{
				result.addAll(searchHeadList(root.getLeftNode()));
			}
			if(searchHeadList(root.getRightNode())!=null)
			{
				result.addAll(searchHeadList(root.getRightNode()));
			}
			return result;
		}
		
		
	}
	
	//树的前序序列，不用递归方法
	public List<String> searchHeadList2(Node root){
		if(root==null){return null;}
		else {
			List<String> result=new ArrayList<>();
			result.add(root.getContent());
			Stack<Node> nodeStack=new Stack<>();
			if(root.getRightNode()!=null){
				nodeStack.push(root.getRightNode());
			}
			if(root.getLeftNode()!=null){
				nodeStack.push(root.getLeftNode());
			}
			Node node=null;
			while(!nodeStack.isEmpty()){
				node=nodeStack.pop();
				result.add(node.getContent());
				if(node.getRightNode()!=null){
					nodeStack.push(node.getRightNode());
				}
				if(node.getLeftNode()!=null){
					nodeStack.push(node.getLeftNode());
				}
			}
			return result;
		}
	}

	//树的中序遍历
	public List<String> searchMediumList(Node root){
		if(root==null){
			return null;
		}
		else {
			List<String> result=new ArrayList<>();
			if(root.getLeftNode()!=null){
				result.addAll(searchMediumList(root.getLeftNode()));
			}
			result.add(root.getContent());
			if(root.getRightNode()!=null){
				result.addAll(searchMediumList(root.getRightNode()));
			}
			return result;
		}
	}

	//树的中序遍历，不使用递归，改变了数据结构，不建议使用
	public List<String> searchMediumList2(Node root){
		if(root==null){
			return null;
		}
		else {
			List<String> result=new ArrayList<>();
			Stack<Node> stack=new Stack<>();
			stack.push(root);
			while(!stack.isEmpty()){
				Node node=stack.pop();
				if(node.getRightNode()==null && node.getLeftNode()==null){
					node.setIsVisited(true);
					result.add(node.getContent());
				}
				else {
					if(!node.getIsVisited())
					{
						node.setIsVisited(true);
						if(node.getRightNode()!=null){
							stack.push(node.getRightNode());
						}
						stack.push(node);
						if(node.getLeftNode()!=null){
							stack.push(node.getLeftNode());
						}
					}  //若还没有被访问
					else {
						result.add(node.getContent());
					}
					
				}
			}
			return result;
		}
	}
	
	//不使用递归的中序遍历
	public List<String> searchMediumList3(Node root){
		if(root==null){return null;}
		else {
			List<String> result=new ArrayList<>();
			Node p=root;
			Stack<Node> stack=new Stack<>();
			while(p!=null || !stack.isEmpty()){
				while(p!=null){
					stack.push(p);
					p=p.getLeftNode();
				}
				if(!stack.isEmpty()){
					Node current=stack.pop();
					p=current.getRightNode();
					result.add(current.getContent());
				}
			}
			return result;
		}
	}
	
	//树的后序遍历
	public List<String> searchBackList(Node root){
		if(root==null){return null;}
		else {
			List<String> result=new ArrayList<>();
			if(root.getLeftNode()!=null){
				result.addAll(searchBackList(root.getLeftNode()));
			}
			if(root.getRightNode()!=null){
				result.addAll(searchBackList(root.getRightNode()));
			}
			result.add(root.getContent());
			return result;
		}
		
	}

	//树的后序遍历，不用递归,改变了数据结构，不建议使用
	public List<String> searchBackList2(Node root){
		if(root==null){return null;}
		else {
			List<String> result=new ArrayList<>();
			Stack<Node> nodeStack=new Stack<>();
			nodeStack.push(root);
			Node node=null;
			while(!nodeStack.isEmpty()){
				node=nodeStack.pop();
				if((node.getIsVisited()) || (node.getRightNode()==null && node.getLeftNode()==null))
				{
					result.add(node.getContent());
				}
				else {
					node.setIsVisited(true);
					nodeStack.push(node);
					if(node.getRightNode()!=null){
						nodeStack.push(node.getRightNode());
					}
					if(node.getLeftNode()!=null){
						nodeStack.push(node.getLeftNode());
					}
				}
				
			}
			return result;
		}
	}
	
	//不适用递归的后序遍历
	public List<String> searchBackList3(Node root){
		if(root==null){return null;}
		else {
			List<String> result=new ArrayList<>();
			Node curr=null;
			Node prev=null;
			Stack<Node> stack=new Stack<>();
			stack.push(root);
			while(!stack.isEmpty()){
				curr=stack.peek();
				if((curr.getLeftNode()==null&& curr.getRightNode()==null)||
						(prev!=null && (curr.getLeftNode()==prev||curr.getRightNode()==prev))){
					result.add(curr.getContent());
					prev=curr;
					stack.pop();
				}
				else {
					if(curr.getRightNode()!=null){
						stack.push(curr.getRightNode());
					}
					if(curr.getLeftNode()!=null){
						stack.push(curr.getLeftNode());
					}
				}
			}
			return result;
		}
	}
	
	//根据两个树节点寻找最近非父节点
	public Node2 searchSameParent(Node2 node1,Node2 node2){
		if(node1==null || node2==null){
			return null;
		}
		else {
			int depth1=getDepth(node1);
			int depth2=getDepth(node2);
			//首先必须调节到同一层
			while(depth1!=depth2){
				if(depth1>depth2){
					depth1--;    //注意是--
					node1=node1.getParent();
				}
				if(depth2>depth1){
					depth2--;
					node2=node2.getParent();
				}
			}
			while(node1 !=node2){
				if(node1==null || node2==null){
					break;
				}
				node1=node1.getParent();
				node2=node2.getParent();
			}
			if(node1!=null && node2!=null){
				return node1;
			}
			else {
				return null;
			}
		}
	}
	private int getDepth(Node2 node){
		if(node==null){
			return 0;
		}
		else {
			int count=0;
			while(node!=null)
			{
				count++;
				node=node.getParent();
			}
			return count;
		}
	}

	public Node2 constructTree2(List<String> mediumList,List<String> backList){
		if(mediumList==null && backList==null){return null;}
		int len=backList.size();
		String rootContent=backList.get(len-1);
		int partIndex=mediumList.indexOf(rootContent);
		List<String> leftTreeMediumList=null;  //先初始化为Null,若不满足下面的条件，它集会传null值给递归函数
		List<String> rightTreeMediumList=null;
		List<String> leftTreeBackList=null;
		List<String> rightTreeBackList=null;
		if(partIndex>0)
		{
			leftTreeMediumList=mediumList.subList(0, partIndex); //第二个参数的索引本来就不包括在子序列中
			leftTreeBackList=backList.subList(0, partIndex);
		}
		if(partIndex<len-1)
		{
			rightTreeMediumList=mediumList.subList(partIndex+1, len);
			rightTreeBackList=backList.subList(partIndex, len-1);
		}
		Node2 root=new Node2();
		root.setContent(rootContent);
		Node2 leftNode=constructTree2(leftTreeMediumList, leftTreeBackList);
		root.setleftNode(leftNode);
		if(leftNode!=null)  //一定要记得非空判断
		{
			leftNode.setParent(root);
		}
		Node2 rightNode=constructTree2(rightTreeMediumList, rightTreeBackList);
		root.setRightNode(rightNode);
		if(rightNode!=null)
		{
			rightNode.setParent(root);
		}
		return root;
	}
	
	//二叉树非反转、镜像
	public void inverseTree(Node root){
		if(root==null ||(root.getLeftNode()==null && root.getRightNode()==null)){
			return;
		}
		else {
			Node temp=root.getLeftNode();
			root.setleftNode(root.getRightNode());
			root.setRightNode(temp);
			inverseTree(root.getLeftNode());
			inverseTree(root.getRightNode());
		}
	}
	
	//查找一棵树中一个节点中序遍历的下一个值
	public Node2 getNextInMedium(Node2 node){
		if(node==null){
			return null;
		}
		if(node.getRightNode()!=null)
		{
			Node2 rightNode=node.getRightNode();
			while(rightNode.getLeftNode()!=null){
				rightNode=rightNode.getLeftNode();
			}
			return rightNode;
		}
		else {
			Node2 parent=node.getParent();
			while(parent!=null){
				if(parent.getLeftNode()==node){
					return parent;
				}
				else {
					node=parent;  //这两句的顺序千万别混了
					parent=parent.getParent();
					
				}
			}
			return null;
		}
	}

	//判断树root2是不是另一棵树root2的子结构
	public boolean hashSubTree(Node root1,Node root2){
		boolean result=false;
		if(root1!=null && root2!=null){
			if(root1.getContent()==root2.getContent())
			{
				result= isTree1HasTree2(root1,root2);
			}
			if(!result){
				result=hashSubTree(root1.getLeftNode(), root2);
			}
			if(!result){
				result=hashSubTree(root1.getRightNode(), root2);
			}
		}
		return result;
	}
	
	private boolean isTree1HasTree2(Node root1,Node root2){
		if(root2==null)
		{
			return true;
		}
		if(root1==null){
			return false;
		}
		if(root1!=null && root2!=null){
			if(root1.getContent()==root2.getContent()){
				return isTree1HasTree2(root1.getLeftNode(), root2.getLeftNode())&&
						isTree1HasTree2(root1.getRightNode(), root2.getRightNode());
			}
			else {
				return false;
			}
		}
		return false;
		
	}
	
}

