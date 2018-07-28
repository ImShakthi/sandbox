package com.sakthi.datastructure.handler;

import com.sakthi.datastructure.stack.LinkedStack;

public class ParathesisValidator {

	public static void main(final String[] args) {
		ParathesisValidator validator = new ParathesisValidator();
		validator.init();
//		args.length
	}

	public void init() {
		try {
			String expression = "([{ABCDabcd0123456789}])";

			boolean valid = true;
			LinkedStack stack = new LinkedStack();

			for (int index = 0; index < expression.length(); index++) {
				char ch = expression.charAt(index);
				if (isOpen(ch)) {
					stack.push(ch);
				} else if (isAlphaNumeric(ch) || isArthematic(ch)) {
					System.out.println(ch);
				} else {
					int no = (int) stack.pop();
					char open = (char) no;
					if (!isMatching(open, ch)) {
						valid = false;
						break;
					}
				}
			}

			if (valid && stack.isEmpty()) {
				System.out.println("VALID");
			} else {
				System.out.println("INVALID");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
	}

	private boolean isArthematic(final char ch) {
		return (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '%');
	}

	private boolean isAlphaNumeric(final char ch) {
		return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9');
	}

	private boolean isMatching(final char open, final char close) {
		boolean match = false;
		switch (open) {
		case '(':
			if (close == ')') {
				match = true;
			}
			break;
		case '{':
			if (close == '}') {
				match = true;
			}
			break;
		case '[':
			if (close == ']') {
				match = true;
			}
			break;
		}
		// System.out.println("open=" + open + ", close=" + close + ", match=" +
		// match);
		return match;
	}

	private boolean isOpen(final char ch) {
		boolean open = false;
		switch (ch) {
		case '(':
		case '{':
		case '[':
			open = true;
		}
		return open;
	}
}
