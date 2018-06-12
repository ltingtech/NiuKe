package test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


public class ThreadPoolTest{

	private int queueDeep=4;  //任务队列中能存放的最大任务数
	public void createThreadPool(){
		ThreadPoolExecutor executor=new ThreadPoolExecutor(2, 4, 3, TimeUnit.SECONDS, 
				new ArrayBlockingQueue<Runnable>(queueDeep), new ThreadPoolExecutor.DiscardOldestPolicy());
		for(int i=0;i<10;i++){
			try {
				Thread.sleep(1);
			} catch (Exception e) {
				e.printStackTrace();
			}
			while(executor.getQueue().size()>queueDeep){
				System.out.println("任务队列已满，过3秒再发");
				try {
					Thread.sleep(3000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			TaskThreadPool task=new TaskThreadPool(i);
			System.out.println("put task "+i);
			executor.execute(task);
		}
	}

	public static void main(String[] args){
		ThreadPoolTest test=new ThreadPoolTest();
		test.createThreadPool();
	}
}
class TaskThreadPool implements Runnable{
	private int index;
	public TaskThreadPool(int index){
		this.index=index;
	}
	public void run(){
		System.out.println(Thread.currentThread()+"-"+index+" runing");
		try {
			Thread.sleep(3000);
			System.out.println( Thread.currentThread()+"-"+index+" is terminated!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
