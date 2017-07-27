
//ЩњВњеп
public class Producer implements Runnable {
	
	private Storage storage;
	private String name;
	
	public Producer(Storage storage, String name) {
		this.name = name;
		this.storage = storage;
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				storage.produce(name);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
