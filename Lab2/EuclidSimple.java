import acm.program.ConsoleProgram;

public class EuclidSimple extends ConsoleProgram {
	public void run() {
		int a = readInt("Enter No1: ");
		int b = readInt("Enter No2: ");
		println("Greatest Common Divider: " + gcd(a, b));
	}

	private int gcd(int a, int b) {
		while (b != 0) {
			if (a > b) {
				a = a - b;
			} else {
				b = b - a;
			}
		}
		return a;
	}
}
