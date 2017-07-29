import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class Storage {
	
	public final int MAX_NUM = 5;
	private int number = 0;
	
	//锁
	private final Lock lock = new ReentrantLock();
	//条件变量
	private final Condition condition = lock.newCondition();
	//private final Condition empty = lock.newCondition();
	
	public void produce() {
		lock.lock();
		try {
			while(number == MAX_NUM) {
				System.out.println("box is full,size = " + number);
				condition.await();
			}
			
			number++;
			System.out.println("produce success number = " + number);
			condition.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		
	}
	
	public void consume() {
		lock.lock();
		
		try {
			while (number == 0) {
				System.out.println("box is empty,size = " + number);
				condition.await();
			}
			
			number--;
			System.out.println("consume success number = " + number);
			condition.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
}
