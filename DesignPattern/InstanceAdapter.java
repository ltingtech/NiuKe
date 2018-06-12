//package DesignPattern;
//
//public class InstanceAdapter {
//
//	public static void main(String[] args) {
//		sourceable a=new Adapter();
//		a.method1();
//		a.method2();
//
//	}
//
//}
//interface sourceable{
//	public void method1();
//	public void method2();
//}
//class Source1{
//	public void method1(){
//		System.out.println("method1");
//	}
//}
//
//class Adapter implements sourceable{
//	Source1 s1=new Source1();
//	public void method1(){
//		s1.method1();
//	}
//	public void method2(){
//		System.out.println("method2");
//	}
//}
