//Ïû·ÑÕß
public class Consumer implements Runnable{
	
	private Storage storage;
	private String name;
	
	public Consumer(Storage storage, String name) {
		this.name = name;
		this.storage = storage;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			storage.consume(name);
		}
	}
	

}
