package lab2;

public class Fibonacci {
	public static int getFibonacci(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;

		return getFibonacci(n - 2) + getFibonacci(n - 1);
	}

	public static void printFibonacci(int n) {
		if (n == 0) {
			return;
		}
		System.out.println(getFibonacci(n - 1));
		printFibonacci(n - 1);
	}

	public static void main(String[] args) {
		printFibonacci(10);
	}

}