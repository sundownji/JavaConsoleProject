package banking1;

import java.util.Scanner;

public class BankingSystemMain {
	public static Scanner scan = new Scanner(System.in);
	static Account[] acc = new Account[50];
	//배열에 저장된 계좌 정보를 카운트하기 위한 멤버변수
	static int numofAccounts = 0;		
	
		
	public static void showMenu() {
		System.out.println("-----Menu-----");
		System.out.println("1.계좌개설");
		System.out.println("2.입   금");
		System.out.println("3.출   금");
		System.out.println("4.계좌정보출력");
		System.out.println("5.프로그램종료");
	}
	
	
	public static void makeAccount() { //계좌개설을 위한 함수 
		System.out.println("***신규계좌개설***");
		Scanner scan = new Scanner(System.in);
		System.out.println("계좌번호:");
		String accNum= scan.nextLine();
		System.out.println("고객이름:");
		String accName = scan.nextLine();
		System.out.println("잔고:");
		int bal = scan.nextInt();
		acc[numofAccounts++] = new Account(accNum,accName,bal);
		System.out.println("계좌가 생성되었습니다.");
	}
		


	
	
	public static void depositMoney() {//입금 
		Scanner scan = new Scanner(System.in);
		System.out.println("계좌번호와 입금할 금액을 입력하세요");
		System.out.println("계좌번호:");String accNum = scan.nextLine();
		System.out.println("입금액:");int money =scan.nextInt();
		for (int i = 0; i< numofAccounts; i++) {
			if (acc[i].getAccountNumber().equals(accNum)) {
				acc[i].plusAccMoney(money);
				System.out.println("입금이 완료되었습니다.");
				break;
			}
		}	
	}
	
	public static void withdrawMoney() {//출금 
		Scanner scan = new Scanner(System.in);
		System.out.println("***출  금***");
		System.out.println("계좌번호와 출금할 금액을 입력하세요.");
		System.out.println("계좌번호:");String accNum = scan.nextLine();
		System.out.println("출금액:");int money = scan.nextInt();
		for (int i = 0; i< numofAccounts; i++) {
			if (acc[i].getAccountNumber().equals(accNum)) {
				acc[i].minusAccMoney(money);
				System.out.println("출금이 완료되었습니다.");
				break;
			}
		}
	}

	
	public static void showAccInfo() {// 전체계좌정보출력
		System.out.println("****계좌정보출력****");
		System.out.println("---------------------");
		for(int i = 0; i<numofAccounts; i++) {
			acc[i].accountInfo();
		}
		
		System.out.println("전체계좌정보 출력이 완료되었습니다.");
	}
		
	public static void main(String[] args) {
			
			while (true) {
				showMenu();
				int selNum = scan.nextInt();
			switch (selNum) {
			case MenuChoice.MAKE:
				makeAccount();
				break;
			case MenuChoice.DEPOSIT:
				depositMoney();
				break;
			case MenuChoice.WITHDRAW:
				withdrawMoney();
				break;
			case MenuChoice.INQUIRE:
				showAccInfo();
				break;
			case MenuChoice.EXIT:
				System.out.println("프로그램을 종료합니다.");
				return;
			}

			}
	}
}
