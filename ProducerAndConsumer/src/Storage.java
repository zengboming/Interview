import java.util.LinkedList;

//仓库类Storage实现缓冲区
public class Storage {
	
	private int number;
	private final int MAX_NUM = 10;
	private LinkedList<Object> list1;
	
	public Storage() {
		number = 0;
		list1 = new LinkedList<>();
	}
	
	public void produce(String name) throws InterruptedException{
		synchronized (list1) {
			while (number == MAX_NUM) {
				System.out.println(name + ":box is full,size = " + number);
				list1.wait();
			}
			
			list1.add(new Object());
			number++;
			System.out.println(name + ":produce success number = " + number);
			list1.notifyAll();
		}
	}
	
	public void consume(String name) throws InterruptedException {
		synchronized (list1) {
			while (number == 0) {
				System.out.println(name + ":box is empty,size = " + number);
				list1.wait();
			}
			
			list1.remove();
			number--;
			System.out.println(name + ":comsume success number = " + number);
			list1.notifyAll();
		}
	}
	
}
