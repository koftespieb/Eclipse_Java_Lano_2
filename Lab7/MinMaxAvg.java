import java.lang.reflect.Array;

import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

public class MinMaxAvg extends ConsoleProgram {
	private static final int SIZE = 500;
	private static final int ARRAY_SIZE = 50000;
	private int[] arrayOfInts = new int[ARRAY_SIZE];
	public RandomGenerator rgen = new RandomGenerator();

	public void init() {
		setSize(SIZE, SIZE);
		setFont("SF Mono-11");
	}

	public void run() {
		for (int i = 0; i < arrayOfInts.length; i++) {
			arrayOfInts[i] = rgen.nextInt(-100000, 100000);
		}

		getMin(arrayOfInts);
		getMax(arrayOfInts);
		getAVG(arrayOfInts);

		bubbleSort(arrayOfInts);

	}

	private void bubbleSort(int[] arrayOfInts) {
		final long start = System.currentTimeMillis();
		for (int j = 0; j < arrayOfInts.length; j++) {
			// Bubble Phase
			for (int i = 0; i < arrayOfInts.length - 1; i++) {
				if (arrayOfInts[i] > arrayOfInts[i + 1]) {
					int bigger = arrayOfInts[i];
					int lower = arrayOfInts[i + 1];
					arrayOfInts[i] = lower;
					arrayOfInts[i + 1] = bigger;
				}
			}
		}
		final long end = System.currentTimeMillis();
		println("Bubble Sort:\nArray with " + arrayOfInts.length + " items sorted\nTime: " + (end - start) + "ms");

	}

	private void getAVG(int[] arrayOfInts) {
		final long start = System.currentTimeMillis();
		double ges = 0;
		for (int i = 0; i < arrayOfInts.length; i++) {
			ges += arrayOfInts[i];
		}
		double avg = ges / arrayOfInts.length;
		final long end = System.currentTimeMillis();

		println("AVG: " + avg + "\nFound in unsorted Array with " + arrayOfInts.length + " items\nTime:" + (end - start)
				+ " Ms\n");
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
		println("MAX: " + max + "\nFound in unsorted Array with " + arrayOfInts.length + " items\nTime:" + (end - start)
				+ " Ms\n");
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
		println("MIN: " + min + "\nFound in unsorted Array with " + arrayOfInts.length + " items\nTime:" + (end - start)
				+ " Ms\n");

	}

}
