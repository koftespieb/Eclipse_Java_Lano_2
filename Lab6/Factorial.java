import acm.program.ConsoleProgram;

public class Factorial extends ConsoleProgram {
	public void run() {
		while (true) {
			int n = readInt("Enter Number for Factorial calc: ");
			println(n + "! = " + facCalcRecursive(n));
			println(n + "! = " + facCalcIterativ(n));
		}
	}

	private int facCalcRecursive(int n) {
		if (n <= 1) { // base Case
			return 1;
		} else { // recursive case
			return n * facCalcRecursive(n - 1);
		}
	}

	private int facCalcIterativ(int n) {
		int j = 1;
		for (int i = 1; i <= n; i++) {
			j = j * i;
		}
		return j;
	}
}
