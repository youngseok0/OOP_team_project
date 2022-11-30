package team_project;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;


public class DiceBattle {
	static void Rolldice(int[] dices) {
		Random D6 = new Random();
		System.out.println("주사위를 세번 굴립니다. 나온 숫자는!");
		
		for(int i =0; i<3;i++) {
			dices[i] = D6.nextInt(1,7);
			System.out.printf("%d번 주사위 = %d\n",i+1,dices[i]);
		}		
	}
	//주사위를 세번 굴려서 배열에 넣는 메서드, 또한 그 배열에 저장된 주사위 3개 출력하는 메서드
	

	
	public int diceBattleMain() {
		int rank; // 게임 클리어 등급
		
		Enemy enemy = new Enemy();
		PlayerCha p = new PlayerCha();
		Scanner Scan = new Scanner(System.in);
		
		int[] dices = new int[3];
		
		System.out.println("적이 나타났습니다.");
		enemy.setEnemyHp(); //적 초기 체력 설정
		p.setPHp(); //플레이어 초기 체력 설정
		int maxHP = p.PHp;
		
		int turn = 1; //턴 수 카운트
		
		while(enemy.EHP>0 && p.PHp>0) {
			System.out.println();
			System.out.println("--------------------------------");
			System.out.printf("%d 턴\n",turn);
			System.out.println();
			
			enemy.setEnemyDamage();
			enemy.check();
			System.out.println();
			
			System.out.println("플레이어의 남은 체력 :"+p.PHp);
			
			System.out.println();
			Rolldice(dices);
			
			
			while(true) {
				System.out.println();
				
				p.skillexplain();
				p.PSkillnum = 0;
				System.out.println();
				
				System.out.println("적의 이번턴 공격 데미지는 "+enemy.EDamage+"입니다");
				System.out.print("발동할 스킬 넘버를 가진 주사위의 번호를 입력하세요->");
				int a = Scan.nextInt()-1;
				if(dices[a] != 0 && 0<=a && a<=2 ) {
					p.PSkillnum = dices[a];
					dices[a] = 0 ;
					break;
				}
			}
			
			while(true) {
				System.out.println();
				p.PDamage = 0;
				for(int i =0; i<3;i++) {
					System.out.printf("%d번 주사위 = %d\n",i+1,dices[i]);
				}		
				System.out.print("몇 데미지를 줄지, 원하는 주사위의 번호를 입력하세요->");
				int a = Scan.nextInt() -1;
				if(dices[a] != 0 ) {
					p.PDamage = dices[a];
					dices[a] = 0 ;
					break;
				}
				
			}
			
			while(true) {
				System.out.println();
				p.PDefense = 0;
				for(int i =0; i<3;i++) {
					System.out.printf("%d번 주사위 = %d\n",i+1,dices[i]);
				}	
				System.out.println("적의 이번턴 공격 데미지는 "+enemy.EDamage+"입니다");
				System.out.print("방어도를 얼마나 얻을지, 원하는 주사위의 번호를 입력하세요->");
				int a = Scan.nextInt()-1;
				if(dices[a] != 0 && 0<=a && a<=2 ) {
					p.PDefense = dices[a];
					dices[a] = 0 ;
					break;
				}
				System.out.println();
			}
				
			System.out.println("********************************");
			
			enemy.EHP = enemy.EHP - p.PDamage;
			System.out.printf("%d데미지를 주어 적의 HP를 %d로 만들었습니다.\n",p.PDamage,enemy.EHP);
			
			
			if(p.PSkillnum == 1) {
				if(p.PHp<maxHP) p.PHp = p.PHp+3;
			}
			
			else if(p.PSkillnum == 2) {
				enemy.EHP = enemy.EHP - 2;
			}
			
			else if(p.PSkillnum == 3) {
				p.Gag();
				System.out.println("깔깔깔! 깔깔깔! 깔깔깔! 깔깔깔!");
			}
			
			else if(p.PSkillnum ==4 ) {
				if(p.PHp<maxHP) p.PHp = p.PHp+6;
			}
			
			else if(p.PSkillnum ==5 ) {
				p.PDefense = 999;
			}
			
			else if(p.PSkillnum ==6 ) {
				enemy.EHP = enemy.EHP - p.PDamage;
				System.out.printf("%d데미지를 주어 적의 HP를 %d로 만들었습니다.\n",p.PDamage,enemy.EHP);
			}
			
			if(enemy.EDamage>p.PDefense) {
				System.out.print("이번 턴 체력 "+p.PHp+"에서");
				p.PHp = p.PHp + p.PDefense - enemy.EDamage;
				System.out.printf("적의 %d 데미지의 공격중 %d 데미지를 막아 %d Hp가 되었습니다\n",enemy.EDamage,p.PDefense,p.PHp);
			}
			else {p.PHp = p.PHp; 
			      System.out.println("완벽한 방어를 통해 체력이 닳지 않았습니다.");
			}
			turn++;
		
		}		
		System.out.println("싸움이 종료되었습니다");
		System.out.println();
		if(p.PHp<=0) {
			System.out.println("이걸 지네....");
			rank = 5;
			System.out.println("당신의 랭크는:"+rank);
		}
		else if(p.PHp > 0 && turn <=3) {
			rank = 1;
			System.out.println("당신의 랭크는:"+rank);
		}
		else if(3<turn &&turn<=5) {
			rank =2;
			System.out.println("당신의 랭크는:"+rank);
		}
		else if(5<turn &&turn<=7) {
			rank =3;
			System.out.println("당신의 랭크는:"+rank);
		}
		else {
			rank =4;
			System.out.println("당신의 랭크는:"+rank);
		}
		
		return rank;
		
	}
	
	
	// 실행문, 1차적으로 적이 나타났다를 출력, 그 이후에 적의 Hp설정, 데미지 설정한 다음에 몇 HP 몇 damage인지 출력해줍니다.
	//또한 데미지는 턴마다 반복하여 설정될 예정입니다.
	//따라서 턴의 순서는 enemy.check(), Rolldice(), 다이스에서 나온 3개 숫자들 공격 방어 회피에 할당시키기, 그리고 턴 종료
	//턴 종료하면 행동 우선은 항상 플레이어입니다.
	//플레이어의 공격, 디펜스, 스킬 순서로 할당됩니다.
	//그 후 적의 HP가 0이하가 되지 않았다면 적은 행동합니다. (오직 공격).
}

