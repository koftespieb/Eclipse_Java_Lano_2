import acm.program.ConsoleProgram;

public class Shuffle extends ConsoleProgram {
	private int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };

	public void run() {
		shuffle(arr);
		for (int i = 0; i < arr.length; i++) {
			println(arr[i]);
		}
	}

	public void shuffle(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			int j = (int) (Math.random() * n);
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}
}
