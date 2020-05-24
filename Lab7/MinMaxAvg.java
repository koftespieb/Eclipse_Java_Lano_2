import acm.program.ConsoleProgram;

public class MinMaxAvg extends ConsoleProgram {
	private static final int SIZE = 500;
	private int[] arrayOfInts = { 1, 5, 22, 6, 9, 99, 7, -3, 6 };

	public void init() {
		setSize(SIZE, SIZE);
	}

	public void run() {
		println(getMin(arrayOfInts));

	}

	private int getMin(int[] arrayOfInts) {
		int m = arrayOfInts[0];
		for (int i = 1; i < arrayOfInts.length; i++) {
			if (m > arrayOfInts[i]) {
				m = arrayOfInts[i];
			}
		}
		return m;

	}
}
