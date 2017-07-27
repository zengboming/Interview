//仓库类Storage实现缓冲区
public class Storage {
	
	private int number = 0;
	// 仓库最大存储量 
	private final int MAX_NUM = 5;
	// 仓库存储的载体 
	private Object obj = new Object();
	
	public void produce() throws InterruptedException {
		//同步
		synchronized (obj) {
			while (number == MAX_NUM) {
				System.out.println("box is full,size = " + number);
				//阻塞,线程等待,释放锁
				obj.wait();
			}
			
			number++;
			System.out.println("produce success number = " + number);
			//唤醒当前对象的所有等待的线程
			obj.notifyAll();
		}
	}
	
	public void consume() throws InterruptedException {
		//同步
		synchronized (obj) {
			while (number == 0) {
				System.out.println("box is empty,size = " + number);
				//阻塞
				obj.wait();
			}
			
			number--;
			System.out.println("comsume success number = " + number);
			obj.notifyAll();
		}
	}
	
}
