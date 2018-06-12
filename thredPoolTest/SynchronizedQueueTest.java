package thredPoolTest;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Vector;
import java.util.Map.Entry;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SynchronizedQueueTest {

	public static void main(String[] args) {
		HashMap<String, Integer> map=new HashMap<String, Integer>();
		Iterator< Entry<String, Integer>> iterator= map.entrySet().iterator();
		Hashtable<String, Integer> tab=new Hashtable<String, Integer>();
		Iterator<Entry<String, Integer>> iterator2=tab.entrySet().iterator();
		Enumeration<Integer> em=new Vector<Integer>().elements();
		
//		SynchronousQueue<Integer> queue=new SynchronousQueue<Integer>();
//		Producer producer=new Producer(queue);
//		Consumer consumer=new Consumer(queue);
//		new Thread(producer).start();
//		new Thread(consumer).start();
//		SynchronousQueue<Runnable> queue=new SynchronousQueue<Runnable>();
//		ThreadPoolExecutor executor=new ThreadPoolExecutor(3, 5, 10, TimeUnit.SECONDS, queue);
////		executor.setMaximumPoolSize(Integer.MAX_VALUE);
//		for(int i=0;i<10;i++){
//			executor.execute(new Producer(i));
//		}
		

	}
	

}
class Producer implements Runnable{
	private SynchronousQueue<Integer> q=null;
	public Producer(SynchronousQueue< Integer> queue){
		q=queue;
	}
	public void run(){
		while(true){
			int num=new Random().nextInt(100);
			System.out.println("生产了...."+num);
			System.out.println("等待3秒发出去");
			try {
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			q.offer(num);
		}
	}
}


class Consumer implements Runnable{
	private SynchronousQueue<Integer> q=null;
	public Consumer(SynchronousQueue<Integer> queue){
		q=queue;
	}
	public void run(){
		while(true){
			try{
				System.out.println("消费了..."+q.take());
			}catch(Exception e){
				e.printStackTrace();
			}
			System.out.println("--------------------------");
		}
	}
	
}

//class Producer extends Thread{
//	int index=0;
//	public Producer(int index){
//		this.index=index;
//	}
//
//	public void run(){
//		System.out.println(Thread.currentThread().getName()+"....."+index);
//		try {
//			Thread.sleep(1000);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//}