class Enemy{
	Random D6 = new Random();
	
	public int EHP;
	public int EDamage;
	
	void setEnemyHp() {
		this.EHP = 18 + D6.nextInt(-6,10);
	}
//보드 넘버에 따른 추가 체력 줄 예정
	void setEnemyDamage() {
		EDamage = 0;
		this.EDamage = 6 + D6.nextInt(-3,5);
	}
//보드 넘버에 따른 추가 데미지 수치 줄 예정
	
	void check() {
		System.out.println("적의 체력: "+ EHP +"\n적의 이번턴 공격 데미지: "+ EDamage);
	}
}

class PlayerCha {
	Random D6 = new Random();
	
	public int PHp;
	public int PDamage;
	public int PDefense;
	public int PSkillnum;
	
	void setPHp() {
		this.PHp = 20 + D6.nextInt(1,6)*2;
		System.out.printf("주사위를 통해 정해진 당신의 체력은 %d입니다",PHp);
	}
	void skillexplain() {
		System.out.println("스킬 1번은 발동시 체력을 3 회복합니다.");
		System.out.println("스킬 2번은 발동시 이번턴이 끝날때 적에게 데미지를 2 줍니다");
		System.out.println("스킬 3번은 발동시 기분이 좋아집니다.");
		System.out.println("스킬 4번은 발동시 체력을 6 회복합니다.");
		System.out.println("스킬 5번은 발동시 이번 턴에 완벽한 방어를 합니다.");
		System.out.println("스킬 6번은 발동시 아까 할당한 데미지 만큼 데미지를 더 줍니다.");
	}
	
	void Gag() {
		int b = D6.nextInt(1,7);
		
		if(b==1) {
			System.out.println("자바를 자바라~~~ (자바칩 프라푸치노를 마시며) 하하하!");
		}
		
		else if(b==2) {
			System.out.println("부엉이가 물에 빠졌어요!\n 그래서 부엉이가 첨부엉 첨부엉 헤엄쳤어요! 하하하!");
		}
		
		else if(b==3) {
			System.out.println("천도복숭아는 호불호가 많이 갈리는 과일이에요.\n 천도니까...\n 호 불어 먹어야해서 하하하!");
		}
		
		else if(b==4) {
			System.out.println("지구상에서 제일 약속이 잘 잡히는 도시는? \n \n \n 오키나와!!! 하하하!");
		}
		
		else if(b==5) {
			System.out.println("저는 옛날 무섭지 않은 옛날 유선 전화가 좋아요.\n 요즘 전화는 무선전화잖아요 하하하!");
		}
		else {
			System.out.println("물리학자가 웃을때 어떻게 웃는지 아시나요?\n\n\n\n피식(physic)! 하하하!");
		}
	}
	
	
//후에 보드 넘버에 따른 추가 체력 계수 줄 예정
}
