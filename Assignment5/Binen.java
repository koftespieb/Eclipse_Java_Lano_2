import acm.program.ConsoleProgram;
import tree.BinaryNode;
import tree.BinaryTree;

public class Binen extends ConsoleProgram {
	// Fragen
	BinaryNode<String> root = new BinaryNode<String>("Dichte Haarbüschel?");
	BinaryNode<String> frage2 = new BinaryNode<String>("Bürsten an den Beinen?");
	BinaryNode<String> frage3 = new BinaryNode<String>("Beobachtet im Frühjahr (ab März/April)");
	// BinaryNode<String> fruehsommer = new BinaryNode<String>("Beobachtet im
	// Frühsommer (ab main/juni)");
	BinaryNode<String> frage4 = new BinaryNode<String>("8 bis 14 mm?");
	// BinaryNode<String> laenge4bis14 = new BinaryNode<String>("4 bis 14 mm?");
	BinaryNode<String> frage5 = new BinaryNode<String>("7 bis 17 mm, stark behaart?");
	BinaryNode<String> frage6 = new BinaryNode<String>("11 bis 18 mm, deutlich gelb/schwarz?");
	BinaryNode<String> frage7 = new BinaryNode<String>("4 bis 9 mm, heller Flecken?");

	// Binen
	BinaryNode<String> pelzbiene = new BinaryNode<String>("Pelzbine");
	BinaryNode<String> mauerbine = new BinaryNode<String>("Mauerbine");
	BinaryNode<String> scherenbine = new BinaryNode<String>("Scherenbine");
	BinaryNode<String> blattschneiderbine = new BinaryNode<String>("Blattschneiderbine");
	BinaryNode<String> wollbine = new BinaryNode<String>("Wollbine");
	BinaryNode<String> loecherbiene = new BinaryNode<String>("Löcherbine");
	BinaryNode<String> maskenbine = new BinaryNode<String>("Maskenbin");
	BinaryNode<String> solitaerwespe = new BinaryNode<String>("Solitärwespe");

	// make Tree
	BinaryTree<String> desition = new BinaryTree<String>(root);

	public void run() {

		// Setup
		root.setRight(frage2);
		root.setLeft(frage7);
		frage2.setRight(pelzbiene);
		frage2.setLeft(frage3);
		frage3.setRight(frage4);
		frage3.setLeft(frage5);
		frage4.setRight(mauerbine);
		frage4.setLeft(scherenbine);
		frage5.setRight(blattschneiderbine);
		frage5.setLeft(frage6);
		frage6.setRight(wollbine);
		frage6.setLeft(loecherbiene);
		frage7.setRight(maskenbine);
		frage7.setLeft(solitaerwespe);

		checklist();
	}

	private void checklist() {
		println("Mahlzeit zu binen checken:");
		println("Beantworten sie die folgenden fragen mit yes or no:");

		BinaryNode<String> currentNode = (BinaryNode<String>) desition.root();
		while (currentNode.isInternal()) {
			String answer = readLine(currentNode.getElement() + "yes/no");
			if(answer.equals("yes")) {
				currentNode = currentNode.getRight();
			}
			else if ( answer.equals("no")) {
				currentNode = currentNode.getLeft();
			}
		}
		println(currentNode.getElement());
	}

}
