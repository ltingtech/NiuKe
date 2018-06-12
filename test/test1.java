package test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

public class test1 {

	public static void main(String[] args) {
		Prototype myPrototype=new Prototype();
		myPrototype.setName(new String("luoting"));
		Element element=new Element(5);
		myPrototype.setEle(element);
		System.out.println(myPrototype.getEle().getAge());
		try {
//			Prototype secondPro=myPrototype.cloneMethod();

			Prototype secondPro=myPrototype.deepCloneMethod();
			System.out.println(secondPro.getEle().getAge());
			secondPro.getEle().setAge(10);
			System.out.println(secondPro.getEle().getAge());
			System.out.println(myPrototype.getEle().getAge());

			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}

class Prototype implements Cloneable,Serializable{
	private String name;
	private Element ele;
	public Prototype cloneMethod() throws CloneNotSupportedException
	{
		Prototype instance=(Prototype)super.clone();
		return instance;
	}
	public Prototype deepCloneMethod() throws CloneNotSupportedException,IOException,ClassNotFoundException{
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		ObjectOutputStream oos=new ObjectOutputStream(bos);
		oos.writeObject(this);
		
		ByteArrayInputStream bis=new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream ois=new ObjectInputStream(bis);
		Prototype prototype=(Prototype)ois.readObject();
		return prototype;
	}
	
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	public Element getEle(){
		return ele;
	}
	public void setEle(Element ele){
		this.ele=ele;
	}
}
class Element implements Serializable{
	private int age;
	public int getAge(){
		return age;
	}
	public void setAge(int age){
		this.age=age;
	}
	public Element(){}
	public Element(int age){
		this.age=age;
	}
}
