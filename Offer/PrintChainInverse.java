package Offer;

import java.util.*;

public class PrintChainInverse {
	public static void main(String[] args){
		ListNode node1=new ListNode(64);
		ListNode node2=new ListNode(0);
		ListNode node3=new ListNode(24);
		ListNode node4=new ListNode(58);
		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		ArrayList<Integer> result=printListFromTailToHead(node1);
		
	}
	
	
	
	 public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
	     ArrayList<Integer> result=new ArrayList<Integer>();
	     if(listNode==null)
	         {
	         return null;
	     }
	     else{
	         ListNode prev=null;
	         ListNode curr=listNode;
	         ListNode nextNode=curr.getNext();
	         while(nextNode!=null)
	             {
	             curr.setNext(prev);
	             prev=curr;
	             curr=nextNode;
	             nextNode=nextNode.getNext();
	         }
	         curr.setNext(prev);//注意这行不能忘了
	         
	         //顺序打印
	         while(curr!=null){
	             result.add(new Integer(curr.getVal()));
	             curr=curr.getNext();
	         }
	         return result;
	         
	     }
	     
	 }
}
class ListNode {
    int val;
   ListNode next = null;

   ListNode(int val) {
       this.val = val;
   }
   public int getVal(){
       return val;
   }
   public void setVal(int val)
       {
       this.val=val;
   }
   public ListNode getNext(){
       return next;
   }
   public void setNext(ListNode node)
       {
       this.next=node;
   }
}


