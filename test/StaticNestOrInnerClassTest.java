package test;

public class StaticNestOrInnerClassTest {
	public static String name="luoting";
	private int age=23;
	private static class Person{
		public static String address="jiangxi";//静态内部类可以定义静态属性
		public String email="ddd.@136.com";
		public void printName(){   //静态内部类可以访问外部类静态属性
			System.out.println(name);
		}
//		public  void printAge(){
//			System.out.println(age);   //静态内部类不能访问外部类非静态属性
//		}
	}
	public void printPersonInfo()
	{
		Person p=new StaticNestOrInnerClassTest.Person();
		System.out.println(p.email);
		System.out.println(Person.address);
		p.printName();
		System.out.println(age);
	}
	/***************普通内部类*****************/
	
	public class Annimal{
//		public static String address="beijingzoom";  //普通内部类中不能含有静态成员
		public String address="beijingzoom";
		private String voice="miao~miao~~";
		public void printName(){
			System.out.println(name);
		}
		public void printAge(){
			System.out.println(age); //普通内部类可以访问外部类非静态属性
		}
	}
	public void printAnnimalInfo(){
		Annimal a=new StaticNestOrInnerClassTest().new Annimal();
		a.printName();
		a.printAge();
		System.out.println(a.voice);
		System.out.println(a.address);
	}

	public static void main(String[] args) {
		StaticNestOrInnerClassTest test=new StaticNestOrInnerClassTest();
		System.out.println("*********Person information*********");
		test.printPersonInfo();
		System.out.println("*******Annima Information**********");
		test.printAnnimalInfo();

	}

}
