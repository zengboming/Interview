//������
public class Consumer implements Runnable {
	
	private Storage storage;
	private String name;
	
	public Consumer(Storage storage, String name) {
		this.storage = storage;
		this.name = name;
	}

	@Override
	public void run() {
		while (true) {
			storage.consume();
		}
		
	} 
}
