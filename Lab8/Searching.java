import acm.program.ConsoleProgram;

public class Searching extends ConsoleProgram {
	private int[] arr = { 44, 88, 17, 32, 97, 65, 28, 82, 29, 76, 54, 80 };
	private int[] arrSorted = { 17, 28, 29, 32, 44, 54, 65, 76, 80, 82, 88, 97 };

	public void run() {
		int key = readInt("Enter Int: ");
		println("An Stelle: " + sequentialSearch(key, arr));
		println("\nBinary Search: " + binarySearch(key, arrSorted, 0, arrSorted.length));
	}
	// geht nicht
	private int binarySearch(int key, int[] arrSorted, int start, int stop) {
		// base case
		if (start > stop) {
			return -1;
		}
		// recursive case
		int m = (start + stop) / 2;
		if (arr[m] == key) {
			return m;
		}
		else if (key < arr[m]) {
			return binarySearch(key, arrSorted, start, m - 1);
		}
		else{
			return binarySearch(key, arrSorted, m + 1, stop);
		}

	}

	private int sequentialSearch(int key, int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == key)
				return i;
		}
		return -1;

	}
}
