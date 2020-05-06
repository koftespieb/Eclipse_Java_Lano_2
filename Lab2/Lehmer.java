import acm.program.ConsoleProgram;

public class Lehmer extends ConsoleProgram {
	int a = 13;
	int c = 1;
	int m = 16;
	int x = 3;

	public void run() {
		for (int i = 0; i < 20; i++) {
			println(x + ",");
			x = (a * x + c) % m;
		}
	}
}
