import java.util.Stack;

import acm.program.ConsoleProgram;

public class Parentheses extends ConsoleProgram {
	public void run() {
		println("(()): " + doParanthesesMatch("(())"));
		println("))): " + doParanthesesMatch(")))"));
		println("(()(): " + doParanthesesMatch("(()()"));
		println("(())(): " + doParanthesesMatch("(())()"));
		println("(()(()): " + doParanthesesMatch("(()(())"));
		println("(()()()): " + doParanthesesMatch("(()()())"));
		println("[{]}: " + doParanthesesMatch("([{]}"));
		println("{([]{()})({})}: " + doParanthesesMatch("{([]{()})({})}"));
	}

	private boolean doParanthesesMatch(String s) {
		Stack<Character> stk = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			switch (c) {
			case '(':
				stk.push(c);
				break;
			case ')':
				if (!stk.isEmpty()) {
					stk.pop();
				} else {
					return false;
				}
				break;
			case '[':
				stk.push(c);
				break;
			case ']':
				if (!stk.isEmpty()) {
					stk.pop();
				} else {
					return false;
				}
				break;
			case '{':
				stk.push(c);
				break;
			case '}':
				if (!stk.isEmpty()) {
					stk.pop();
				} else {
					return false;
				}
				break;
			}

		}
		if (stk.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}
