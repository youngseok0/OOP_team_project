package task;

public class Board {
	static void draw_board(int row, int column, int[] board_num) {
		char[] board_graphic = { '-', '-', '-', '-', '|', ' ', '|', '-', '-', '-', '-' };

		int start, end;
		int row_length = 4 * row + 3 * (row - 1);
		for (int i = column - 1; i >= 0; i--) {
			end = (i + 1) * row;
			start = end - row + 1;

			for (int j = 0; j < row; j++) {
				for (int t = 0; t < 4; t++) {
					System.out.print(board_graphic[t]);
				}
				System.out.print("   ");
			}
			System.out.println();

			if (i % 2 == 1) {
				// 1, 3 มู
				for (int s = end; s >= start; s--) {
					System.out.print(board_graphic[4]);
					System.out.printf("%2d", board_num[s - 1]);
					System.out.print(board_graphic[6]);
					if (s == start)
						break;
					System.out.print("---");
				}
			} else {
				// 0, 2, 4 มู
				for (int s = start; s <= end; s++) {
					System.out.print(board_graphic[4]);
					System.out.printf("%2d", board_num[s - 1]);
					System.out.print(board_graphic[6]);
					if (s == end)
						break;
					System.out.print("---");
				}
			}
			System.out.println();

			for (int j = 0; j < row; j++) {
				for (int t = 7; t < 11; t++) {
					System.out.print(board_graphic[t]);
				}
				System.out.print("   ");
			}
			System.out.println();
			if (i % 2 == 1) {
				for (int k = 0; k < row_length - 2; k++) {
					System.out.print(" ");
				}
			} else {
				for (int k = 0; k < 1; k++) {
					System.out.print(" ");
				}
			}
			if (i == 0) {
				break;
			}
			System.out.println("|");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int row = 7, column = 5;
		int[] board_num = new int[row * column];

		for (int i = 0; i < board_num.length; i++) {
			board_num[i] = i + 1;
		}

		draw_board(row, column, board_num);
	}

}
