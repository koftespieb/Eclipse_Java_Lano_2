import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import acm.program.ConsoleProgram;

public class GerEngDirectory extends ConsoleProgram {
	Map<String, String> dictionary = new HashMap<String, String>();

	public void run() {
		setup();
		while (true) {
			String input = readLine("Enter Word/Sentence to translate en to ger: ");

			if (dictionary.containsKey(input)) {
				println(input + " translates to: " + dictionary.get(input));
			} else {
				println("no translation available.");
			}
		}

	}

	private void setup() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("Lab4/dictionary_en_de.txt"));
			readFile(br);
			br.close();
		} catch (IOException e) {
			println("file not found");
		}
	}

	private void readFile(BufferedReader br) throws IOException {
		String line;
		while (true) {
			line = br.readLine();
			if (line == null) {
				break;
			}
			addToMap(line);
		}

	}

	private void addToMap(String line) {
		StringTokenizer st = new StringTokenizer(line, "=");
		while (st.hasMoreTokens()) {
			String eng = st.nextToken();
			String ger = st.nextToken();

			dictionary.put(eng, ger);
		}

	}
}
