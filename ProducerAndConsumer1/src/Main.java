
public class Main {
	public static void main(String[] args) {
		
		Storage storage = new Storage();
		new Thread(new Producer(storage, "������1")).start();
		new Thread(new Producer(storage, "������1")).start();
		new Thread(new Producer(storage, "������1")).start();
		new Thread(new Consumer(storage, "������1")).start();
		new Thread(new Consumer(storage, "������2")).start();
		new Thread(new Consumer(storage, "������3")).start();
		
	}

}