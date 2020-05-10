import java.util.HashSet;
import java.util.Set;

import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

public class Lottery extends ConsoleProgram {
	RandomGenerator rgen = new RandomGenerator();

	public void run() {
		for (int s : generateLotteryNumbers()) {
			print(s + ", ");
		}
		generateLotteryNumbersWithArray();

	}

	private int[] generateLotteryNumbersWithArray() {
		int[] lottery = new int[10];
		for (int i = 0; i <= 6; i++) {
			int s = rgen.nextInt(1, 49);
			lottery[i] = s;
			println (lottery[i]);
		}

		return lottery;

	}

	private Set<Integer> generateLotteryNumbers() {
		Set<Integer> lottery = new HashSet<Integer>();
		while (lottery.size() < 6) {
			int i = rgen.nextInt(1, 49);
			lottery.add(i);
		}

		return lottery;

	}
}
