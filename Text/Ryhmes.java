import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

import acm.program.ConsoleProgram;

public class Ryhmes extends ConsoleProgram {

	private SimpleTrie trie = new SimpleTrie();

	public void run() {
		loadLexiconFromFile("Text/dictionary_en_de.txt");
		String word = readLine("Enter Word: ");
		for (String s : trie.nodesWithPrefix(revString(word))) {
			println(revString(s));
		}
	}

	private void loadLexiconFromFile(String fileName) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			StringTokenizer st;
			while (true) {
				String line = br.readLine();
				if(line==null) {
					break;
				}
				st = new StringTokenizer(line, " ");
				while (st.hasMoreTokens()) {
					trie.add(revString(st.nextToken()));
				}
			}
			br.close();

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	private String revString(String s) {
		String word = s.toLowerCase();
		String revWord = "";
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < word.length(); i++) {
			stack.push(word.charAt(i));
		}
		for (int i = 0; i < word.length(); i++) {
			char c = stack.pop();
			revWord += c;
		}
		return revWord;
	}
}