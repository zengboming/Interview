
//Ïû·ÑÕß
public class Consumer implements Runnable {
	
	private Storage storage;
	private String name;
	
	public Consumer(Storage storage, String name) {
		this.name = name;
		this.storage = storage;
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				storage.consume(name);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
