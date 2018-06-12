package test;

public class ThreadLocalTest {
	//匿名内部类，匿名内部类的使用前提是继承父类或接口
	ThreadLocal<Integer> testNum=new ThreadLocal<Integer>(){
		public Integer initialValue(){
			return 0;
		}
	};
	public int getNextNum(){
		testNum.set(testNum.get()+1);
		return testNum.get();
	}
	//内部类构造线程类
	private static class testThread implements Runnable{
		private ThreadLocalTest t;
		public testThread(ThreadLocalTest t){
			this.t=t;
		}
		public void run(){
			for(int i=0;i<3;i++)
			{
				System.out.println("Tread["+Thread.currentThread().getName()+"]-->["+t.getNextNum());
			}
		}
	}

	public static void main(String[] args) {
		ThreadLocalTest s=new ThreadLocalTest();
		//3个线程共用一个实例对象，但是不会相互干扰
		testThread t1=new testThread(s);
		testThread t2=new testThread(s);
		testThread t3=new testThread(s);
		Thread th1=new Thread(t1);
		Thread th2=new Thread(t2);
		Thread th3=new Thread(t3);
		th1.start();
		th2.start();
		th3.start();

	}

}
