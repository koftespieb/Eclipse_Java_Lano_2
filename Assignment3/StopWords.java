import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import acm.program.ConsoleProgram;

public class StopWords extends ConsoleProgram {
	Set<String> stopWords = new HashSet<String>();

	public void run() {
		fillStopWordSet("StopWords.txt");
		println("Amount Stop Words: " + stopWords.size());
		String text = readLine("Enter Text: ");
		println(testInputString(text));
	}

	private String testInputString(String text) {
		String output = "";
		StringTokenizer st = new StringTokenizer(text);
		while (st.hasMoreTokens()) {
			String word = st.nextToken();
			if (!stopWords.contains(word)) {
				output += word +" ";
			}
		}
		return output;
	}

	private void fillStopWordSet(String file) {
		String line;
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while (true) {
				line = br.readLine();
				if (line == null) {
					break;
				}
				StringTokenizer toki = new StringTokenizer(line, " ");
				while (toki.hasMoreTokens()) {
					String word = toki.nextToken();
					stopWords.add(word.toLowerCase());
				}
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
