import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

import acm.program.ConsoleProgram;

public class Faust extends ConsoleProgram {
	// private SimpleTrie trie = new SimpleTrie();
	private List<String> text = new ArrayList<String>();
	Trie<Integer> trie = new Trie<Integer>();

	public void run() {
		loadFile("Text/Faust.txt");
		String searchWords = readLine("Enter two words: ");
		String[] words = searchWords.toLowerCase().split(" ");
		Set<Integer> lineNrs = trie.get(words[0].trim() + words[1].trim());
		println("The words occur in line(s): " + lineNrs);

		for (int nr : lineNrs) {
			println(text.get(nr - 2) + "\n");
			println(text.get(nr - 1) + "\n");
			println(text.get(nr - 0) + "\n");
		}
	}

	private void loadFile(String fileName) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			int lineNr = 1;
			while (true) {
				String line = br.readLine();
				if (line == null) {
					break;
				}
				text.add(line);
				StringTokenizer toki = new StringTokenizer(line, " ,.:;'!?-()\"");
				String prevToken = "";
				while (toki.hasMoreTokens()) {
					String token = toki.nextToken().toLowerCase();
					if (prevToken.length() > 0) {
						trie.add(prevToken + "" + token + "", lineNr);
					}
					prevToken = token;
				}
				lineNr++;

			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
			println("file not found");
		}
	}

}
