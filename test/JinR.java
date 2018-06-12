package test;

public class JinR{
    
    public static void main(String[] args){
        NewNode n1=new NewNode(23);
        NewNode n2=new NewNode(12);
        NewNode n3=new NewNode(11);
        NewNode n4=new NewNode(56);
        NewNode n5=new NewNode(26);
        NewNode n6=new NewNode(67);
        NewNode n7=new NewNode(2);
        NewNode n8=new NewNode(19);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        n6.next=n7;
        n7.next=n8;
        JinR instance=new JinR();
        NewNode head=instance.sortChain(n1);
        if(head==null){
            System.out.println("null");
        }
        else{
            System.out.println("no null");
        }
        
        instance.print(head);
    }
    public void print(NewNode head){
        while(head!=null){
            System.out.println(head.value);
            head=head.next;
        }
    }
    
    public NewNode sortChain(NewNode head){
        if(head==null || head.next==null){
            return head;
        }
        else{
            NewNode p1=head;
            NewNode pre=null;
            NewNode p2=head;
            while(p2!=null){
                pre=p1;
                p1=p1.next;
                if(p2.next!=null){
                    p2=p2.next.next;
                }
                else{
                    break;
                }
            }
            pre.next=null;
            NewNode NewNode1=sortChain(head);
            NewNode NewNode2=sortChain(p1);
            return merge(NewNode1,NewNode2);
            
        }
        
    }
    private NewNode merge(NewNode head1,NewNode head2){
        if(head1==null){
            
            return head2;
        }
        if(head2==null){
           
            return head1;
        }
        if(head1!=null && head2!=null){
            //System.out.print("111");
            NewNode p1=head1;
            NewNode p2=head2;
            NewNode newHead=p1;
            NewNode prev=null;
            while(p1!=null && p2!=null){
                if(prev==null){
                    if(p1.value>p2.value){
                        prev=p2;
                        newHead=p2;
                        
                        p2=p2.next;
                    }
                    else{
                        prev=p1;
                        p1=p1.next;
                    }
                }
                else{
                    if(p1.value<p2.value){
                        prev.next=p1;
                        prev=p1;
                        p1=p1.next;
                    }
                    else{
                        prev.next=p2;
                        prev=p2;
                        p2=p2.next;
                    }
                }
            }
            if(p1!=null){
                prev.next=p1;
            }
            if(p2!=null){
                prev.next=p2;
            }
            //System.out.println("before return in merge");
            return newHead;
        }
        else{
             
        	return null;
    	}
    }
    
}
class NewNode{
    public int value;
    public NewNode next;
    public NewNode(int v){
        this.value=v;
    }
}
