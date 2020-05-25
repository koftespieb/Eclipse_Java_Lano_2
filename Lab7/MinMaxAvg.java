import java.lang.reflect.Array;

import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

public class MinMaxAvg extends ConsoleProgram {
	private static final int SIZE = 500;
	private static final int ARRAY_SIZE = 10000000;
	private int[] arrayOfInts = new int[ARRAY_SIZE];
	public RandomGenerator rgen = new RandomGenerator();

	public void init() {
		setSize(SIZE, SIZE);
	}

	public void run() {
		for (int i = 0; i < arrayOfInts.length; i++) {
			arrayOfInts[i] = rgen.nextInt(-1000000, 1000000);
		}

		getMin(arrayOfInts);
		getMax(arrayOfInts);
		getAVG(arrayOfInts);

	}

	private void getAVG(int[] arrayOfInts) {
		final long start = System.currentTimeMillis();
		double ges = 0;
		for (int i = 0; i < arrayOfInts.length; i++) {
			ges += arrayOfInts[i];
		}
		double avg = ges / arrayOfInts.length;
		final long end = System.currentTimeMillis();

		println("AVG: " + avg + "		Finisehd in: " + (end - start) + " Ms\n");
	}

	private void getMax(int[] arrayOfInts) {
		final long start = System.currentTimeMillis();
		int max = arrayOfInts[0];
		for (int i = 1; i < arrayOfInts.length; i++) {
			if (max < arrayOfInts[i]) {
				max = arrayOfInts[i];
			}
		}
		final long end = System.currentTimeMillis();
		println("MAX: " + max + "		Finisehd in: " + (end - start) + " Ms\n");
	}

	private void getMin(int[] arrayOfInts) {
		final long start = System.currentTimeMillis();
		int min = arrayOfInts[0];
		for (int i = 1; i < arrayOfInts.length; i++) {
			if (min > arrayOfInts[i]) {
				min = arrayOfInts[i];
			}
		}
		final long end = System.currentTimeMillis();
		println("MIN: " + min + "		Finisehd in: " + (end - start) + " Ms\n");

	}

}
