import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

import acm.program.ConsoleProgram;

public class AdvantureLab extends ConsoleProgram {
	private HashMap<String, ArrayList<String>> roomMap = new HashMap<String, ArrayList<String>>();
	private BufferedReader br;

	public void run() {
		readRoomMapFile();
		for (String from : roomMap.keySet()) {
			ArrayList<String> rooms = roomMap.get(from);
			println(from + ">" + rooms);
		}
	}

	private void readRoomMapFile() {
		try {
			br = new BufferedReader(new FileReader("Lab4/roomMap.txt"));
			while (true) {
				String line = br.readLine();
				if (line == null) {
					break;
				}
				fillMapWithData(line);
			}
			br.close();
		} catch (IOException e) {
			println("file not found");
		}

	}

	private void fillMapWithData(String line) {
		ArrayList<String> rooms;
		StringTokenizer st = new StringTokenizer(line, ">");
		String from = st.nextToken().trim();
		String to = st.nextToken().trim();
		if (roomMap.containsKey(from)) {
			rooms = roomMap.get(from);
		} else {
			rooms = new ArrayList<String>();
		}
		rooms.add(to);
		roomMap.put(from, rooms);
	}
}
