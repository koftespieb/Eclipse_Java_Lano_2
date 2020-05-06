import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import acm.program.ConsoleProgram;

public class Trains extends ConsoleProgram {
	ArrayList<String> destinationCities = new ArrayList<String>();
	ArrayList<String> cities = new ArrayList<String>();

	public void run() {
		setup();
		println("Available Cities are: " + cities);
		println("Available destinations from Nuernbeg are: " + destinationCities);
	}

	public void setup() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("database.txt"));
			readDatabase(br);
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void readDatabase(BufferedReader br) throws IOException {
		String line;
		while (true) {
			line = br.readLine();
			if (line == null)
				break;
			addCitiesToList(line);

		}
	}

	private void addCitiesToList(String line) {
		StringTokenizer st = new StringTokenizer(line, ">");
		String source = st.nextToken().trim();
		String destination = st.nextToken().trim();
		if (!cities.contains(source)) {
			cities.add(source);
		}
		if (source.equals("Nuernberg")) {
			destinationCities.add(destination);
		}
	}
}
