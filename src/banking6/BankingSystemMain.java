package banking6;

import java.util.InputMismatchException;
import java.util.Scanner;


/*IO관련 작업에서는 많은 부분에서 예외처리가 필요하다. 이때 예외를 throws하는 것보다
	try~catch로 예외처리를 해주는 것을 권장한다. 예외를 무시하면 문제가 생겼을 때 
	적절한 조치를 취하기 힘들기 때문이다.*/
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