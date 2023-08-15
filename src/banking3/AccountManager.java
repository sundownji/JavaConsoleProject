package banking3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AccountManager {
	
	public static Scanner scan = new Scanner(System.in);
	private Account[] acc ;
 	//배열에 저장된 계좌 정보를 카운트하기 위한 멤버변수
	private int numofAccounts = 0;
	
	public AccountManager(int n) {
		acc = new Account[n];
	}
	
	
	public void showMenu() {
		System.out.println("-----------------------------Menu---------------------------------");
		System.out.print(" 1. 계좌개설 |");
		System.out.print(" 2. 입   금 |");
		System.out.print(" 3. 출   금 |");
		System.out.print(" 4. 계좌정보출력 |");
		System.out.println(" 5. 프로그램종료 ");
		System.out.println("------------------------------------------------------------------");

	}

	public void makeAccount() { //계좌개설을 위한 함수 
	
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
		switch (choice) {
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
	


	public void depositMoney() {//입금 
		System.out.println("----------------------------<입 금>--------------------------------");
		System.out.println("계좌번호와 입금할 금액을 입력하세요");
		System.out.print("계좌번호:");  
		String accNum = scan.nextLine();
		
		int money;
		while (true) {
			try {
				System.out.print("입금액:"); 
				money = scan.nextInt();
				scan.nextLine();
				break;
			} catch (InputMismatchException e) {
				scan.nextLine();//버퍼비워주기 
				System.out.println("숫자만 입력해주세요.");
			}
		}
		if(money<0 || money%500!=0) {
			System.out.println("입금은 500원 단위의 양수만 가능합니다.");
		}
		else {
			for (int i = 0; i< numofAccounts; i++) {
				if (acc[i].getAccountNumber().equals(accNum)) {
					acc[i].plusAccMoney(money);
					System.out.println("입금이 완료되었습니다.");
					return;
				}
				
			}	
			System.out.println("존재하지 않는 계좌번호입니다.");					
		}
		
	}

	public void withdrawMoney(){//출금 
		System.out.println("----------------------------<출 금>--------------------------------");
		System.out.println("계좌번호와 출금할 금액을 입력하세요.");
		System.out.print("계좌번호:");String accNum = scan.nextLine();
		
		int minusmoney;
		while (true) {
			try {
				System.out.print("출금액:");
				minusmoney = scan.nextInt();
				scan.nextLine();
				break;
			}
			catch (InputMismatchException e) {
			scan.nextLine();
			System.out.println("숫자만 입력해주세요.");
			}
			
		}
		if(minusmoney<0 || minusmoney % 1000!=0) {
			System.out.println("출금은 1000단위 양수만 가능합니다.");
		}
		else {
				for(int i=0; i<numofAccounts; i++) {
					if(acc[i].getAccountNumber().equals(accNum)) {
						if(minusmoney <= acc[i].getBalance()) {
							acc[i].minusAccMoney(minusmoney);
							System.out.println("출금이 완료되었습니다.");
							break;	
						}
						else {
							System.out.println("잔고가 부족합니다.");
							System.out.println("금액 전체를 출금할까요? (Y/N)" );
							char yn = scan.next().charAt(0);
							switch(yn) {
							case 'Y' : case 'y':
								System.out.println(acc[i].getBalance()+"원을 전부 출금했습니다.");
								acc[i].setBalance(0);
								break;
							case 'N' : case 'n':
								System.out.println("출금이 취소되었습니다.");
								return;
							default : System.out.println("문자 Y 또는 N만 입력 가능합니다. ");
							
							}
							
						}
					}
					else {
						System.out.println("입력하신 계좌가 없습니다.");
					}
					
				}
			
			}
		}
			
	


	public void showAccInfo() {// 전체계좌정보출력
		System.out.println("---------------------------<계좌정보출력>-----------------------------");
		
		for(int i = 0; i<numofAccounts; i++) {
			acc[i].accountInfo();
		}
		System.out.println("--------------------------");
		
		System.out.println("전체 계좌 정보 출력이 완료되었습니다.");
	}
	
	

}
