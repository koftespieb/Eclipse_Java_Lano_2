import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import acm.graphics.GRect;
import acm.io.IODialog;
import acm.program.GraphicsProgram;

public class T7 extends GraphicsProgram {

	private final int BLOCK_SIZE = 20;
	private File[] files;
	private List<String> list = new ArrayList<String>();
	private String s3 = "";
	private String s4 = "";

	// this program...
	// author: Felix St�ckl

	public void run() {
		setSize(400, 400);

		listDocuments();
		readAndAddFiles();

		IODialog dialog = new IODialog();
		String s1 = "files/" + dialog.readLine("Enter first string: ");
		String s2 = "files/" + dialog.readLine("Enter second string: ");

		for (int i = 0; i < files.length; i++) {
			if (s1.equals(files[i].toString())) {
				s3 += list.get(i);
			} else if (s2.equals(files[i].toString())) {
				s4 += list.get(i);
			}
		}
		println(s3);
		println("\nUMBRUCH\n");
		println(s4);
		println(files.length);

	}

	// removes all white spaces (" ", "\n", "\t") from a string
	// method code by Ralph Lano
	private String removeWhiteSpace(String s) {
		s = s.replaceAll(" ", "");
		s = s.replaceAll("\n", "");
		s = s.replaceAll("\t", "");
		return s;
	}

	// compares two strings and prints rectangles to show the similarity
	// method code by Ralph Lano
	private void showSimilarity(String s1, String s2) {
		for (int i = 0; i < s1.length(); i++) {
			for (int j = 0; j < s2.length(); j++) {
				if (s1.charAt(i) == s2.charAt(j)) {
					GRect pixel = new GRect(BLOCK_SIZE, BLOCK_SIZE);
					pixel.setFilled(true);
					add(pixel, i * BLOCK_SIZE, j * BLOCK_SIZE);
				}
			}
		}
	}

	// compares two strings and returns the largest common substring
	// method code by Ralph Lano
	private String findLargestCommonSubstring(String S, String T) {
		int[][] L = new int[S.length()][T.length()];
		int z = 0;
		int endIndex = 0;
		for (int i = 0; i < S.length(); i++) {
			for (int j = 0; j < T.length(); j++) {
				if (S.charAt(i) == T.charAt(j)) {
					if (i == 0 || j == 0) {
						L[i][j] = 1;
					} else {
						L[i][j] = L[i - 1][j - 1] + 1;
					}
					if (L[i][j] > z) {
						z = L[i][j];
						endIndex = i;
					}
				} else {
					L[i][j] = 0;
				}
			}
		}
		if (z > 0) {
			return S.substring(endIndex - z + 1, endIndex + 1);
		}
		return null;
	}

	// lists documents from directory "files"
	private void listDocuments() {
		File dir = new File("files");
		files = dir.listFiles();
	}

	// reads files from directory and adds them to a list
	private void readAndAddFiles() {
		for (int i = 0; i < files.length; i++) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(files[i]));
				String oneFile = "";

				// as long as there are more files, read them and put set content of one file as
				// string, then add to the list
				while (true) {
					String line = br.readLine();
					if (line == null)
						break;
					oneFile += line + "\n";
				}
				list.add(oneFile);
				br.close();
			} catch (Exception e) {
				println("Something went wrong!");
			}
		}
	}
}