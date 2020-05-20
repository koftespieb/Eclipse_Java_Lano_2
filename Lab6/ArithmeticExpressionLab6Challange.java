import acm.program.ConsoleProgram;

public class ArithmeticExpressionLab6Challange extends ConsoleProgram {
	public void run() {
		String expression = readLine("Enter expression: ");
		println(evaluate(expression));
	}

	private int evaluate(String expression) {
		// base case
		if (!expression.contains("+") && !expression.contains("+") && !expression.contains("-")
				&& !expression.contains("*") && !expression.contains("/")) {
			return Integer.parseInt(expression.trim());
		}
		// recursive case
		int i = findPlusAndMinus(expression);
		if (i < 0) {
			i = findTimesAndDvide(expression);
		}

		String o1 = expression.substring(0, i);
		String o2 = expression.substring(i + 1, expression.length());

		int result = 0;

		switch (expression.charAt(i)) {
		case '+':
			result = evaluate(o1) + evaluate(o2);
			break;
		case '-':
			result = evaluate(o1) - evaluate(o2);
			break;
		case '*':
			result = evaluate(o1) * evaluate(o2);
			break;
		case '/':
			result = evaluate(o1) / evaluate(o2);
			break;
		}
		return result;
	}

	private int findPlusAndMinus(String expression) {
		int i;
		for (i = expression.length() - 1; i >= 0; i--) {
			if (expression.charAt(i) == '+' || expression.charAt(i) == '-') {
				break;
			}
		}
		return i;

	}

	private int findTimesAndDvide(String expression) {
		int i;
		for (i = expression.length() - 1; i >= 0; i--) {
			if (expression.charAt(i) == '*' || expression.charAt(i) == '/') {
				break;
			}
		}
		return i;
	}
}
