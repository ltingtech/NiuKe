package datastruct;

import java.util.Stack;

public class StackToQueue {

	public static void main(String[] args) {
		MyQueue q=new MyQueue();
		q.deleteHead();
		q.addToTail(9.0);
		q.addToTail(3.4);
		q.deleteHead();
		q.addToTail(4.5);
		q.deleteHead();

	}

}
class MyQueue{
	private Stack<Double> stack1=new Stack<>();
	private Stack<Double> stack2=new Stack<>();
	public void addToTail(double value){
		stack1.clear();
		while(!stack2.isEmpty()){
			stack1.push(stack2.pop());
		}
		stack1.push(new Double(value));
		while(!stack1.isEmpty()){   //加入元素后都要转换到stack2，这里不要忘记写了
			stack2.push(stack1.pop());
		}
	}
	public void deleteHead(){
		if(stack2.isEmpty()){
			System.out.println("this queque is empty");
		}
		else {
			System.out.println(stack2.pop());
		}
	}
	
}