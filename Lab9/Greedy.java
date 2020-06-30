import acm.program.ConsoleProgram;

public class Greedy extends ConsoleProgram {
	int[] coinValue = { 200, 100, 50, 20, 10, 5 };
	int[] coinAmount = { 3, 2, 1, 2, 15, 4 };
	int price = 115;

	public void run() {
		println("Price for one Coffee: " + price);
		int back = readInt("Enter Ammount in Cent: ") - price;
		giveChange(back);
		//kleine änderung amkmoko

	}

	private void giveChange(int back) {
		for (int i = 0; i < coinValue.length; i++) {
			// check if coins available
			while ((coinAmount[i] > 0) && (back - coinValue[i] >= 0)) {
				back = back - coinValue[i];
				coinAmount[i]--;
				print(coinValue[i] + ", ");
			}
		}

	}
}
