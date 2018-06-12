package Offer;

public class EntryNodeOfLoop {

	public static void main(String[] args) {
		ListNode node1=new ListNode(1);
		ListNode node2=new ListNode(2);
		ListNode node3=new ListNode(3);
		ListNode node4=new ListNode(4);
		ListNode node5=new ListNode(5);
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		node4.next=node5;
		node5.next=node2;
		EntryNodeOfLoop instance=new EntryNodeOfLoop();
		ListNode node=instance.entryNodeOfLoop(node1);
		System.out.println(node.val);


	}
	 public ListNode entryNodeOfLoop(ListNode pHead)
	    {
	        ListNode meetNode=meetingNode(pHead);
	        if(meetNode==null){
	            return null;
	        }
	        else{
	            ListNode n=meetNode.next;
	            int loopLen=1;
	            while(n!=meetNode){
	                loopLen++;
	                n=n.next;
	            }
	            ListNode head=pHead;
	            for(int i=0;i<loopLen;i++){
	                head=head.next;
	            }
	            while(head!=pHead){
	                head=head.next;
	                pHead=pHead.next;
	            }
	            return head;
	        }
	        
	    }
	    private ListNode meetingNode(ListNode pHead){
	        ListNode result=null;
	        if(pHead!=null){
	            ListNode prev=pHead;
	            ListNode head=pHead.next;
	            while(prev!=null && head!=null){
	                if(prev==head){
	                    result=head;
	                    break;
	                }
	                else{
	                    prev=head;
	                    head=head.next;
	                    if(head!=null){
	                    	head=head.next;
	                    }
	                }
	            }
	        }
	        return result;
	    }

}

// class ListNode{
//   int val;
//   ListNode next = null;
//
//   ListNode(int val) {
//       this.val = val;
//   }
//}

