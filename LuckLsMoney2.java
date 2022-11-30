package team_project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class Chart2 {
	ArrayList yourdice;
	int hap1 = 0;
	int hap2 = 0;

	int Ones(ArrayList yourdice) {
		this.yourdice = yourdice;
		int sum = 0;
		for (int k = 0; k < 5; k++) {
			int on = Integer.parseInt(yourdice.get(k).toString());// object를 string으로 바꾸고 그것을 int로 바꾸는 과정
			if (on == 1) {
				sum += on;
			}

		}
		hap1 += sum;
		return sum;

	}

	int Twos(ArrayList yourdice) {
		this.yourdice = yourdice;
		int sum = 0;
		for (int k = 0; k < 5; k++) {
			int on = Integer.parseInt(yourdice.get(k).toString());
			if (on == 2) {
				sum += on;
			}

		}
		hap1 += sum;
		return sum;
	}

	int Threes(ArrayList yourdice) {
		this.yourdice = yourdice;
		int sum = 0;
		for (int k = 0; k < 5; k++) {
			int on = Integer.parseInt(yourdice.get(k).toString());
			if (on == 3) {
				sum += on;
			}

		}
		hap1 += sum;
		return sum;
	}

	int Fours(ArrayList yourdice) {
		this.yourdice = yourdice;
		int sum = 0;
		for (int k = 0; k < 5; k++) {
			int on = Integer.parseInt(yourdice.get(k).toString());
			if (on == 4) {
				sum += on;
			}

		}
		hap1 += sum;
		return sum;
	}

	int Fives(ArrayList yourdice) {
		this.yourdice = yourdice;
		int sum = 0;
		for (int k = 0; k < 5; k++) {
			int on = Integer.parseInt(yourdice.get(k).toString());
			if (on == 5) {
				sum += on;
			}

		}
		hap1 += sum;
		return sum;
	}

	int Sixes(ArrayList yourdice) {
		this.yourdice = yourdice;
		int sum = 0;
		for (int k = 0; k < 5; k++) {
			int on = Integer.parseInt(yourdice.get(k).toString());
			if (on == 6) {
				sum += on;
			}

		}
		hap1 += sum;
		return sum;
	}

	int Choice(ArrayList yourdice) {
		this.yourdice = yourdice;
		int sum = 0;
		for (int k = 0; k < 5; k++) {
			int on = Integer.parseInt(yourdice.get(k).toString());
			sum += on;

		}
		hap2 += sum;
		return sum;
	}

	int Small(ArrayList yourdice) {
		this.yourdice = yourdice;
		int sum = 0;
		int[] small = { 1, 2, 3, 4, 5 };

		int[] ok = new int[5];
		for (int k = 0; k < 5; k++) {
			int on = Integer.parseInt(yourdice.get(k).toString());
			ok[k] = on;

		}
		Arrays.sort(ok);
		if (Arrays.equals(small, ok))
			hap2 += 30;
		return sum;

	}

	int Big(ArrayList yourdice) {
		this.yourdice = yourdice;
		int sum = 0;
		int[] big = { 2, 3, 4, 5, 6 };

		int[] ok = new int[5];
		for (int k = 0; k < 5; k++) {
			int on = Integer.parseInt(yourdice.get(k).toString());
			ok[k] = on;

		}
		Arrays.sort(ok);
		if (Arrays.equals(big, ok))
			hap2 += 30;
		return sum;
	}

	int Strike(ArrayList yourdice) {
		this.yourdice = yourdice;
		int sum = 0;
		int[] ok = new int[5];
		for (int k = 0; k < 5; k++) {
			int on = Integer.parseInt(yourdice.get(k).toString());
			ok[k] = on;
		}
		if (ok[0] == ok[1] && ok[0] == ok[2] && ok[0] == ok[3] && ok[0] == ok[4])
			sum += 50;

		hap2 += sum;
		return sum;
	}

//	void complete1() {
//		if (total1 >= 63) {
//			total1 += 35;
//			System.out.print("[보너스 조건 충족] 35점 추가 획득!");
//		}
//	}

}

public class LuckLsMoney2 {

