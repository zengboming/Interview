import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Storage {
	
	private int number;
	private final int MAX_SIZE = 20;
	private LinkedList<Object> list;
	
	private final Lock lock = new ReentrantLock();
	private final Condition condition = lock.newCondition();
	
	public Storage() {
		list = new LinkedList<>();
		number = 0;
	}
	
	public void produce(String name) {
		lock.lock();
		try {
			while (number == MAX_SIZE) {
				System.out.println(name + ": box is full,size = " + number);
				condition.await();
			}
		
			list.add(new Object());
			number++;
			System.out.println(name + ": produce success number = " + number);
			condition.signalAll();
		} catch (InterruptedException e) {
			System.out.println(e);
		} finally {
			lock.unlock();
		}
	}
	
	public void consume(String name) {
		lock.lock();
		try {
			while (number == 0) {
				System.out.println(name + ": box is empty,size = " + number);
				condition.await();
			}
			
			list.remove();
			number--;
			System.out.println(name + ": comsume success number = " + number);
			condition.signalAll();
		} catch (InterruptedException e) {
			System.out.println(e);
		} finally {
			lock.unlock();
		}
	}
}
