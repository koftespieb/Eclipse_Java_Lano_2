import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import acm.program.ConsoleProgram;

public class Converter extends ConsoleProgram {

	public void run() {
		String art = "";
		String output = "";
		int backCount = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader("ASCIIArtConv /art.txt"));
			while (true) {
				String line = br.readLine();
				if (line == null) {
					break;
				}
				println(line);
				art += line + "\n";
			}
			println(art.length());
			StringBuffer str = new StringBuffer(art);
			
			
			for (int i = 0; i < art.length(); i++) {
				if (art.charAt(i) == '\\') {
					str.insert(i+backCount, '\\');
					backCount++;
				}
			}
			
			output = str.toString();
			println(backCount);
			br.close();

		} catch (IOException e) {
			println("file not found");
		}
		safeToFile(output);

	}

	void safeToFile(String art) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("ASCIIArtConv /output.txt"));
			writer.write(art);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
