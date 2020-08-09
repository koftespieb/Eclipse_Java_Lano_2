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
			br.close();
		} catch (IOException e) {
			println("file not found");
		}

		String temp = quote(art,'\\');
		String temp2 = quote(temp,'\"');
		//String temp3 = quote(temp2,'\'');
		
		println(temp2);
		safeToFile(temp2);

	}

	String quote(String s, char c) {
		StringBuffer str = new StringBuffer(s);
		String temp = "";
		int count = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == c) {
				str.insert(i + count, c);
				count++;
			}
		}
		println("Added "+count+" "+c);
		temp = str.toString();
		return temp;
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
