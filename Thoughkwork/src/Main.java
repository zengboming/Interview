import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		//Scanner in = new Scanner(System.in);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		Management management = new Management();
		String string;
		while ((string = in.readLine()) != null) {
			//String string = in.nextLine();
			management.input(string);
		}
	}
}
