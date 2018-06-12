package datastruct;

public class QuickSortInChain {

	public static void main(String[] args) {
//		Integer i1=5;
//		Integer i2=5;
//		System.out.println(i1==i2);
//		Integer i3=2;
//		Integer i4=3;
//		System.out.println(i2==(i3+i4));
//		Integer i5=128;
//		Integer i6=128;
//		System.out.println(i5==i6);
		
		ChainNode node1=new ChainNode(8.0);
		ChainNode node2=new ChainNode(7.0);
		ChainNode node3=new ChainNode(9.0);
		ChainNode node4=new ChainNode(10.0);
		ChainNode node5=new ChainNode(4.0);
		ChainNode node6=new ChainNode(6.0);
		ChainNode node7=new ChainNode(5.0);
		ChainNode node8=new ChainNode(12.0);
		ChainNode node9=new ChainNode(5.0);
		node1.setNextNode(node2);
		node2.setNextNode(node3);
		node3.setNextNode(node4);
		node4.setNextNode(node5);
		node5.setNextNode(node6);
		node6.setNextNode(node7);
		node7.setNextNode(node8);
		node8.setNextNode(node9);
		
		ChainSeg seg=quickSortInChain(new ChainSeg(node1, node2));
		ChainNode p=seg.head;
		while(p!=null){
			System.out.println(p.getKey());
			p=p.getNextNode();
		}

	}
//	private static ChainNode head1,head2,end1,end2;
//	private static ChainNode head,end;
	//参数中要有链表尾节点是因为最后连接两个子链表时需要用
	public static ChainSeg quickSortInChain(ChainSeg seg){
		ChainNode head=seg.head;
		ChainNode end=seg.end;
		if(head==end){
			return seg;
		}
		else{
			ChainNode head1,head2,end1,end2;
			head1=head2=end1=end2=null;
			ChainNode prev1=null,prev2=null;
			double key=head.getKey();
			ChainNode p=head.getNextNode();
			while(p!=null){
				if(p.getKey()<key){   //小值链表
					if(head1==null){
						head1=p;
						prev1=p;
					}
					else{
						prev1.setNextNode(p);
						prev1=p;
					}
					p=p.getNextNode();
					prev1.setNextNode(null);
				}
				else{     //大值链表
					if(head2==null){
						head2=p;
						prev2=p;
					}
					else{
						prev2.setNextNode(p);
						prev2=p;
					}
					p=p.getNextNode();
					prev2.setNextNode(null);
				}
			}
			//确定两个链表的尾节点
			end1=prev1;
			end2=prev2;
			
			ChainSeg leftSeg=quickSortInChain(new ChainSeg(head1, end1));
			ChainSeg rightSeg=quickSortInChain(new ChainSeg(head2, end2));
			head1=leftSeg.head;
			end1=leftSeg.end;
			head2=rightSeg.head;
			end2=rightSeg.end;
			if(end1!=null && head2!=null){ //左、右链表都存在
				end1.setNextNode(head);
				head.setNextNode(head2);
				head=head1;
				end=end2;
			}
			else{
				if(end1!=null){  //只有左链表存在
					end1.setNextNode(head);
					end=head;
					head=head1;
					
				}
				if(head2!=null){
					head.setNextNode(head2);
					end=end2;
				}
			}
			seg.head=head;
			seg.end=end;
			return seg;
		}
	}
	

}
class ChainSeg{
	public ChainNode head;
	public ChainNode end;
	public ChainSeg(ChainNode head,ChainNode end){
		this.head=head;
		this.end=end;
	}
}
