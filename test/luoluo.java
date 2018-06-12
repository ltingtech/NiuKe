package test;

import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.Vector;

public class luoluo extends tingting{
	private String addr;
	public static String printYourName(String name1){
		return name1+" child";
	}
	public luoluo(String addr,int age){
		super(age);
		this.addr=addr;
	}
	public luoluo(){}
	@Override
	public boolean equals(Object object){
		if(object==this)
		{
			return true;
		}
		if(object instanceof luoluo){
			if(super.equals(object))
			{
				luoluo o=(luoluo)object;
				return o.addr==this.addr;
			}
			else 
				return false;
		}
		return false;
	}

	public static void main(String[] args) {
//		System.out.println(tingting.printYourName("tingting"));
//		System.out.println(luoluo.printYourName("luoluo"));
//		System.out.println("************************");
//		Object t2=new tingting();
//		tingting t3=(tingting)t2;
//		t3.setAge(20);
//		int age=t3.getAge();
		/*************************************/
//		Set<luoluo> nameSet=new LinkedHashSet<luoluo>();
//		nameSet.add(new luoluo("jiangxi",23));
//		nameSet.add(new luoluo("jiangxi",23));
//		nameSet.add(new luoluo("jiangxi",23));
//		Iterator<luoluo> iterator=nameSet.iterator();
//		while(iterator.hasNext())
//		{
//			luoluo l=iterator.next();
//			System.out.println(l.toString());
//		}
	/************************************/
		List<String> strl1=new ArrayList<String>();
		strl1.add("luo");
		strl1.add("ting");
		strl1.add(null);
		System.out.println(strl1.get(2));
		List<String> strl2=new LinkedList<String>();
		strl2.add("luo");
		strl2.add("ting");
		strl2.add(null);
		System.out.println(strl2.get(2));
		Vector<String> vec=new Vector<String>();
		vec.add("luo");
		vec.add("ting");
		vec.add(null);
		System.out.println(vec.get(2));
		

		
		
		
	}

}
class tingting{
	public static String staticNameString="static name";
	private int age;
	public tingting(int age){
		this.age=age;
	}
	public tingting(){}
	public int getAge(){
		return age;
	}
	public void setAge(int age){
		this.age=age;
	}
	public static  String printYourName(String name)
	{
		return name+" base";
	}
	@Override
	public boolean equals(Object object)
	{
		if(this==object){
			return true;
		}
		if(object instanceof tingting)
		{
			tingting o=(tingting)object;
			return o.age==this.age;
		}
		return false;
		
	}
	@Override
	public int hashCode(){return 100;}
	
}
