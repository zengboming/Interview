

public class Main {
	public static void main(String[] args) {
		
		Storage storage = new Storage();
		Producer producer1 = new Producer(storage, "������1");
		Producer producer2 = new Producer(storage, "������2");
		Producer producer3 = new Producer(storage, "������3");
		
		Consumer consumer1 = new Consumer(storage, "������1");
		Consumer consumer2 = new Consumer(storage, "������2");
		Consumer consumer3 = new Consumer(storage, "������3");
		
		new Thread(producer1).start();
		new Thread(producer2).start();
		new Thread(producer3).start();
		new Thread(consumer1).start();
		new Thread(consumer2).start();
		new Thread(consumer3).start();
	}
}
