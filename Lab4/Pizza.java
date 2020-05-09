import java.util.HashSet;
import java.util.Set;

import acm.program.ConsoleProgram;

public class Pizza extends ConsoleProgram {
	Set<String> pizza = new HashSet<String>();
	Set<String> allergic = new HashSet<String>();

	public void run() {
		addToppings();
		addAllergic();
		println(allergic + "\n");
		 pizza.removeAll(allergic);
		// pizza.addAll(allergic);
		//pizza.retainAll(allergic);
		println(pizza + "\n");

		println("Pizza has " + pizza.size() + " toppings.");
		println("The pizza has salami on it: " + pizza.contains("salami"));

		// remove one
		pizza.remove("schinken");
		println("Pizza has " + pizza.size() + " toppings.");

		// list all remaining toppings
		for (String topping : pizza) {
			print(topping + ", ");
		}

	}

	private void addAllergic() {
		allergic.add("anchovies");
		allergic.add("peanuts");

	}

	private void addToppings() {
		pizza.add("tomato");
		pizza.add("salami");
		pizza.add("schinken");
		pizza.add("paprika");
		pizza.add("anchovies");

	}
}
