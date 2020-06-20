import java.util.Arrays;

import acm.program.ConsoleProgram;

public class Sorting extends ConsoleProgram {
	private int[] arr = { 5, 55, 2, 7, 45, 3, 1, 8, 23, 12 };
	
	public void run() {
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			println(arr[i]);
		}
	}
}
