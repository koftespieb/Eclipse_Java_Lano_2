import acm.program.ConsoleProgram;

public class PalindromeLab6 extends ConsoleProgram {
	public void run() {
		while (true) {
			String text = readLine("Enter Text: ");
			println(isPalindrome(text.toLowerCase()));
		}
	}

	private boolean isPalindrome(String text) {
		if (text.length() <= 1) { // base case
			return true;
		} else { // recursive case
			if (text.charAt(0) == text.charAt(text.length() - 1)) {
				return isPalindrome(text.substring(1, text.length() - 1));
			} else {
				return false;
			}
		}
	}
}
