import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

import acm.program.ConsoleProgram;

public class TrainsChallange extends ConsoleProgram {
	private HashMap<String, ArrayList<String>> connections = new HashMap<String, ArrayList<String>>();
	private ArrayList<String> cities = new ArrayList<String>();
	private String fileName = "Lab4/fahrplan.txt";

	public void run() {
		setup();
		println("Available cities are: " + cities);
		String start = readLine("Where do you want to start ?");
		String currentLocation = start;
		println("From" + currentLocation + " you can go to " + connections.get(currentLocation));
		while (true) {
			if (cities.contains(currentLocation)) {
				currentLocation = readLine("Where do you want to go next?");
			} else
				println("enter valid city name.");
		}

	}

	private void setup() {
		readDataFromFile(fileName);

	}

	private void readDataFromFile(String file) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while (true) {
				String line = br.readLine();
				if (line == null) {
					break;
				} else {
					fillMapWithData(line);
				}

			}
			br.close();
		} catch (IOException e) {
			println("cant read file");
		}

	}

	private void fillMapWithData(String line) {
		ArrayList<String> cits;
		StringTokenizer st = new StringTokenizer(line, ">");
		String source = st.nextToken().trim();
		String destination = st.nextToken().trim();

		if (!cities.contains(source)) {
			cities.add(source);
			connections.put(source, cits = new ArrayList<String>());
			cits.add(destination);
		} else {
			cits = connections.get(source);
			if (!cits.contains(destination)) {
				cits.add(destination);
			}
		}
		if (!cities.contains(destination)) {
			cities.add(destination);
		}

	}
}
