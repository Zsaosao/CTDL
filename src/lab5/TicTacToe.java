package lab5;

public class TicTacToe {
	private static final char EMPTY = ' ';
	private char[][] board;

	/*
	 * This method checks all rows and returns true if any of
	 * them are marked with
	 * all of a single player's markers.
	 * Otherwise, returns false.
	 */
	public boolean checkRows() {
		for (int i = 0; i < board.length; i++) {
			if (board[i][0] != EMPTY && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
				return true;
			}
		}
		return false;
	}

	public boolean checkColumns() {
		for (int i = 0; i < board.length; i++) {
			if (board[0][i] != EMPTY && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
				return true;
			}
		}
		return false;
	}

	public boolean checkDiagonals() {
		if (board[0][0] != EMPTY && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
			return true;
		}
		if (board[0][2] != EMPTY && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
			return true;
		}
		return false;
	}

}
