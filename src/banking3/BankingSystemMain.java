package banking3;

import java.util.Scanner;

import banking2.AccountManager;

public class BankingSystemMain {
	public static void showMenu() {
		System.out.println("-----Menu------------");
		System.out.println("1.계좌개설");
		System.out.println("2.입   금");
		System.out.println("3.출   금");
		System.out.println("4.계좌정보출력");
		System.out.println("5.프로그램종료");
		System.out.println("----------------------");
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		AccountManager amanager = new AccountManager(50);
		
			while (true) {
				amanager.showMenu();
				int selNum = scan.nextInt();
			switch (selNum) {
			case MenuChoice.MAKE:
				amanager.makeAccount();
				break;
			case MenuChoice.DEPOSIT:
				amanager.depositMoney();
				break;
			case MenuChoice.WITHDRAW:
				amanager.withdrawMoney();
				break;
			case MenuChoice.INQUIRE:
				amanager.showAccInfo();
				break;
			case MenuChoice.EXIT:
				System.out.println("프로그램을 종료합니다.");
				return;
			}
	
	
	
	

			}
	}
}