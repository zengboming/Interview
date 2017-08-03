
public class Main {
	public static void main(String[] args) {
		
		Storage storage = new Storage();
		new Thread(new Producer(storage, "生产者1")).start();
		new Thread(new Producer(storage, "生产者1")).start();
		new Thread(new Producer(storage, "生产者1")).start();
		new Thread(new Consumer(storage, "消费者1")).start();
		new Thread(new Consumer(storage, "消费者2")).start();
		new Thread(new Consumer(storage, "消费者3")).start();
		
	}

}