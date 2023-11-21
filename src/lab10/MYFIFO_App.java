package lab10;

import java.util.Queue;
import java.util.Stack;

public class MYFIFO_App {
	public static <E> void stutter(Queue<E> input) {
		int size = input.size();
		for (int i = 0; i < size; i++) {
			E e = input.remove();
			input.add(e);
			input.add(e);
		}
	}

	// Method mirror that accepts a queue of strings as aparameter and appends the
	// queue's contents to itself in reverse order
	// front [a, b, c] back
	// becomes
	// front [a, b, c, c, b, a] back
	public static <E> void mirror(Queue<E> input) {
		Stack<E> temp = new Stack<E>();
		int size = input.size();
		for (int i = 0; i < size; i++) {
			E e = input.remove();
			input.add(e);
			temp.add(e);
		}
		for (int i = 0; i < size; i++) {
			E e = temp.pop();
			input.add(e);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Integer> queue = new java.util.LinkedList<Integer>();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.add(5);
		stutter(queue);
		System.out.println(queue);

		Queue<String> queue2 = new java.util.LinkedList<String>();
		queue2.add("a");
		queue2.add("b");
		queue2.add("c");
		mirror(queue2);
		System.out.println(queue2);
	}
}
