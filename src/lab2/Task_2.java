package lab2;

public class Task_2 {
	public static void drawPyramid(int n) {
		drawPyramidHelper(n, 1);
	}

	public static void drawPyramidHelper(int n, int current) {
		if (n < current) {
			return;
		}
		for (int i = 0; i < n - current; i++) {
			System.out.print(" ");
		}
		for (int i = 0; i < current * 2 - 1; i++) {
			System.out.print("*");
		}
		System.out.println();
		drawPyramidHelper(n, current + 1);
	}

	public static void pyrarnidPattern_1(int n) {
		pyrarnidPattern_1_Helper(n, 1);
	}

	public static void pyrarnidPattern_1_Helper(int n, int current) {
		if (n < current) {
			return;
		}
		for (int i = 0; i < (n - current); i++) {
			System.out.print(" ");
		}
		for (int i = 0; i < current; i++) {
			System.out.print(current + " ");
		}
		System.out.println();
		pyrarnidPattern_1_Helper(n, current + 1);
	}

	public static void pyrarnidPattern_2(int n) {
		pyrarnidPattern_2_Helper(n, 1);
	}

	public static void pyrarnidPattern_2_Helper(int n, int current) {
		if (n < current) {
			return;
		}
		for (int i = 0; i < (n - current); i++) {
			System.out.print(" ");
		}
		for (int i = 0; i < current; i++) {
			System.out.print(i + 1 + " ");
		}
		System.out.println();
		pyrarnidPattern_2_Helper(n, current + 1);
	}

	public static void main(String[] args) {
		drawPyramid(5);
		pyrarnidPattern_1(5);
		pyrarnidPattern_2(5);
	}
}
