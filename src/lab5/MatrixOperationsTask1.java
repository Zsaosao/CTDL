package lab5;

public class MatrixOperationsTask1 {
	// add 2 matrices
	public static int[][] add(int[][] a, int[][] b) {
		if (a.length != b.length || a[0].length != b[0].length) {
			System.out.println("Matrices are not of the same size");
			return null;
		}
		int matrixResult[][] = new int[a.length][a[0].length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				matrixResult[i][j] = a[i][j] + b[i][j];
			}
		}
		return matrixResult;
	}

	// subtract 2 matrices
	public static int[][] subtract(int[][] a, int[][] b) {
		if (a.length != b.length || a[0].length != b[0].length) {
			System.out.println("Matrices are not of the same size");
			return null;
		}
		int matrixResult[][] = new int[a.length][a[0].length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				matrixResult[i][j] = a[i][j] - b[i][j];
			}
		}
		return matrixResult;
	}

	// multiply 2 matrices
	public static int[][] multiply(int[][] a, int[][] b) {
		if (a[0].length != b.length) {
			System.out.println("row of matrix a is not equal to column of matrix b");
			return null;
		}
		int matrixResult[][] = new int[a.length][b[0].length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				for (int k = 0; k < a[0].length; k++) {
					matrixResult[i][j] += a[i][k] * b[k][j];
				}
			}
		}
		return matrixResult;
	}

	public static void printMatrix(int matrix[][]) {
		for (int i = 0; i < matrix.length; i++) {
			System.out.print("[");
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j]);
				if (j != matrix[0].length - 1) {
					System.out.print(",");
				}
			}
			System.out.println("]");
		}
	}

	// tranpose a matrix
	public static int[][] transpose(int[][] a) {
		int matrixResult[][] = new int[a[0].length][a.length];
		for (int i = 0; i < a[0].length; i++) {
			for (int j = 0; j < a.length; j++) {
				matrixResult[i][j] = a[j][i];
			}
		}
		return matrixResult;
	}

	public static void main(String[] args) {
		int matrixA[][] = { { 1, 2, 3 }, { 4, 5, 6 } };
		int matrixB[][] = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
		printMatrix(multiply(matrixA, matrixB));
	}

}
