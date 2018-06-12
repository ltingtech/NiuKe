package Offer;

public class ComplexChainClone {

	public static void main(String[] args) {
		RandomListNode node1=new RandomListNode(1);
		RandomListNode node2=new RandomListNode(2);
		RandomListNode node3=new RandomListNode(3);
		RandomListNode node4=new RandomListNode(4);
		RandomListNode node5=new RandomListNode(5);
		RandomListNode node6=new RandomListNode(6);
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		node5.next=node6;
		node1.random=node6;
		ComplexChainClone instance=new ComplexChainClone();
		RandomListNode head=instance.Clone(node1);
		System.out.println(head.random.label);
		System.out.println("***************");
		
		while(head!=null){
			System.out.println(head.label);
			head=head.next;
		}
		
		

	}
	public RandomListNode Clone(RandomListNode pHead)
    {
        if(pHead==null){
            return null;
        }
        else
            {
            RandomListNode curr=pHead;
            RandomListNode nextNode=null;
            //复制产生节点
            while(curr!=null)
                {
                nextNode=curr.next;
                RandomListNode newNode=new RandomListNode(curr.label);
                curr.next=newNode;
                newNode.next=nextNode;
                curr=nextNode;
            }
            //复制随机指针
            curr=pHead;
            while(curr!=null){
                if(curr.random!=null)
                    {
                    RandomListNode rNode=curr.random;
                    curr.next.random=rNode.next;
                }
                curr=curr.next.next;  //记得跳两次
            }
            //取出复制后的链表
            RandomListNode cloneHead=pHead.next;   //注意复制链表后不能改变原先的链表，否则不能通过
            RandomListNode cloneNode=pHead.next;
            pHead.next=cloneHead.next;
            RandomListNode node=cloneNode.next;
            while(node!=null)
                {
                cloneNode.next=node.next;
                cloneNode=cloneNode.next;
                node.next=cloneNode.next;
                node=node.next;
            }
            return cloneHead;
        }
    }
}
 class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
