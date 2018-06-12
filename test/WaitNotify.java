package test;

public class WaitNotify {

	public static void main(String[] args) {
		BufferQueue q=new BufferQueue();
		Consumer con=new Consumer(q);
		Producer pro=new Producer(q);
		new Thread(con).start();
		new Thread(pro).start();

	}

}
class BufferQueue{
	private boolean isEmpty;
	private int num;
	public BufferQueue(int data){
		num=data;
		isEmpty=false;
	}
	public BufferQueue(){
		isEmpty=true;
	}
	public synchronized void put(int data){
		if(!isEmpty)  //不为空就需等待
		{
			try{
				wait();
			}
			catch(InterruptedException e)
			{
				System.out.println(e.getMessage());
			}
		}
		num=data;
		isEmpty=false;
		notifyAll();
	}
	public synchronized int get(){
		if(isEmpty){
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
		isEmpty=true;
		notifyAll();
		return num;
	}
}

//消费者
class Consumer implements Runnable {
	private BufferQueue q;
	public Consumer(BufferQueue q)
	{
		this.q=q;
	}
	public void run() {
		while(true)
		{
			System.out.println("消费...."+q.get());
			try{
				Thread.sleep(1000);
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
			
		}
	}
}
//生产者
class Producer implements Runnable{
	private BufferQueue q;
	private int data=0;
	public Producer(BufferQueue q){
		this.q=q;
	}
	public void run(){
		while(true){
			System.out.println("生产了...."+data);
			q.put(data);
			data++;
			try{
				Thread.sleep(1000);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
			
		}
	}
}
