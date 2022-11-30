package team_project;

import java.util.Random;
import java.util.Scanner;

class Board {
	int row, column;
	int[] board_index;
	char[] board_graphic = {'-', '-', '-', '-', '|', ' ', '|', '-', '-', '-', '-'};
	
	int dice_accum = 0;
	Random dice = new Random();
	
	int[] minigame1_index;
	int[] minigame2_index;
	int[] minigame3_index;
	int[][] game_index;
	int game_count;
	
	int result = 0;
	
	public Board(int row, int column) {
		this.row = row;
		this.column = column;
		
		game_count = (int)(row * column * 0.7 / 3)*3;
		minigame1_index = new int[game_count/3];
		minigame2_index = new int[game_count/3];
		minigame3_index = new int[game_count/3];
		
		game_index = new int[3][game_count/3];
		
		for(int i = 0; i < game_count/3; i++) {
			minigame1_index[i] = -1;
			minigame2_index[i] = -1;
			minigame3_index[i] = -1;
		}
		game_index[0] = minigame1_index;
		game_index[1] = minigame2_index;
		game_index[2] = minigame3_index;
		
		
		board_index = new int[row * column];
		
		for(int i = 0;i < board_index.length; i++) {
			board_index[i] = i + 1;
		}
		
		initializeGame(game_index);
	}
	
	boolean isContainElement(int[] array, int element) {
		for(int i=0; i < array.length; i++) {
			if (array[i] == element) {
				return true;
			}
		}
		return false;
	}
	
	void initializeGame(int[][] game_index) {
		int temp;
		int[] temp_index = new int[game_count];
		
		for(int i=0; i< game_count; i++) {
			do {
				temp = dice.nextInt(row*column);
			} while(isContainElement(temp_index, temp));
				
			temp_index[i] = temp;
		}
		
		for (int i = 0; i < 3; i++) {
			int k = 0;
			for (int j = i * game_count/3; j < (i+1) * game_count/3; j++) {
				game_index[i][k++] = temp_index[j];
			}
		}
		
	}
	
	void rollDice() throws InterruptedException {
		System.out.print("주사위를 굴립니다");
		Thread.sleep(500);
		System.out.print(".");
		Thread.sleep(500);
		System.out.print(".");
		Thread.sleep(500);
		System.out.println(".");
		Thread.sleep(500);
		
		int dice_num = dice.nextInt(6) + 1;
		
		System.out.printf("주사위를 던진 결과 %d가 나왔습니다!", dice_num);
		
		dice_accum += dice_num;
	}
	
