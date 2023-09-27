package lab2;

import java.lang.Math;

public class Task1_1 {

	public static int getSn1(int n) {
		if (n == 1) {
			return 1;
		}
		return (int) (Math.pow(-1, n + 1)) * n + getSn1(n - 1);
	}

	public static int getSn2Helper(int n) {
		if (n == 1) {
			return 1;
		}
		return n * getSn2Helper(n - 1);

	}

	public static int getSn2(int n) {
		if (n == 1) {
			return 1;
		}
		return getSn2Helper(n) + getSn2(n - 1);
	}

	public static int getSn3(int n) {
		if (n == 1) {
			return 1;
		}
		return (int) (Math.pow(n, 2)) + getSn3(n - 1);
	}

	public static double getSn4Helper(int n) {
		if (n == 0) {
			return 1;
		}
		return 2 * n * getSn4Helper(n - 1);
	}

	public static double getSn4(int n) {
		if (n == 0) {
			return 1;
		}
		return 1 / getSn4Helper(n) + getSn4(n - 1);
	}

	public static void main(String[] args) {
		System.out.println(getSn1(5));
		System.out.println(getSn2(4));
		System.out.println(getSn3(3));
		System.out.println(getSn4(2));
	}
}
