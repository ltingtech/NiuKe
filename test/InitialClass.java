package test;

public class InitialClass {

	public static void main(String[] args) {
		MyClass2 c2=new MyClass2();
	}
}
class MyClass1{
	public MyClass1(){
		System.out.println("MyClass1 constructor");
	}
	static {
		System.out.println("MyClass1 static block");
	}
}
class MyClass2 extends MyClass1{
	public MyClass2(){
		System.out.println("MyClass2 constructor");
	}
	static{
		System.out.println("MyClass2 static block");
	}
	public static void print(){
		System.out.println("MyClass static founction");
		System.out.println(innerClass.innerKey);
	}
	public static class innerClass{
		private static int innerKey=9;
		static{
			System.out.println("inner class static block");
		}
		private static void innerPrint(){
			System.out.println("inner class static founction");
		}
		public innerClass(){
			System.out.println("inner class constructor");
		}
	}
}
