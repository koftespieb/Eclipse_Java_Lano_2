import java.util.Stack;

import acm.program.ConsoleProgram;

public class Palindrome extends ConsoleProgram {
	public void run() {
		String text = readLine("Enter Text: ");
		if (isPalindrome(text)) {
			println("Is a Palindrome.");
		} else {
			println("Is not a Palindrome");
		}
	}

	private boolean isPalindrome(String text) {
		String s = "";
		Stack<Character> stk = new Stack<Character>();
		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			stk.push(c);
		}
		for (int i = 0; i < text.length(); i++) {
			s += stk.pop();
		}

		if (text.equals(s)) {
			return true;
		} else {
			return false;
		}

	}
}
