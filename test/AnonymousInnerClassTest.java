package test;

public class AnonymousInnerClassTest {
	public void play(In1 t)
	{
		t.print();
	}
	public static void main(String[] args) {
		AnonymousInnerClassTest test1=new AnonymousInnerClassTest();
		test1.play(new In1() {
			public void print() {
				System.out.println("I am A");
				
			}
		});
		test1.play(new In1() {
			
			public void print() {
				System.out.println("I am B");
				
			}
		});

	}

}
abstract interface In1{
	public void print();
}

