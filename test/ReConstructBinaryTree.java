package test;

import java.util.LinkedList;
import java.util.Queue;

public class ReConstructBinaryTree {

	public static void main(String[] args) {
		ReConstructBinaryTree instance=new ReConstructBinaryTree();
		int[] pre=new int[]{1,2,4,7,3,5,6,8};
		int[] in=new int[]{4,7,2,1,5,3,8,6};
//		int[] pre=new int[]{};
//		int[] in=new int[]{};
  
		TreeNode root=instance.reConstructBinaryTree(pre, in);
		if(root!=null){
			Queue<TreeNode> queue=new LinkedList<TreeNode>();
			queue.add(root);
			TreeNode tmpNode=new TreeNode();
			while(!queue.isEmpty()){
				tmpNode=queue.poll();
				if(tmpNode.getLeft()!=null)
				{
					queue.add(tmpNode.getLeft());
				}
				if(tmpNode.getRight()!=null){
					queue.add(tmpNode.getRight());
				}
				System.out.print(tmpNode.getVal()+" ");
			}
		}

	}
	public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
		TreeNode result=null;
        if(pre==null||in==null)
            {
            return null;
        }
        else {
        	try {
        		result=reConstruct(pre,0,pre.length-1,in,0,in.length-1);
			} catch (Exception e) {
				System.out.println(e.getMessage());
//				e.printStackTrace();
			}
        	return result;
        	
		}
    }
    private TreeNode reConstruct(int[] pre,int preFirst,int preEnd,int[] in,int inFirst,int inEnd)
    		throws Exception
        {
        if(preFirst>preEnd || inFirst>inEnd)
            {
            return null;
        }
        else
            {
            int len1=pre.length;
            int len2=in.length;
            if(len1==len2&&preFirst>=0&&preEnd<len1&&inFirst>=0&&inEnd<len2){
                if(preFirst==preEnd&&inFirst==inEnd)
                    {
                	if(pre[preFirst]==in[inFirst])
                	{
                		return new TreeNode(in[inFirst]);
                	}
                	else {
						throw new Exception("invalid input");
					}
                }
                else
                    {
                    int rootVal=pre[preFirst];
                    int idx=-1;
                    for(int i=inFirst;i<=inEnd;i++){
                        if(in[i]==rootVal){
                            idx=i;
                            break;
                        }
                    }
                    if(idx>=0){
                        TreeNode root=new TreeNode(rootVal);
                        int leftLen=idx-inFirst;
                        TreeNode left=new TreeNode();
                        TreeNode right=new TreeNode();
                        try {
                        	left=reConstruct(pre,preFirst+1,preFirst+leftLen,in,inFirst,idx-1);
                        	right=reConstruct(pre,preFirst+leftLen+1,preEnd,in,idx+1,inEnd);		
						} catch (Exception e) {
							throw e;
						}
                        root.setLeft(left);
                        root.setRight(right);
                        return root;
                    }
                    else {
						throw new Exception("invalid input");
					}
                }
                
            }
            else {
				throw new Exception("invalid input");
			} 
        }
    }
 
}
class TreeNode{
	private int val;
	private TreeNode left;
	private TreeNode right;
	public TreeNode(int val)
	{
		this.val=val;
	}
	public TreeNode(){}
	public int getVal(){
		return val;
	}
	public void setVal(int val){
		this.val=val;
	}
	public TreeNode getLeft(){
		return left;
	}
	public void setLeft(TreeNode left)
	{
		this.left=left;
	}
	public TreeNode getRight(){
		return right;
	}
	public void setRight(TreeNode right){
		this.right=right;
	}
}
