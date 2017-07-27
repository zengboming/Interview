
//ЩњВњеп
public class Producer implements Runnable {
	
	private Storage storage;
	private String name;
	
	public Producer(Storage storage, String name) {
		this.storage = storage;
		this.name = name;
	}

	@Override
	public void run() {
		while (true) {
			try {
				storage.produce();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
