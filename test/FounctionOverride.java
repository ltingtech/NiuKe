package test;

public class FounctionOverride extends Child{
	//可见性可以增大，但是不能减小
//	public int add(int param1,int param2){
//		return 0;
//	}
	//重写函数返回类型必须一致
//	private short add(int param1,int param2){
//		return 0;
//	}
	//参数不一致，重载
//	private int add(int param1,long param2){
//		return 0;
//	}
	//可以
	private short add(int param1,long param2){
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class Child{
	protected int add(int param1,int param2) {
		return 0;
	}
}
