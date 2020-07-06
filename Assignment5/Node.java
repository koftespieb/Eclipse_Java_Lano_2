import java.util.ArrayList;
import java.util.List;

public class Node {
	private Node parent;
	private String element;
	private List<Node> child;

	public Node(String e) {
		element = e;
		child = new ArrayList<Node>();
	}
	public static void main(String[] args) {
		
	}

	private void addChild(Node node) {
		child.add(node);
		node.parent = this;
	}

	private boolean isRoot() {
		if (parent == null) {
			return true;
		}
		return false;
	}

	private List<Node> getChildren() {
		return child;
	}

	private void removeChild(Node node) {
		child.remove(node);
	}

}
