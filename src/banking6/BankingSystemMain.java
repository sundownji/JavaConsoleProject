package banking6;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankingSystemMain implements ICustomDefine {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		AccountManager amanager = new AccountManager();
		amanager.objectInput();//여기서 채워져
		
		while (true) {
				amanager.showMenu();
			try {
				System.out.print("선택:");
				int choice = scan.nextInt();
				scan.nextLine();
				
				switch (choice) {
				case MAKE:
					amanager.makeAccount();
					break;
				case DEPOSIT:
					amanager.depositMoney();
					break;
				case WITHDRAW:
					amanager.withdrawMoney();
					break;
				case INQUIRE:
					amanager.showAccInfo();
					break;
				case DELETE:
					amanager.delectInfo();
					break;
				case AUTOSAVE:
					amanager.saveInfo();
					break;
				case EXIT:
					System.out.println("프로그램을 종료합니다.");
					amanager.objectOutput();
					return;
				default:
					String errMsg = "지정된 숫자만 입력해주세요 ";
					MenuSelectException ex = new MenuSelectException(errMsg);
					throw ex;
						
					
				}
			}
	
			catch(InputMismatchException e) {
				System.out.println("문자를 입력하셨습니다. 다시 입력해주세요.");
				scan.nextLine();
			}
			
			catch(MenuSelectException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
}