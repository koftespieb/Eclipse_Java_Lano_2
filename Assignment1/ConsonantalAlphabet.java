import java.util.StringTokenizer;

import acm.program.ConsoleProgram;
//Autor: Nico Mayer

public class ConsonantalAlphabet extends ConsoleProgram {
	//DummerWixxer
	public void run() {
		while (true) {
			String text = readLine("Enter text: ");
			StringTokenizer toki = new StringTokenizer(text);
			while (toki.hasMoreTokens()) {
				String word = toki.nextToken();
				print(translate(word) + " ");
			}
			println();
		}
	}

	private String translate(String word) {
		String translated = "";
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (!isVowel(c)) {
				translated = translated + c;
			}
		}
		return translated;
	}

	private boolean isVowel(char c) {
		if ("aeiouAEIOU".indexOf(c) > -1) {
			return true;
		}
		return false;
	}
}
