package teamproject;

import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;



public class DiceBattle {
	static void Rolldice(int[] dices) {
		Random D6 = new Random();
		System.out.println("주사위를 세번 굴립니다. 나온 숫자는!");
		
		for(int i =0; i<3;i++) {
			dices[i] = D6.nextInt(1,7);
			System.out.println(dices[i]);
		}		
	}
	//주사위를 세번 굴려서 배열에 넣는 메서드, 또한 그 배열에 저장된 주사위 3개 출력하는 메서드
	
	public static int[] removeElement(int[] arr, int item) {
        return Arrays.stream(arr)
                .filter(i -> i != item)
                .toArray();
    }
	
	public static void main(String[] args) {
		Enemy enemy = new Enemy();
		PlayerCha p = new PlayerCha();
		Scanner Scan = new Scanner(System.in);
		
		int[] dices = new int[3];
		
		System.out.println("적이 나타났습니다.");
		enemy.setEnemyHp(); //적 초기 체력 설정
		p.setPHp(); //플레이어 초기 체력 설정
		
		while(enemy.EHP>0 && p.PHp>0) {
		
			enemy.setEnemyDamage();
			enemy.check();
			System.out.println("플레이어의 남은 체력 :"+p.PHp);
			Rolldice(dices);
			
			while(true) {
				System.out.print("몇 데미지를 줄지, 나온 눈금 중에서 입력하세요 ->");
				int a = Scan.nextInt();
				if(Arrays.asList(a).contains(dices)) {
					p.PDamage = a;
					dices = removeElement(dices, a);
					break;
				}
				else continue;
			}
			
			while(true) {
				for(int i =0; i<3;i++) {
					System.out.println(dices[i]);
				}		
				System.out.print("몇 방어도를 얻을지, 남은 눈금 중에서 입력하세요 ->");
				int b = Scan.nextInt();
				if(Arrays.asList(b).contains(dices)) {
					p.PDamage = b;
					dices = removeElement(dices, b);
					break;
					}				
				else continue;
				}
				
			while(true) {
				for(int i =0; i<3;i++) {
					System.out.println(dices[i]);
				}		
				System.out.print("어떤 스킬을 쓸지 스킬 번호를, 남은 눈금 중에서 입력하세요 ->");
				int c = Scan.nextInt();
				if(Arrays.asList(c).contains(dices)) {
					p.PDamage = c;
					dices = removeElement(dices, c);
					break;
					}				
				else continue;
				}
		}
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
		this.EDamage = 6 + D6.nextInt(-5,5);
	}
//보드 넘버에 따른 추가 데미지 수치 줄 예정
	
	void check() {
		System.out.println("적의 체력: "+ EHP +"\n적의 공격 데미지: "+ EDamage);
	}
}

class PlayerCha {
	Random D6 = new Random();
	Scanner Scan = new Scanner(System.in);
	
	public int PHp;
	public int PDamage;
	public int PDefense;
	public int PSkillnum;
	
	void setPHp() {
		this.PHp = 20 + D6.nextInt(1,6)*2;
		System.out.printf("주사위를 통해 정해진 당신의 체력은 %d입니다",PHp);
	}
	
	
	
//후에 보드 넘버에 따른 추가 체력 계수 줄 예정
}
