package lab10;

import java.util.Stack;

public class MyLIFO_App {
	public static <E> void reserve(E[] array) {
		Stack<E> stack = new Stack<E>();
		for (E e : array) {
			stack.push(e);
		}
		for (int i = 0; i < array.length; i++) {
			array[i] = stack.pop();
		}
	}

	public static boolean isCorrect(String input) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
			} else if (c == ')' || c == ']' || c == '}') {
				if (stack.isEmpty()) {
					return false;
				}
				char top = stack.pop();
				if (c == ')' && top != '(') {
					return false;
				}
				if (c == ']' && top != '[') {
					return false;
				}
				if (c == '}' && top != '{') {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

	public static int evaluateExpression(String expression) {
		Stack<Integer> operandStack = new Stack<Integer>();
		Stack<Character> operatorStack = new Stack<Character>();
		expression = insertBlanks(expression);
		String[] tokens = expression.split(" ");
		for (String token : tokens) {
			if (token.length() == 0) {
				continue;
			} else if (token.charAt(0) == '+' || token.charAt(0) == '-') {
				while (!operatorStack.isEmpty()
						&& (operatorStack.peek() == '+'
								|| operatorStack.peek() == '-'
								|| operatorStack.peek() == '*'
								|| operatorStack.peek() == '/')) {
					processAnOperator(operandStack, operatorStack);
				}
				operatorStack.push(token.charAt(0));
			} else if (token.charAt(0) == '*' || token.charAt(0) == '/') {
				while (!operatorStack.isEmpty()
						&& (operatorStack.peek() == '*' || operatorStack.peek() == '/')) {
					processAnOperator(operandStack, operatorStack);
				}
				operatorStack.push(token.charAt(0));
			} else if (token.trim().charAt(0) == '(') {
				operatorStack.push('(');
			} else if (token.trim().charAt(0) == ')') {
				while (operatorStack.peek() != '(') {
					processAnOperator(operandStack, operatorStack);
				}
				operatorStack.pop();
			} else {
				operandStack.push(new Integer(token));
			}
		}
		while (!operatorStack.isEmpty()) {
			processAnOperator(operandStack, operatorStack);
		}
		return operandStack.pop();
	}

	private static String insertBlanks(String expression) {
		String result = "";
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '('
					|| expression.charAt(i) == ')'
					|| expression.charAt(i) == '+'
					|| expression.charAt(i) == '-'
					|| expression.charAt(i) == '*'
					|| expression.charAt(i) == '/') {
				result += " " + expression.charAt(i) + " ";
			} else {
				result += expression.charAt(i);
			}
		}
		return result;
	}

	private static void processAnOperator(Stack<Integer> operandStack, Stack<Character> operatorStack) {
		char op = operatorStack.pop();
		int op1 = operandStack.pop();
		int op2 = operandStack.pop();
		if (op == '+') {
			operandStack.push(op2 + op1);
		} else if (op == '-') {
			operandStack.push(op2 - op1);
		} else if (op == '*') {
			operandStack.push(op2 * op1);
		} else if (op == '/') {
			operandStack.push(op2 / op1);
		}
	}

	public static void main(String[] args) {
		Integer[] array = { 1, 2, 3, 4, 5 };
		reserve(array);
		for (Integer i : array) {
			System.out.print(i + " ");
		}
		System.out.println();
		String[] array2 = { "a", "b", "c", "d", "e" };
		reserve(array2);
		for (String s : array2) {
			System.out.print(s + " ");
		}
		System.out.println();

		String input = "({[]}) {}[]()";
		System.out.println(input + " is correct: " + isCorrect(input));
		input = "({[}){";
		System.out.println(input + " is correct: " + isCorrect(input));

		String expression = "51 + (54 *(3+2))";
		System.out.println(expression + " = " + evaluateExpression(expression));
	}

}