	void drawBoard() {
		
		System.out.printf("국민대학교의 쿠민이는 평소 조별과제에서 좋지 못한 조를 만난다거나 타고 있는 버스가 사고를 당해 수업에 지각을 하는 등\n"
				+ "평소에 굉장히 운이 없었다. 그래서 그는 신께 자신의 '운'을 좋게 만들어 달라고 빌었고, 자비로운 신은 그에게 '운'을 쟁취해 낼 수 있는\n"
				+ "기회를 선사하였다. 바로 오직 운에 의해 미래가 결정되는 시련을 내려주어 쿠민이의 운을 키워갈 수 있도록 한 것이다.\n"
				+ "쿠민이는 이 시련을 이겨내어 행운아가 될 수 있을까?\n\n");
		System.out.printf("시련의 구성\n"
				+ "게임 보드 위를 주사위를 통해 움직입니다.\n"
				+ "보드의 각각의 장소에는 이벤트가 있습니다.\n"
				+ "그 이벤트는 전투, 도박, 생존 등 다양합니다.\n"
				+ "모든 이벤트를 우수한 성적으로 클리어하여 보드의 끝에 도달하고 시련을 이겨내세요!\n"
				+ "이겨내지 못한다면 당신의 운은 영영 지금 그대로일 것입니다.\n\n");
		
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
				// 1, 3 ÁÙ
				for (int s = end; s >= start; s--) {
					System.out.print(board_graphic[4]);
					
					if (isContainElement(game_index[0], s-1)) {
						System.out.print("A"); // 게임 위치 표시
						if (s-1 != dice_accum)
							System.out.print(" ");
						else
							System.out.print("#"); // 캐릭터 위치 표시
					}
					else if (isContainElement(game_index[1], s-1)) {
						System.out.print("B"); // 게임 위치 표시
						if (s-1 != dice_accum)
							System.out.print(" ");
						else
							System.out.print("#"); // 캐릭터 위치 표시
					}
					else if (isContainElement(game_index[2], s-1)) {
						System.out.print("C"); // 게임 위치 표시
						if (s-1 != dice_accum)
							System.out.print(" ");
						else
							System.out.print("#"); // 캐릭터 위치 표시
					}
					else if (s-1 == dice_accum) {
						System.out.print("# "); // 캐릭터 위치 표시
					}
					else {
						System.out.printf("%2d", board_index[s - 1]); // 보드 숫자 표시
					}
					
					System.out.print(board_graphic[6]);
					if (s == start)
						break;
					System.out.print("---");
				}
			} else {
				// 0, 2, 4 ÁÙ
				for (int s = start; s <= end; s++) {
					System.out.print(board_graphic[4]);
					
//					if (s-1 == dice_accum)
//						System.out.print("# "); // 캐릭터 위치 표시
//					else if (isContainElement(game_index[0], s-1))
//						System.out.print("A "); // 게임 위치 표시
//					else if (isContainElement(game_index[1], s-1))
//						System.out.print("B "); // 게임 위치 표시
//					else if (isContainElement(game_index[2], s-1))
//						System.out.print("C "); // 게임 위치 표시
//					else
//						System.out.printf("%2d", board_index[s - 1]); // 보드 숫자 표시
					
					if (isContainElement(game_index[0], s-1)) {
						System.out.print("A"); // 게임 위치 표시
						if (s-1 != dice_accum)
							System.out.print(" ");
						else
							System.out.print("#"); // 캐릭터 위치 표시
					}
					else if (isContainElement(game_index[1], s-1)) {
						System.out.print("B"); // 게임 위치 표시
						if (s-1 != dice_accum)
							System.out.print(" ");
						else
							System.out.print("#"); // 캐릭터 위치 표시
					}
					else if (isContainElement(game_index[2], s-1)) {
						System.out.print("C"); // 게임 위치 표시
						if (s-1 != dice_accum)
							System.out.print(" ");
						else
							System.out.print("#"); // 캐릭터 위치 표시
					}
					else if (s-1 == dice_accum) {
						System.out.print("# "); // 캐릭터 위치 표시
					}
					else {
						System.out.printf("%2d", board_index[s - 1]); // 보드 숫자 표시
					}

					
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
	
	int findGame() {
		for (int i=0; i < 3; i++) {
			for (int j=0; j < game_count/3; j++) {
				if(game_index[i][j] == dice_accum)
					return i+1;
			}
		}
		
		return 0;
	}
	
	void playMinigame() throws InterruptedException {
		if (findGame() == 1) {
			System.out.println("DICE BATTLE\n\n");
			DiceBattle db = new DiceBattle();
			result += db.diceBattleMain();
		}
		else if (findGame() == 2) {
			System.out.println("B게임 진행");
		}
		else if (findGame() == 3) {
			System.out.println("C게임 진행");
		}
		else {
			System.out.println("운이 좋군요! 이 타일에는 아무런 게임도 존재하지 않습니다. 그냥 지나가세요.");
		}
		Thread.sleep(1000);
	}
	
	void displayFinalResult() {
		
	}
}



public class LuckyKoominAdventure {
	
	public static void clearScreen() {
		for (int i = 0; i < 80; i++)
		      System.out.println("");
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		Board koominBoard = new Board(7, 5);
		
		clearScreen();
		
		System.out.println("게임을 시작합니다.");
		
		Thread.sleep(1000);
		System.out.println("3");
		Thread.sleep(1000);
		System.out.println("2");
		Thread.sleep(1000);
		System.out.println("1");
		
		System.out.println();
		System.out.printf("국민대학교의 쿠민이는 평소 조별과제에서 좋지 못한 조를 만난다거나 타고 있는 버스가 사고를 당해 수업에 지각을 하는 등\n"
				+ "평소에 굉장히 운이 없었다. 그래서 그는 신께 자신의 '운'을 좋게 만들어 달라고 빌었고, 자비로운 신은 그에게 '운'을 쟁취해 낼 수 있는\n"
				+ "기회를 선사하였다. 바로 오직 운에 의해 미래가 결정되는 시련을 내려주어 쿠민이의 운을 키워갈 수 있도록 한 것이다.\n"
				+ "쿠민이는 이 시련을 이겨내어 행운아가 될 수 있을까?\n\n");
		
		Thread.sleep(1000);
		
		System.out.printf("시련의 구성\n"
				+ "게임 보드 위를 주사위를 통해 움직입니다.\n"
				+ "보드의 각각의 장소에는 이벤트가 있습니다.\n"
				+ "그 이벤트는 전투, 도박, 생존 등 다양합니다.\n"
				+ "모든 이벤트를 우수한 성적으로 클리어하여 보드의 끝에 도달하고 시련을 이겨내세요!\n"
				+ "이겨내지 못한다면 당신의 운은 영영 지금 그대로일 것입니다.\n\n");
		
		Thread.sleep(500);
		
		clearScreen();
		koominBoard.drawBoard();
		koominBoard.rollDice();
		Thread.sleep(1000);
		
		while(koominBoard.dice_accum <= koominBoard.row * koominBoard.column) {
			clearScreen();
			koominBoard.drawBoard();
			System.out.print("Enter 키를 눌러 게임에 진입하세요!");
			in.nextLine();
			
			clearScreen();
			koominBoard.playMinigame();
			
			clearScreen();
			koominBoard.drawBoard();
			koominBoard.rollDice();
			Thread.sleep(1000);
		}
		
		clearScreen();
		koominBoard.displayFinalResult();
//		for(int i = 0; i < koominBoard.game_count;i++) {
//			System.out.print(koominBoard.game_index[i] + " ");
//		}
	}

}
