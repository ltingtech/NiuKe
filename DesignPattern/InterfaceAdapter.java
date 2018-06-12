package DesignPattern;

public class InterfaceAdapter {

	public static void main(String[] args) {
		sourceable s1=new Source1();
		s1.method1();
		s1.method2();
		sourceable s2=new Source2();
		s2.method1();
		s2.method2();

	}

}

interface sourceable{
	public void method1();
	public void method2();
}

abstract class Adapter implements sourceable{
	public void method1(){
		System.out.println("original method1");
	}
	public void method2(){
		System.out.println("original method2");
	}
}
class Source1 extends Adapter{
	public void method1(){
		System.out.println("method1 in Source1");
	}
}
class Source2 extends Adapter{
	public void method2(){
		System.out.println("method2 in Source2");
	}
}
