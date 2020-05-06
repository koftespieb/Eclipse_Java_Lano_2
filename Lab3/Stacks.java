import java.util.Stack;

import acm.program.ConsoleProgram;

public class Stacks extends ConsoleProgram {
	Stack<String> cities = new Stack<String>();

	public void run() {
		cities.push("Nürnberg");
		cities.push("München");
		cities.push("Stuttgart");
		cities.push("Hamburg");
		cities.push("Berlin");

		println("There is  total of " + cities.size() + "cities on the stack");
		println("topmost city: "+ cities.pop());
		
		println("traveling way back the way we came: ");
		for (int i = 0; i <= 3; i++) {
			println(cities.size());
			println(cities.pop());
			
		}
		println("There is  total of " + cities.size() + " cities on the stack");
	}
}
