import java.util.Stack;
import java.util.StringTokenizer;

import acm.program.ConsoleProgram;

public class ArithmeticExpression extends ConsoleProgram {
	public void run() {
		String infix = readLine("Enter Arithmetic expression: ");
		println("Postfix of this expression: " + infixToPostfix(infix));
		println("Ergebnis: " + evaluatePostfix(infixToPostfix(infix)));
	}

	private int evaluatePostfix(String postfix) {
		Stack<Integer> stk = new Stack<Integer>();
		StringTokenizer toki = new StringTokenizer(postfix, "+-*/ ", true);
		while (toki.hasMoreTokens()) {
			String token = toki.nextToken().trim();
			if (token.length() == 0) {
				// do nothing
			} else if ("+-/*".contains(token)) {
				int y = stk.pop();
				int x = stk.pop();

				if (token.equalsIgnoreCase("+")) {
					stk.push(x + y);
				} else if (token.equalsIgnoreCase("-")) {
					stk.push(x - y);
				} else if (token.equalsIgnoreCase("*")) {
					stk.push(x * y);
				} else if (token.equalsIgnoreCase("/")) {
					stk.push(x / y);
				}

			} else {
				stk.push(Integer.parseInt(token));
			}
		}
		return stk.pop();
	}

	private String infixToPostfix(String infix) {
		String out = "";
		Stack<String> stk = new Stack<String>();
		StringTokenizer toki = new StringTokenizer(infix, "()+-*/", true);

		while (toki.hasMoreTokens()) {
			String token = toki.nextToken().trim();
			if (token.length() == 0) {
				// do nothing
			} else if ("+-/*".contains(token)) {
				stk.push(token);
			} else if (")".contains(token)) {
				out += stk.pop() + " ";
			} else if ("(".contains(token)) {
				// do nothing
			} else {
				out += token + " ";
			}

		}
		return out;
	}
}
