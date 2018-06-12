package test;

import java.awt.SystemTray;
import java.awt.print.Printable;


public class test4 {
	private static int ele=9;
	enum Size{
		SMALL("S"),MEDIUM("M"),LARGE("L"),EXTRA_LARGE("XL");
		private String abbreviation;
		private Size(String abbreviation){
			this.abbreviation=abbreviation;
			System.out.println("construct a enum...");
			}
		public String getAbbreviation(){
			return this.abbreviation;
		}
	}

	public static void main(String[] args) {
		
		/*
		 * 原题就有错误，当数组还有初始化元素时不能指定维度，正确的写法应该是下面那句
		 */
		//int[][] array=new int[3][]{new int[3]{5,6,2},new int[5]{6,9,7,8,3},new int[2]{3,2}};
		//int[][] array=new int[][]{new int[]{5,6,2},new int[]{6,9,7,8,3},new int[]{3,2}};
		//System.out.println(array[2][2]);
		/*
		 * 
		 
		Integer a=100;
		Integer b=100;
		System.out.println(a==b);
		Integer aa=1000;
		Integer bb=1000;
		System.out.println(aa==bb);
		Character cc1='c';
		Character cc2='c';
		System.out.println(cc1==cc2);
		*/
		Size size=Enum.valueOf(Size.class, "LARGE");
		System.out.println(size.getAbbreviation());
		System.out.println(Size.EXTRA_LARGE);
		Boolean flag1=true;
		System.out.println(flag1=false);
		test4 t=new test4();
		System.out.println(t.ele);//在这里可以通过对象调用类静态变量
		Outer o=new Outer();
		System.out.println(o.out_ele);
		System.out.println(Outer.out_ele);


		
 
	}

}
class Outer{
	public static int out_ele=9;
	
			
}
