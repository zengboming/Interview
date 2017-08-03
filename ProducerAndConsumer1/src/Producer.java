//ЩњВњеп
public class Producer  implements Runnable{
	
	private Storage storage;
	private String name;
	
	public Producer(Storage storage, String name) {
		this.name = name;
		this.storage = storage;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			storage.produce(name);
		}
	}
	
}