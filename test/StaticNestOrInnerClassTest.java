package test;

public class StaticNestOrInnerClassTest {
	public static String name="luoting";
	private int age=23;
	private static class Person{
		public static String address="jiangxi";//��̬�ڲ�����Զ��徲̬����
		public String email="ddd.@136.com";
		public void printName(){   //��̬�ڲ�����Է����ⲿ�ྲ̬����
			System.out.println(name);
		}
//		public  void printAge(){
//			System.out.println(age);   //��̬�ڲ��಻�ܷ����ⲿ��Ǿ�̬����
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
	/***************��ͨ�ڲ���*****************/
	
	public class Annimal{
//		public static String address="beijingzoom";  //��ͨ�ڲ����в��ܺ��о�̬��Ա
		public String address="beijingzoom";
		private String voice="miao~miao~~";
		public void printName(){
			System.out.println(name);
		}
		public void printAge(){
			System.out.println(age); //��ͨ�ڲ�����Է����ⲿ��Ǿ�̬����
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
