package banking3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankingSystemMain {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		AccountManager amanager = new AccountManager(50);
		
		while (true) {
			amanager.showMenu();
			try {
				System.out.print("선택:");
				int selNum = scan.nextInt();
				scan.nextLine();
				
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
				case ICustomDefine.EXIT:
					System.out.println("프로그램을 종료합니다.");
					return;
				}
		
			}
			catch(InputMismatchException e){
				System.out.println("숫자를 입력하세요.");
				scan.nextLine();
			}
			}
	}
}