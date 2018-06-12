package test;

public class Test3 {
    static{
    	int a=5;
    }
    static int x,y;
    public static void myMethod(){
    	y=x++ + ++x;
    }
	public static void main(String[] args) {
		x--;
		myMethod();
		System.out.println(x+y+ ++x);

	}

}
