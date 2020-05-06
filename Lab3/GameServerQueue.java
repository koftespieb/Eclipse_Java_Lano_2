import java.util.LinkedList;
import java.util.Queue;

import acm.program.ConsoleProgram;

public class GameServerQueue extends ConsoleProgram {
	private final int NR_OF_PLAYERS_PER_TEAM = 2;
	private Queue<String> playerQ = new LinkedList<String>();

	public void run() {
		fillPlayerQ();
		while (!playerQ.isEmpty()) {
			removePlayers();
		}
	}

	private void removePlayers() {
		if (playerQ.size() >= NR_OF_PLAYERS_PER_TEAM) {
			for (int i = 0; i < NR_OF_PLAYERS_PER_TEAM; i++) {
				print(playerQ.remove() + ", ");
			}
			println();
		}

	}

	private void fillPlayerQ() {
		while (true) {
			String name = readLine("Enter Player Name: ");
			if (name.length() == 0) {
				break;
			}
			playerQ.add(name);
		}
		println();

	}
}
