package banking5;

import java.util.Scanner;

public class BankingSystemMain {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		AccountManager amanager = new AccountManager();
		
			while (true) {
				amanager.showMenu();
				int selNum = scan.nextInt();
				
				switch (selNum) {
				case ICustomDefine.MAKE:
					amanager.makeAccount();
					break;
				case ICustomDefine.DEPOSIT:
					amanager.depositMoney();
					break;
				case ICustomDefine.WITHDRAW:
					amanager.withdrawMoney();
					break;
				case ICustomDefine.INQUIRE:
					amanager.showAccInfo();
					break;
				case ICustomDefine.DELETE:
					amanager.showAccInfo();
					break;
				case ICustomDefine.EXIT:
					System.out.println("프로그램을 종료합니다.");
					return;
			}
		
		}
	}
}