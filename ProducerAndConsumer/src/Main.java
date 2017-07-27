

public class Main {
	public static void main(String[] args) {
		
		Storage storage = new Storage();
		Producer producer1 = new Producer(storage, "生产者1");
		Producer producer2 = new Producer(storage, "生产者2");
		Producer producer3 = new Producer(storage, "生产者3");
		
		Consumer consumer1 = new Consumer(storage, "消费者1");
		Consumer consumer2 = new Consumer(storage, "消费者2");
		Consumer consumer3 = new Consumer(storage, "消费者3");
		
		new Thread(producer1).start();
		new Thread(producer2).start();
		new Thread(producer3).start();
		new Thread(consumer1).start();
		new Thread(consumer2).start();
		new Thread(consumer3).start();
	}
}
