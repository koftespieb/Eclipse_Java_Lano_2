import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import acm.program.ConsoleProgram;

public class SpellChecker extends ConsoleProgram {
	public void run() {
		Set<String> words = buildIndexFromFile("Lab4/dictionary_en_de.txt");
		while (true) {
			String input = readLine("Enter word to Check: ");
			if (words.contains(input)) {
				println("Spelling is correct.");
			} else
				println("spennling is NOT correct");
		}
	}

	private Set<String> buildIndexFromFile(String fileName) {
		Set<String> words = new HashSet<String>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			while (true) {
				String line = br.readLine();
				if (line == null) {
					break;
				}
				words.add(fillSet(line));
			}
			br.close();
		} catch (IOException e) {
			println("file not found");
		}
		return words;
	}

	private String fillSet(String line) {
		StringTokenizer st = new StringTokenizer(line, "=");
		String word = st.nextToken();
		return word;
	}
}
