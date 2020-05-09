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
		try {
			BufferedReader br = new BufferedReader(new FileReader("Lab4/dictionary_en_de.txt"));
			readFile(br);
			br.close();
		} catch (IOException e) {
			println("file not found");
		}
		for (String word : dictionary.keySet()) {
			println(word + dictionary.get(word));
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
			String ger = st.nextToken();
			String eng = st.nextToken();
			dictionary.put(ger, eng);
		}

	}
}
