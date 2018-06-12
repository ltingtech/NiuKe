package avltree;

public class TreeOperation {
	private static final int EH=0;
	private static final int LH=1;
	private static final int RH=-1;
	//左旋
 	public void leftRotate(AVLNode node){
		if(node==null ||node.getRightNode()==null){
			return;
		}
		else {
			AVLNode rnode=node.getRightNode();
			node.setRightNode(rnode.getLeftNode());
			if(rnode.getLeftNode()!=null){
				rnode.getLeftNode().setParent(node);
			}
			rnode.setParent(node.getParent());
			if(node.getParent()!=null)
			{
				AVLNode parent=node.getParent();
				if(parent.getLeftNode()==node){
					parent.setLeftNode(rnode);
				}
				else {
					parent.setLeftNode(rnode);
				}
			}
			rnode.setLeftNode(node);
			node.setParent(rnode);
		}
	}

	//右旋
	public void rightRotate(AVLNode node){
		if(node==null || node.getLeftNode()==null){
			return;
		}
		else {
			AVLNode lNode=node.getLeftNode();
			node.setLeftNode(lNode.getRightNode());
			if(lNode.getLeftNode()!=null){
				lNode.getLeftNode().setParent(node);
			}
			lNode.setParent(node.getParent());
			if(node.getParent()!=null){
				AVLNode parent=node.getParent();
				if(parent.getLeftNode()==node){
					parent.setLeftNode(lNode);
				}
				else {
					parent.setRightNode(lNode);
				}
			}
			node.setParent(lNode);
			lNode.setRightNode(node);
		}
	}

	public AVLNode avlInsert(AVLNode rootnNode,double key,boolean taller){
		if(rootnNode==null) // 若根节点为空，则直接新建一个根节点返回
		{
			AVLNode root=new AVLNode(key);
			root.setBf(EH);
			taller=true;
			return root;
		}
		else {
			if(rootnNode.getKey()==key){
				System.out.println("the key is already in the tree, return without operation");
				return rootnNode;
			}
			else {
				//左子树插入
				if(key<rootnNode.getKey()){
					avlInsert(rootnNode.getLeftNode(), key, taller);
					if(taller){ //说明树长高了
						switch (rootnNode.getBf()) {
						case LH:
							leftBalance(rootnNode);
							taller=false;
							break;
						case EH:
							rootnNode.setBf(LH);
							taller=true;
							break;
						case RH:
							rootnNode.setBf(EH);
							taller=false;
							break;
						}
					}
				}
				//右子树插入
				if(key>rootnNode.getKey()){
					avlInsert(rootnNode.getRightNode(), key, taller);
					if(taller){
						switch (rootnNode.getBf()) {
						case LH:
							rootnNode.setBf(EH);
							taller=false;
							break;
						case EH:
							rootnNode.setBf(RH);
							taller=true;
							break;
						case RH:
							rightBalance(rootnNode);
							taller=false;
						default:
							break;
						}
					}
				}
				while(rootnNode.getParent()!=null){
					rootnNode=rootnNode.getParent();
				}
				return rootnNode;
			}
			
		}
	}

	
	public void leftBalance(AVLNode rootNode){
		AVLNode lNode=rootNode.getLeftNode();
		switch(lNode.getBf()){
		case LH:
			rootNode.setBf(EH);
			lNode.setBf(EH);
			rightRotate(rootNode);
			break;
		case RH:
			AVLNode rd=lNode.getRightNode();
			switch (rd.getBf()) {
			case LH:
				rootNode.setBf(RH);
				lNode.setBf(EH);
				break;
			case EH:
				rootNode.setBf(EH);
				lNode.setBf(EH);
				break;
			case RH:
				rootNode.setBf(EH);
				lNode.setBf(LH);
				break;
			}
			rd.setBf(EH);
			leftRotate(lNode);
			rightRotate(rootNode);
			
		}
	}
	
	public void rightBalance(AVLNode rootNode){
		AVLNode rNode=rootNode.getRightNode();
		switch(rNode.getBf()){
		case RH:
			rootNode.setBf(EH);
			rNode.setBf(EH);
			break;
		case LH:
			AVLNode ld=rNode.getLeftNode();
			switch(ld.getBf()){
			case EH:
				rootNode.setBf(EH);
				rNode.setBf(EH);
				break;
			case LH:
				rootNode.setBf(EH);
				rNode.setBf(RH);
				break;
			case RH:
				rootNode.setBf(LH);
				rNode.setBf(EH);
				break;
			}
			ld.setBf(EH);
			rightRotate(rNode);
			leftRotate(rootNode);
		}
	}

	public void printHeadList(AVLNode rootNode){
		if(rootNode!=null)
		{
			System.out.println(rootNode.getKey()+" ");
			printHeadList(rootNode.getLeftNode());
			printHeadList(rootNode.getRightNode());
		}
		else {
			return;
		}
	}
}
