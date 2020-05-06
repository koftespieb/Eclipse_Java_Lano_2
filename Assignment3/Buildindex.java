import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

import acm.program.ConsoleProgram;

public class Buildindex extends ConsoleProgram {
	private Map<String, Integer> words = new TreeMap<String, Integer>();
	private Set<String> stopWords = new HashSet<String>();
	int total_words;

	public void run() {
		total_words = 0;
		fillStopWordSet("StopWords.txt");
		setup();
		println("Total Words: " + total_words);
		for (String word : words.keySet()) {
			println(word + ", " + words.get(word));
		}
	}

	public void setup() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("TomSawyer.txt"));
			readBook(br);
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void readBook(BufferedReader br) throws IOException {
		String line;
		while (true) {
			line = br.readLine();
			if (line == null) {
				break;
			}
			cutLine(line);
		}

	}

	private void cutLine(String line) {
		StringTokenizer st = new StringTokenizer(line, "[]\"{}',;:.!?()-/ \t\n\r\f");
		while (st.hasMoreTokens()) {
			String word = st.nextToken();
			addWordToHashMap(word.toLowerCase());
		}
	}

	private void addWordToHashMap(String word) {
		// Important Part rather word will be added
		if (word != null && word.length() >= 8 && filter(word) && !stopWords.contains(word)) {
			if (words.containsKey(word)) {
				int count = words.get(word);
				words.put(word, ++count);
			} else {
				words.put(word, 1);
				++total_words;
			}
		}

	}

	private boolean filter(String word) {
		char[] cArr = word.toCharArray();
		if (cArr[cArr.length - 1] == 'y' && cArr[cArr.length - 2] == 'l') {
			return false;
		} else if (cArr[cArr.length - 1] == 'd' && cArr[cArr.length - 2] == 'e') {
			return false;
		} else if (cArr[cArr.length - 1] == 'l' && cArr[cArr.length - 2] == 'a' && cArr[cArr.length - 3] == 'i') {
			return false;
		} else if (cArr[cArr.length - 1] == 'e' && cArr[cArr.length - 2] == 'v' && cArr[cArr.length - 3] == 'i') {
			return false;
		} else if (cArr[cArr.length - 1] == 's' && cArr[cArr.length - 2] == 'u' && cArr[cArr.length - 3] == 'o') {
			return false;
		}

		return true;
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