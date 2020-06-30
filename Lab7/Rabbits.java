import acm.program.ConsoleProgram;

public class Rabbits extends ConsoleProgram {
	long z1 = 0;
	long z2 = 1;
	long result = 0;

	public void run() {
		int end = readInt("Enter int: ");
		for (int i = 0; i < end; i++) {
			result = z1 + z2;
			z2 = z1;
			z1 = result;
			println(result);

		}
	}
}
