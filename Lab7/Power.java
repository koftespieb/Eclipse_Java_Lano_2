import acm.program.ConsoleProgram;

public class Power extends ConsoleProgram {
	private static final int SIZE = 500;
	public long[] powerLookupTable;

	public void init() {
		setSize(SIZE, SIZE);
		setFont("SF Mono-11");
	}

	public void run() {
		int base = 2;
		int power = readInt("Enter Power(int max 20): ");

		testDyniamicProgramingTime(base, power);
		testTimeIteration(base, power);
		testTimePowerRecursion(base, power);

	}

	// divide and conqure
	

	// dynamic Programing
	private void testDyniamicProgramingTime(int base, int power) {
		long start = System.currentTimeMillis();
		initPowerLookupTable(base);
		println("\nDynamicPrograming: " + powerDinamcProgramming(power));
		long end = System.currentTimeMillis();
		println("Time: " + (end - start) + "Ms");

	}

	private void initPowerLookupTable(int base) {
		powerLookupTable = new long[20 + 1];
		for (int i = 1; i < powerLookupTable.length; i++) {
			powerLookupTable[i] = powerIteration(base, i);
		}

	}

	private long powerDinamcProgramming(int n) {
		return powerLookupTable[n];
	}

	// recursion
	private void testTimePowerRecursion(int base, int power) {
		long start = System.currentTimeMillis();
		println("\nRecursion: " + powerRE(base, power));
		long end = System.currentTimeMillis();
		println("Time: " + (end - start) + "Ms");

	}

	private long powerRE(int base, int power) {
		// base case
		if (power == 0) {
			return 1;
		}
		// recursive case
		return base * powerRE(base, power - 1);

	}

	// iteration
	private void testTimeIteration(int base, int power) {
		long start = System.currentTimeMillis();
		println("\nIteration: " + powerIteration(base, power));
		long end = System.currentTimeMillis();
		println("Time: " + (end - start) + "Ms");

	}

	private long powerIteration(int base, int power) {
		long m = 1;
		for (int i = 0; i < power; i++) {
			m = m * base;
		}
		return m;
	}
}
