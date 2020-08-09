import java.io.BufferedReader;
import java.io.FileReader;

import acm.graphics.GRect;
import acm.io.IODialog;
import acm.program.GraphicsProgram;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * 
 * DotPlot
 * 
 * Store a whole document in a trie data structure keeping the position
 * information of each string. We then try to reconstruct the whole document.
 * 
 * @see Longest common substring problem,
 *      https://en.wikipedia.org/wiki/Longest_common_substring_problem
 * 
 * @see http://www.VariationenZumThema.de/
 * @author Ralph P. Lano
 */
public class DotPlot extends GraphicsProgram {
	private final int BLOCK_SIZE = 3;

	public void init() {
		setSize(400, 400 + 44);
	}

	public void run() {
		IODialog dialog = new IODialog();
		String s1 = dialog.readLine("Enter first string:");
		String s2 = dialog.readLine("Enter second string:");
		// s1 = readFromFile("AfricanElephant.txt");
		// s2 = readFromFile("AsiaticElephant.txt");
		// s2 = readFromFile("Mammoth.txt");
		showSimilarity(s1, s2);
		println(findLargestCommonSubstring(s1, s2));
	}

	private void showSimilarity(String s1, String s2) {
		for (int i = 0; i < s1.length(); i++) {
			for (int j = 0; j < s2.length(); j++) {
				if (s1.charAt(i) == s2.charAt(j)) {
					for (int test = 0; test <= 5; test++) {
						if (s1.charAt(i + test) == s2.charAt(j + test) && (i + test) < s1.length()
								&& (j + test) < s2.length()) {

							println("s1(" + (i + test) + ") = " + s1.charAt(i + test) + " s2(" + (j + test) + ") = "
									+ s2.charAt(j + test));
						}
					}

				}
			}
		}
	}
	// Test Ausgaben
	// println("s1(" + i + ") = " + s1.charAt(i) + " s2(" + j + ") = " +
	// s2.charAt(j));
	// println("s1(" + (i + i2) + ") = " + s1.charAt(i + i2) + " s2(" + (j + i2) +
	// ") = "
	// + s2.charAt(j + i2)+" i = "+i+" j = "+j);

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
			// not sure if the endIndex+1 (i.e. the "+1") is o.k.
			return S.substring(endIndex - z + 1, endIndex + 1);
		}
		return null;
	}

	private String readFromFile(String fileName) {
		String dna = "";
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			dna = br.readLine();
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dna;
	}
}
