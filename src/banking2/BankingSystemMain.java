package banking2;

import java.util.Scanner;

import banking2.AccountManager;

public class BankingSystemMain {

	
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