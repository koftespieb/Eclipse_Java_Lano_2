import acm.program.ConsoleProgram;

public class Power extends ConsoleProgram {
	private static final int SIZE = 500;

	public void init() {
		setSize(SIZE, SIZE);
		setFont("SF Mono-11");
	}

	public void run() {
		int base = readInt("Enter Base(int): ");
		int power = readInt("Enter Power(int): ");

		powerIteration(base, power);
		testTimePowerRecursion(base, power);

	}

	private void testTimePowerRecursion(int base, int power) {
		long start = System.currentTimeMillis();
		println("\nRecursion: " + powerRecursion(base, power));
		long end = System.currentTimeMillis();
		println("Time: " + (end - start)+"Ms");

	}

	private long powerRecursion(int base, int power) {
		// base case
		if (power == 0) {
			return 1;
		}
		// recursive case
		return base * powerRecursion(base, power - 1);

	}

	private void powerIteration(int base, int power) {
		long start = System.currentTimeMillis();
		long m = 1;
		for (int i = 0; i < power; i++) {
			m = m * base;
		}
		long end = System.currentTimeMillis();
		println("\nIteration: " + m + "\nTime: " + (end - start)+"Ms");
	}
}
