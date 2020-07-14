import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import acm.program.ConsoleProgram;

public class AutoComplete extends ConsoleProgram {
	SimpleTrie trie = new SimpleTrie();

	public void run() {
		println("Auto Complete!\n");
		loadDictionary("Text/dictionary_en_de.txt");
		while (true) {
			String suggestion = "hi there i am a very long string";
			String input = readLine();
			if (input.length() >= 3) {
				for (String s : trie.nodesWithPrefix(input)) {
					if (s.length() < suggestion.length()) {
						suggestion = s;
						println(s);
					}
				}
			} else {
				println("enter at least three chars");
			}
		}

	}

	private void loadDictionary(String fileName) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			while (true) {
				String line = br.readLine();
				if (line == null) {
					break;
				}
				StringTokenizer toki = new StringTokenizer(line, " ");
				while (toki.hasMoreTokens()) {
					trie.add(toki.nextToken());
				}
			}
			br.close();
			println("file loaded\n");
		} catch (IOException e) {
			e.printStackTrace();
			println("file not found");
		}

	}
}
