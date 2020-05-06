import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import acm.program.ConsoleProgram;

public class Lists extends ConsoleProgram {
	List<String> cities = new LinkedList<String>();

	public void run() {
		// add cities
		cities.add("Nürnberg");
		cities.add("München");
		cities.add("Stuttgart");
		cities.add("Hamburg");
		cities.add("Berlin");
		// print third city
		println("Third City is: " + cities.get(2));
		// remove third city
		cities.remove(2);
		// replace the second city by another city
		cities.set(1, "NewYork");
		// search for Stuttgrat
		println("Berlin in on Pos: " + cities.indexOf("Berlin"));
		// name all remeaning cities
		println("All remeaning Cities: ");
		for (int i = 0; i < cities.size(); i++) {
			print(cities.get(i) + ", ");
		}
	}

}
