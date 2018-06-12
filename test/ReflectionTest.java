package test;

import java.io.FileDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;



public class ReflectionTest {

	public static void main(String[] args) {
		Employee emp1=new Employee("liming",3204.4);
		Class<?> classType1=emp1.getClass();
//		try {
//			Constructor<?> constructor1=classType1.getConstructor();
//			Object object=constructor1.newInstance();
//			System.out.println(object);
//			constructor1=classType1.getConstructor(String.class,double.class);
//			object=constructor1.newInstance("xiaoming",999.3);
//			System.out.println(object);
//		} catch (Exception e) {
//		}
		
//		Constructor<?>[] conList1=classType1.getConstructors();
//		for (Constructor<?> constructor : conList1) {
//			System.out.println(constructor);
//		}
//		System.out.println("________________________________________");
//		conList1=classType1.getDeclaredConstructors();
//		for (Constructor<?> constructor : conList1) {
//			System.out.println(constructor);
//		}
//		System.out.println("__________________________________________");
		
		
//		System.out.println(classType1);
//		Field[] fieldList=classType1.getFields();
//		for (Field field : fieldList) {
//			System.out.println(field);
//		}
//		System.out.println("method");
//		Method[] methods=classType1.getMethods();
//		for (Method method : methods) {
//			System.out.println(method);
//		}
//		
//		System.out.println("************************");
//		Field[] fieldList2=classType1.getDeclaredFields();
//		for (Field field : fieldList2) {
//			System.out.println(field);
//		}
//		System.out.println("method");
//		Method[] methods1=classType1.getDeclaredMethods();
//		for (Method method : methods1) {
//			System.out.println(method);
//		}
		
		System.out.println("**************************");
		Manager man1=new Manager("jinping",2004.3,242.46);
		Class<?> classType2=man1.getClass();  //获取该类的类型
		try {
			Constructor<?> con =classType2.getConstructor(String.class,double.class,double.class);
			Object obj=con.newInstance("xiaoming",204.2,2424.3);
			Method method=classType2.getDeclaredMethod("getBonus");
			System.out.println(method.invoke(obj));
			method=classType2.getDeclaredMethod("setBonus",double.class);
			method.invoke(obj, 999.9);
			method=classType2.getDeclaredMethod("getBonus");
			System.out.println(method.invoke(obj));
			
		} catch (Exception e) {
		}
		
		
//		try {
//			Constructor<?> constructor1=classType2.getConstructor();
////			Object object=constructor1.newInstance();
//			Object object=classType2.newInstance();
//			System.out.println(object);
//			constructor1=classType2.getConstructor(String.class,double.class,double.class);
//			object=constructor1.newInstance("xiaoming",999.3,3923.3);
//			Manager manager=(Manager)object;
//			System.out.println(manager.getName()+" "+manager.getBonus());
//			System.out.println(object);
//		} catch (Exception e) {
//		}
//		
//		conList1=classType2.getConstructors();
//		for (Constructor<?> constructor : conList1) {
//			System.out.println(constructor);
//		}
//		System.out.println("________________________________________");
//		conList1=classType2.getDeclaredConstructors();
//		for (Constructor<?> constructor : conList1) {
//			System.out.println(constructor);
//		}
//		System.out.println("__________________________________________");
		
		
//		System.out.println(classType2);
//		Field[] fieldList3=classType2.getFields();
//		for (Field field : fieldList3) {
//			System.out.println(field);
//		}
//		System.out.println("method");
//		Method[] methods3=classType2.getMethods();
//		for (Method method : methods3) {
//			System.out.println(method);
//		}
//		
//		System.out.println("************************");
//		Field[] fieldList4=classType2.getDeclaredFields();
//		for (Field field : fieldList4) {
//			System.out.println(field);
//		}
//		System.out.println("method");
//		Method[] methods4=classType2.getDeclaredMethods();
//		for (Method method : methods4) {
//			System.out.println(method);
//		}
	}

}

class Employee implements Information{
	private String name;
	private double salary;
	public int employeeLevel; //设定一个公共字段
	public Employee(){}
	public Employee(String name,double salary){
		this.name=name;
		this.salary=salary;
	}
	
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	public double getSalary(){
		return salary;
	}
	public void setSalary(double salary){
		this.salary =salary ;
	}
	public void printPrefession(){
		System.out.println("I am a employee");
	}
	
}

class Manager extends Employee{
	private double bonus;
	public String managerLevel;
	public Manager(){}
	public Manager(String name,double salary,double bonus){
		super(name,salary);
		this.bonus=bonus;
	}
	public double getBonus(){
		return bonus;
	}
	public void setBonus(double bonus){
		this.bonus=bonus;
	}
	public void printPrefession(){
		System.out.println("I am a manager");
	}
}
interface Information{
	String country="china";
	void printPrefession();
}