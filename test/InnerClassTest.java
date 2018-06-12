package test;

public class InnerClassTest {
	
	public static void main(String[] args) {
		OuterClass outer=new OuterClass();
		outer.outClassMethod();
		System.out.println("************************");
		//��ȷ
		OuterClass.InnerClass inner=new OuterClass().new InnerClass(9);
		//����
		//OuterClass.InnerClass inner2=new OuterClass().InnerClass(10);
		inner.showData();
		//���ﲻ�ܷ����ڲ����е�˽�г�Ա
		//�ڲ����е�˽�г�Ա���ⲿ���е�˽�г�Ա�ķ���Ȩ�޼�����һ���
		//�ڲ����е�˽�г�Ա���������ö��ⲿ�಻������
		//System.out.println(inner.data);
		OuterClass.StaticInnerClass staticInner=new OuterClass.StaticInnerClass();
		staticInner.showOuterData();

	}

}
class OuterClass{
	private int outData;
	public static int outData2=10;
	public void outClassMethod(){
		InnerClass inner=new InnerClass(8);
		inner.showData();
		System.out.println(inner.data);  //�ⲿ����Է����ڲ����˽�г�Ա
	}
	//�ڲ���
    public class InnerClass{
    	private int data;
    	public InnerClass(int data) {
			this.data=data;
		}
    	public InnerClass(){
    		
    	}
    	public void showData(){
    		System.out.println(data);
    	}
    }
    //��̬�ڲ���
    static class StaticInnerClass{
    	//��̬�ڲ������ͨ������Է����ⲿ��̬����
    	public void showOuterData(){
    		System.out.println(outData2);
    	}
    }
}
