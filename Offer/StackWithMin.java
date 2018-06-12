package Offer;

import java.util.*;

public class StackWithMin<T extends Comparable> {  //泛型参数T要比较大小，必须扩展Comparable类

	public static void main(String[] args) {
		StackWithMin<Double> testStack=new StackWithMin<Double>();
		testStack.push(3.4);
		testStack.push(2.3);
		System.out.println(testStack.min());
		testStack.pop();
		System.out.println(testStack.min());
		testStack.push(5.6);
		testStack.push(1.9);
		System.out.println(testStack.min());

	}
	
	private Stack<T> dataStack=new Stack<T>();
	private Stack<T> minStack=new Stack<T>();
	public void push(T data){
		dataStack.push(data);
		if(!minStack.isEmpty()){
			T minData=minStack.peek();
			if(minData.compareTo(data)<0){
				minStack.push(minData);
			}
			else {
				minStack.push(data);
			}
		}
		else {
			minStack.push(data);
		}
	}
	public T pop(){
		assert(!minStack.isEmpty() && !dataStack.isEmpty()); //程序开发过程中用
		minStack.pop();
		return dataStack.pop();
	}
	public T min(){
		assert(!minStack.isEmpty() && !dataStack.isEmpty());
		return minStack.peek();
	}
	

}
