import acm.program.ConsoleProgram;
import tree.AbstractNode;
import tree.OrderedNode;
import tree.OrderedTree;
import tree.VisitorInterface;

public class Uni extends ConsoleProgram {
	public void run() {
		OrderedNode<String> pres = new OrderedNode<String>("President");
		OrderedNode<String> dean_A = new OrderedNode<String>("dean_A");
		OrderedNode<String> dean_B = new OrderedNode<String>("dean_B");
		OrderedNode<String> prof_A = new OrderedNode<String>("prof_A");

		pres.addChild(dean_A);
		pres.addChild(dean_B);
		dean_A.addChild(prof_A);

		OrderedTree<String> uni = new OrderedTree<String>(pres);
		println("Nr of employees: " + uni.size());
		println("Nr of Hirarchy levels: " + uni.height());
		// println("List all employees: " + uni.elements());
		println("Boss of prof A: " + prof_A.getParent().getElement());
		println("Employees of President: " + pres.getChildren());
		println("Has pres a Boss? " + pres.getParent());
		println("");

		uni.levelOrder(new VisitorInterface<String>() {
			public void visit(AbstractNode<?> node) {
				print(node.getElement() + ", ");
			}
		});
	}
}
