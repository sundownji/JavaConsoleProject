package banking2;

import java.util.Scanner;
import banking2.HighCreditAccount;

public class AccountManager  {

	static Account[] acc = new Account[50];
	//배열에 저장된 계좌 정보를 카운트하기 위한 멤버변수
	static int numofAccounts = 0;		
	
	//생성자
	public AccountManager(int num) {
		acc = new Account[num];
		numofAccounts = 0;
	}
	
	public void showMenu() {
		System.out.println("-----------------------------Menu---------------------------------");
		System.out.print(" 1. 계좌개설 |");
		System.out.print(" 2. 입   금 |");
		System.out.print(" 3. 출   금 |");
		System.out.print(" 4. 계좌정보출력 |");
		System.out.println(" 5. 프로그램종료 ");
		System.out.println("------------------------------------------------------------------");
		System.out.print("선택:");
	}
	
	
	public static void makeAccount() { //계좌개설을 위한 함수 
		Scanner scan = new Scanner(System.in);
		System.out.println("--------------------------<신규계좌개설>------------------------------");
		System.out.println("계좌선택:1.보통예금계좌 / 2.신용신뢰계좌");
		System.out.print("선택   :");int choice = scan.nextInt();
		scan.nextLine();
		
		System.out.print("계좌번호:");String accNum= scan.nextLine();
		System.out.print("고객이름:");String accName = scan.nextLine();
		System.out.print("잔   고:");int bal = scan.nextInt();
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
	
		

	public static void depositMoney() {//입금 
		System.out.println("----------------------------<입 금>--------------------------------");
		Scanner scan = new Scanner(System.in);
		System.out.println("계좌번호와 입금할 금액을 입력하세요");
		System.out.print("계좌번호:");String accNum = scan.nextLine();
		System.out.print("입금액 :");int money =scan.nextInt();
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
		System.out.println("----------------------------<출 금>--------------------------------");
		System.out.println("계좌번호와 출금할 금액을 입력하세요.");
		System.out.print("계좌번호:");String accNum = scan.nextLine();
		System.out.print("출금액 :");int money = scan.nextInt();
		for (int i = 0; i< numofAccounts; i++) {
			if (acc[i].getAccountNumber().equals(accNum)) {
				acc[i].minusAccMoney(money);
				System.out.println("출금이 완료되었습니다.");
				break;
			}
		}
	}

	
	
	public static void showAccInfo() {// 전체계좌정보출력
		System.out.println("---------------------------<계좌정보출력>-----------------------------");
	
		for(int i = 0; i<numofAccounts; i++) {
			acc[i].accountInfo();
		}
		System.out.println("--------------------------");
		
		System.out.println("전체계좌정보 출력이 완료되었습니다.");
	}
	
	

}
