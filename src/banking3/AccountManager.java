package banking3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AccountManager extends Account {

	static Account[] acc = new Account[50];
	//배열에 저장된 계좌 정보를 카운트하기 위한 멤버변수
	static int numofAccounts = 0;		
	
	

	public AccountManager(String accountNumber, String name, int balance) {
		super(accountNumber, name, balance);

	}


	
	public void showMenu() {
		System.out.println("----------Menu----------");
		System.out.println("1.계좌개설");
		System.out.println("2.입   금");
		System.out.println("3.출   금");
		System.out.println("4.계좌정보출력");
		System.out.println("5.프로그램종료");
		System.out.print("선택:");
	}
	

	public static void makeAccount() { //계좌개설을 위한 함수 
		Scanner scan = new Scanner(System.in);
		System.out.println("***신규계좌개설***");
		System.out.println("----계좌선택----");
		System.out.println("1.보통계좌");
		System.out.println("2.신용신뢰계좌");
		try {
			System.out.print("선택:");int choice = scan.nextInt();
			scan.nextLine();
		
		if(choice != 1 && choice !=2) {
			System.out.println("잘못 선택하셨습니다.");
			return;
		}
		
		
		System.out.print("계좌번호:");String accNum= scan.nextLine();
		System.out.print("고객이름:");String accName = scan.nextLine();
		System.out.print("잔고:");int bal = scan.nextInt();
		scan.nextLine();
		System.out.print("기본이자%(정수형태로 입력):");int inter = scan.nextInt();
		scan.nextLine();
	
		Account acct = null;
		switch(choice) {
		case 1:
			 acct = new NormalAccount(accNum,accName,bal,inter);
			 break;

		case 2:
			System.out.print("신용등급(A,B,C등급):");String highcredit = scan.nextLine(); 
			acct = new HighCreditAccount(accNum,accName,bal,inter,highcredit);
			break;
		}
	
			acc[numofAccounts++] = acct;
			
			System.out.println("계좌가 생성되었습니다.");
		}
	
	catch(InputMismatchException e) {
		System.out.println("숫자를 제대로 입력하십쇼.");
	}
}


	public static void depositMoney() {//입금 
		Scanner scan = new Scanner(System.in);
		System.out.println("계좌번호와 입금할 금액을 입력하세요");
		try {
			System.out.print("계좌번호:");String accNum = scan.nextLine();
			for(int i=0; i<numofAccounts; i++) {
				if(!(acc[i].getAccountNumber().equals(accNum))) {
					System.out.println("존재하지 않는 계좌번호입니다.");
					return;
				}
			}
		
		System.out.print("입금액:");int money =scan.nextInt();scan.nextLine();
			for (int i = 0; i< numofAccounts; i++) {
				if (acc[i].getAccountNumber().equals(accNum)) {
					if(money<0) {
						System.out.println("0원 이하는 입금이 불가능합니다.");
						return;
					}
					else if(money % 500 != 0) {
						System.out.println("입금은 500원 단위로 가능합니다.");
						return;
					}
				}
				else {	
					acc[i].plusAccMoney(money);
					System.out.println("입금이 완료되었습니다.");
					break;
				}
			}	
		}
		catch(InputMismatchException e) {
			System.out.println("다시 입력해주세요.");
		}
		catch(NumberFormatException e) {
			System.out.println("다시 입력해주세요.");
		}
		
}
	
	public void withdrawMoney(){//출금 
		Scanner scan = new Scanner(System.in);
		System.out.println("***출  금***");
		System.out.println("계좌번호와 출금할 금액을 입력하세요.");
			System.out.print("계좌번호:");String accNum = scan.nextLine();
			for(int i=0; i<numofAccounts; i++) {
				if(!(acc[i].getAccountNumber().equals(accNum))) {
					System.out.println("존재하지 않는 계좌번호입니다.");
					return;
				}
			}
		
		System.out.print("출금액:");int minusmoney = scan.nextInt();scan.nextLine();
		for (int i = 0; i< numofAccounts; i++) {
			if (acc[i].getAccountNumber().equals(accNum)) {
				if(minusmoney < 0) {
					System.out.println("0원 이하의 금액은 출금할 수 없습니다.");
					return;
				}
				else if(minusmoney % 1000!=0) {
					System.out.println("출금은 1000원 단위만 가능합니다.");
					return;
				}	
			}
			else if(minusmoney>getBalance()) {
				System.out.println("잔고가 부족합니다. 금액전체를 출금할까요?");
				System.out.println("YES or NO");
				System.out.println("선택:"); String icecho = scan.nextLine();
				
				if(icecho.equals("Y") || icecho.equals("y")) {
					System.out.println("금액 전체를 출금처리합니다.");	
				}
				else if(icecho.equals("N") || icecho.equals("n")) {
					System.out.println("출금요청을 취소합니다.");
				}
				return;
				
			}
				acc[i].minusAccMoney(minusmoney);
				System.out.println("출금이 완료되었습니다.");
//				break;
		
		}
	}
	
	
	



	public static void showAccInfo() {// 전체계좌정보출력
		System.out.println("****계좌정보출력****");
		System.out.println("---------------------");
		for(int i = 0; i<numofAccounts; i++) {
			acc[i].accountInfo();
		}
		System.out.println("----------------------");
		
		System.out.println("전체계좌정보 출력이 완료되었습니다.");
	}
	
	

}