	public int luckIsMoneyMain() {
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> yourdice = new ArrayList<>();
		int total1 = 0;
		int total2 = 0;

		String keyword[] = new String[10];
		for (int a = 0; a < 10; a++)
			keyword[a] = "---";

		int[] check = new int[10];
		for (int h = 0; h < 10; h++) {
			System.out.printf("%d/10\n", h + 1);

			if (yourdice.size() > 0) {
				for (int a = 0; a < 5; a++) {
					yourdice.remove(0);
				}
			}
			int on[] = new int[6];
			for (int i = 0; i < 5; i++) {
				on[i + 1] = 0;
			}

			for (int j = 0; j < 3; j++) {
				int dice[] = new int[6];
				Random r = new Random();

				System.out.printf("%d번째 시도\n", j + 1);

				while (dice[5] == 0 && on[5] == 0) {
					dice[5] = r.nextInt(7);
				}
				while (dice[1] == 0 && on[1] == 0) {
					dice[1] = r.nextInt(7);
				}
				while (dice[2] == 0 && on[2] == 0) {
					dice[2] = r.nextInt(7);
				}
				while (dice[3] == 0 && on[3] == 0) {
					dice[3] = r.nextInt(7);
				}
				while (dice[4] == 0 && on[4] == 0) {
					dice[4] = r.nextInt(7);
				}

				for (int i = 1; i < 6; i++)
					System.out.printf("dice[%d] = %d\n", i, dice[i]);

				while (true) {

					System.out.print("선택할 주사위는?(없으면 0입력) : ");
					int select = in.nextInt();
					if (select == 0)
						break;
					else if (5 < select || select < 0) {
						System.out.println("아직 선택되지 않은 주사위를 선택하십시오.");
						continue;
					}
//					else if (5 < (select = in.nextInt()) || (select = in.nextInt()) < 0) {
//						System.out.print("아직 선택되지 않은 주사위를 골라주십시오.");
//						continue;
//					}
					else {
						yourdice.add(dice[select]);
						on[select] = 1;

					}
				}
				System.out.print("선택한 수 : [ ");
				for (int i : yourdice)
					System.out.print(i + " ");
				System.out.println("]");

				if (yourdice.size() == 5) {
					System.out.println("종료");
					break;
				}

			} // for 3번반복 끝나는 곳

			while (true) {

				System.out.print("점수 획득 선택 : ");
				String scores = in.next();

				Chart2 p = new Chart2();
				if (scores.equals("Ones")) {

					if (check[0] == 0) {
						check[0] = 1;
						p.Ones(yourdice);
						keyword[0] = "Ones";

					}

					else {
						System.out.println("이미 입력한 조건입니다. 다른 조건을 선택하십시오.");
						continue;
					}

				} else if (scores.equals("Twos")) {

					if (check[1] == 0) {
						check[1] = 2;
						p.Twos(yourdice);
						keyword[1] = "Twos";

					} else {
						System.out.println("이미 입력한 조건입니다. 다른 조건을 선택하십시오.");
						continue;
					}

				} else if (scores.equals("Threes")) {
					if (check[2] == 0) {
						check[2] = 3;
						p.Threes(yourdice);
						keyword[2] = "Threes";

					} else {
						System.out.println("이미 입력한 조건입니다. 다른 조건을 선택하십시오.");
						continue;
					}
				} else if (scores.equals("Fours")) {

					if (check[3] == 0) {
						check[3] = 4;
						p.Fours(yourdice);
						keyword[3] = "Fours";

					} else {
						System.out.println("이미 입력한 조건입니다. 다른 조건을 선택하십시오.");
						continue;
					}

				} else if (scores.equals("Fives")) {

					if (check[4] == 0) {
						check[4] = 5;
						p.Fives(yourdice);
						keyword[4] = "Fives";

					} else {
						System.out.println("이미 입력한 조건입니다. 다른 조건을 선택하십시오.");
						continue;
					}
				} else if (scores.equals("Sixes")) {

					if (check[5] == 0) {
						check[5] = 6;
						p.Sixes(yourdice);
						keyword[5] = "Sixes";

					} else {
						System.out.println("이미 입력한 조건입니다. 다른 조건을 선택하십시오.");
						continue;
					}
				} else if (scores.equals("Choice")) {

					if (check[6] == 0) {
						check[6] = 7;
						p.Choice(yourdice);
						keyword[6] = "Choice";
					} else {
						System.out.println("이미 입력한 조건입니다. 다른 조건을 선택하십시오.");
						continue;
					}
				} else if (scores.equals("Small")) {

					if (check[7] == 0) {
						check[7] = 7;
						p.Small(yourdice);
						keyword[7] = "Small";
					} else {
						System.out.println("이미 입력한 조건입니다. 다른 조건을 선택하십시오.");
						continue;
					}
				} else if (scores.equals("Big")) {

					if (check[8] == 0) {
						check[8] = 7;
						p.Big(yourdice);
						keyword[8] = "Big";

					} else {
						System.out.println("이미 입력한 조건입니다. 다른 조건을 선택하십시오.");
						continue;
					}
				} else if (scores.equals("Strike")) {

					if (check[9] == 0) {
						check[9] = 7;
						p.Strike(yourdice);
						keyword[9] = "Strike";
					} else {
						System.out.println("이미 입력한 조건입니다. 다른 조건을 선택하십시오.");
						continue;
					}
				}

				total1 += p.hap1;
				total2 += p.hap2;
				int Total = total1 + total2;

				System.out.printf("[ 이번 획득 점수: %d, 일반 점수: %d, 특수 점수: %d, 획득 점수: %d]\n", p.hap1 + p.hap2, total1, total2,
						Total);
				System.out.print("현재 선택된 키워드 : ");
				for (String c : keyword)
					System.out.print(c + " ");

				System.out.println();
				System.out.println();
				break;

			}

		}
		if (total1 >= 63) {
			total1 += 35;
			System.out.println("[보너스 조건 충족] 일반 점수가 63점 이상일 시 35점 추가 획득");

		}

		int Total = total1 + total2;
		int rank = 0;
		System.out.printf("최종 점수 : %d\n", Total);

		if (Total >= 220) {
			rank = 1;
			System.out.println("당신의 행운 등급은 1등급");
		}

		else if (Total >= 180) {
			rank = 2;
			System.out.println("당신의 행운 등급은 2등급");
		} else if (Total >= 145) {
			rank = 3;
			System.out.println("당신의 행운 등급은 3등급");
		} else if (Total >= 115) {
			rank = 4;
			System.out.println("당신의 행운 등급은 4등급");
		} else {
			rank = 5;
			System.out.println("당신의 행운 등급은 5등급");
		}

		// 이제 rank가 등급으로 입력됨.
		return rank;

	}

}
