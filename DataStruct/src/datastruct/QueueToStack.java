package datastruct;

import java.util.LinkedList;
import java.util.Queue;

public class QueueToStack {

	public static void main(String[] args) {
		MyStack stack=new MyStack();
		stack.deleteTail();
		stack.addToTail(3.5);
		stack.addToTail(4.5);
		stack.deleteTail();
		stack.addToTail(6.7);
		stack.deleteTail();

	}

}
class MyStack{
	private Queue<Double> queue1=new LinkedList<>(); //一定得及得初始化
	private Queue<Double> queue2=new LinkedList<>();  //初始化
	public void addToTail(double value){
		queue1.add(new Double(value));
	}
	public void deleteTail(){
		queue2.clear();
		if(queue1.isEmpty()){
			System.out.println("this stack is empty");
		}
		else {
			int s=queue1.size();
			while(s>1){
				queue2.add(queue1.poll());
				s--;
			}
			System.out.println(queue1.poll());
			while(!queue2.isEmpty()){
				queue1.add(queue2.poll());  //删除后记得还原
			}
				
		}
	}
	
}
