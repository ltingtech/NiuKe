package Offer;

public class ConvertTreeToChain2 {

	public static void main(String[] args) {
		TreeNode node1=new TreeNode(10);
		TreeNode node2=new TreeNode(6);
		TreeNode node3=new TreeNode(14);
		TreeNode node4=new TreeNode(4);
		TreeNode node5=new TreeNode(8);
		TreeNode node6=new TreeNode(12);
		TreeNode node7=new TreeNode(16);
		node1.left=node2;
		node1.right=node3;
		node2.left=node4;
		node2.right=node5;
		node3.left=node6;
		node3.right=node7;
		ConvertTreeToChain2 instance=new ConvertTreeToChain2();
		TreeNode headNode=instance.Convert(node1);
		while(headNode!=null){
			System.out.println(headNode.val);
			headNode=headNode.right;
		}
		
		

	}
	private TreeNode lastNode=null;
	public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree==null){
            return null;
        }
        convertNode(pRootOfTree);
        TreeNode head=lastNode;
        while(head!=null && head.left!=null){
        	head=head.left;
        }
        return head;
        
    }
    private void convertNode(TreeNode root){
        if(root==null){
            return;
        }
        else{
            if(root.left!=null){
                convertNode(root.left);
            }
            
            if(lastNode!=null){
                lastNode.right=root;
                root.left=lastNode;
            }
            lastNode=root;
            if(root.right!=null){
                convertNode(root.right);
            }
        }
    }

}
 class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
