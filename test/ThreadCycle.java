package test;

public class ThreadCycle {

	public static void main(String[] args) {
		final ThreadTest demo1=new ThreadTest();
		new Thread(){
			public void run(){
				demo1.method1();
			}
			
		}.start();
		new Thread(){
			public void run(){
				demo1.method2();
			}
		}.start();
		new Thread(){
			public void run(){
				demo1.method3();
			}
		}.start();

	}

}
class ThreadTest{
	static int count=1;
	volatile int target=1;
	synchronized void method1(){
		int i=0;
		while(true){
			i++;
			while(target==2||target==3){
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("method1___"+i);
			target=2;
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			notifyAll();
		}
	}
	synchronized void method2(){
		int i=0;
		while(true){
			i++;
			while(target==1||target==3){
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("method2___"+i);
			target=3;
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			notifyAll();
		}
	}
	synchronized void method3(){
		int i=0;
		while(true){
			i++;
			while(target==2||target==1){
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("method3___"+i);
			target=1;
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			notifyAll();
		}
	}
}
