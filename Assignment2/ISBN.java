import acm.program.ConsoleProgram;

public class ISBN extends ConsoleProgram {
	public void run() {
		while (true) {
			String nr = readLine("Enter ISBN number (1530651840): ");

			char[] arr = nr.toCharArray();
			int s = 0;

			for (int i = 0; i < arr.length; i++) {
				if (i == 9) {
					if (arr[i] == 'X')
						s += 10 * 10;
					else {
						int t = arr[i] - '0';
						s += t * (i + 1);
					}
				} else {
					int t = arr[i] - '0';
					s += t * (i + 1);
				}

			}
			if ((int) s % 11 == 0) {
				println("Number is valid.");
			} else {
				println("Number is not valid.");
			}
		}
	}
}
