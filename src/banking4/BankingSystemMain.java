package banking4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankingSystemMain {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		AccountManager amanager = new AccountManager();
		
		while (true) {
				amanager.showMenu();
			try {
				System.out.print("선택:");
				int choice = scan.nextInt();
				scan.nextLine();
				
				switch (choice) {
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
					amanager.delectInfo();
					break;
				case ICustomDefine.EXIT:
					System.out.println("프로그램을 종료합니다.");
					return;
				default:
					String errMsg = "지정된 숫자만 입력해주세요 ";
					MenuSelectException ex = new MenuSelectException(errMsg);
					throw ex;
						
					
				}
			}
	
			catch(InputMismatchException e) {
				System.out.println("문자를 입력하셨습니다. 지정된 숫자만 입력해주세요.");
				scan.nextLine();
			}
			
			catch(MenuSelectException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
}