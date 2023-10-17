package lab5;

public class TicTacToeAdvanced {
	private static final char EMPTY = ' ';
	private char[][] board;

	TicTacToeAdvanced(char matrix[][]) {
		this.board = matrix;
	}

	public boolean checkRows() {
		for (int i = 0; i < board.length; i++) {
			int count = 0;
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] != EMPTY) {
					count++;
				}
			}
			if (count == board[i].length) {
				return true;
			}
		}
		return false;
	}

	public boolean checkColumns() {
		for (int i = 0; i < board.length; i++) {
			int count = 0;
			for (int j = 0; j < board[i].length; j++) {
				if (board[j][i] != EMPTY) {
					count++;
				}
			}
			if (count == board.length) {
				return true;
			}
		}
		return false;
	}

	public boolean checkDiagonals() {
		int count = 0;
		for (int i = 0; i < board.length; i++) {
			if (board[i][i] != EMPTY) {
				count++;
			}
		}
		if (count == board.length) {
			return true;
		}
		count = 0;
		for (int i = 0; i < board.length; i++) {
			if (board[i][board.length - 1 - i] != EMPTY) {
				count++;
			}
		}
		if (count == board.length) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		char matrix[][] = { { 'X', ' ', ' ' }, { ' ', 'X', 'X' }, { ' ', 'X', 'X' } };
		TicTacToeAdvanced t = new TicTacToeAdvanced(matrix);
		System.out.println(t.checkRows());
		System.out.println(t.checkColumns());
		System.out.println(t.checkDiagonals());

	}

}
