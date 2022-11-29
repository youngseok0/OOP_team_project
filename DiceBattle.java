package teamproject;

import java.util.Random;
import java.util.Scanner;

public class DiceBattle {
	static void Rolldice() {
		Random D6 = new Random();
		System.out.println("주사위를 세번 굴립니다. 나온 숫자는!");
		int[] dices = new int[3];
		for(int i =0; i<3;i++) {
			dices[i] = D6.nextInt(1,7);
			System.out.println(dices[i]);
		}		
	}
	
	
	
	public static void main(String[] args) {
		Enemy enemy = new Enemy();
		System.out.println("적이 나타났습니다.");
		enemy.setEnemyHp();
		enemy.setEnemyDamage();
		enemy.check();
		Rolldice();
		
	}
}

class Enemy{
	Random D6 = new Random();
	
	int EHP;
	int EDamage;
	
	void setEnemyHp() {
		this.EHP = 18 + D6.nextInt(-6,10);
	}
	
	void setEnemyDamage() {
		this.EDamage = 6 + D6.nextInt(-5,6);
	}
	
	void check() {
		System.out.println("적의 체력: "+ EHP +"\n적의 공격 데미지: "+ EDamage);
	}
}

class MyCha {
	
}
