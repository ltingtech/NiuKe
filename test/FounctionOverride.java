package test;

public class FounctionOverride extends Child{
	//�ɼ��Կ������󣬵��ǲ��ܼ�С
//	public int add(int param1,int param2){
//		return 0;
//	}
	//��д�����������ͱ���һ��
//	private short add(int param1,int param2){
//		return 0;
//	}
	//������һ�£�����
//	private int add(int param1,long param2){
//		return 0;
//	}
	//����
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
