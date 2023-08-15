package banking6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class AccountManager {
	
	public static Scanner scan = new Scanner(System.in);
	
	//인스턴스배열을 컬렉션으로 변경
	Set<Account> accountset = new HashSet<Account>();	
	
	//자동저장 객체 
	AutoSaver saver = new AutoSaver(this);
	


	public Set<Account> getAccountset() {
		return accountset;
	}


	public void setAccountset(Set<Account> accountset) {
		this.accountset = accountset;
	}
	


	public void showMenu() {
		System.out.println("------------------------------------------Menu-----------------------------------------------");
		System.out.print(" 1. 계좌개설 |");
		System.out.print(" 2. 입   금 |");
		System.out.print(" 3. 출   금 |");
		System.out.print(" 4. 계좌정보출력 |");
		System.out.print(" 5. 계좌정보삭제 |");
		System.out.print(" 6. 저장옵션  |");
		System.out.println(" 7. 프로그램 종료");
		System.out.println("---------------------------------------------------------------------------------------------");
	}
	

	public void makeAccount() { //계좌개설을 위한 함수 
		System.out.println("--------------------------------------<신규계좌개설>--------------------------------------------");
		System.out.println("계좌선택:1.보통예금계좌 / 2.신용신뢰계좌");
		System.out.print("선택:");int choice1 = scan.nextInt();
		scan.nextLine();
		
		System.out.print("계좌번호:");String accNum= scan.nextLine();
		for(Account acc : accountset) {
			if(acc.getAccountNumber().equals(accNum)) {
				System.out.println("중복된 계좌가 발견되었습니다.");
				System.out.println("중복된 계좌에 덮어쓸까요? (Y/N)"); String yn = scan.nextLine();
				switch(yn.toUpperCase()) {
				case "Y":
					accountset.remove(acc);
					System.out.println("덮어쓰기에 성공했습니다.");
					break;
				case "N":
					System.out.println("취소됐습니다.");
					return;
				}
				
			}
		}
		
		
		System.out.print("고객이름:");String accName = scan.nextLine();
		System.out.print("잔   고:");int bal = scan.nextInt();
		scan.nextLine();
		System.out.print("기본이자%(정수형태로 입력):");int inter = scan.nextInt();
		scan.nextLine();
	
		Account acct = null;
		boolean flag = false;
		switch (choice1) {
		case 1:
			 acct = new NormalAccount(accNum,accName,bal,inter);
			 flag = accountset.add(acct);
			 break;

		case 2:
			System.out.print("신용등급(A,B,C등급):");String highcredit = scan.nextLine(); 
			acct = new HighCreditAccount(accNum,accName,bal,inter,highcredit);
			flag = accountset.add(acct);
			break;
		}
			System.out.println("계좌가 생성되었습니다.");
	}
	
	
	
	public void depositMoney() {//입금 
		System.out.println("------------------------------------------<입 금>---------------------------------------------");
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
				scan.nextLine();
				System.out.println("숫자만 입력해주세요.");
			}
		}
		if(money<0 || money%500!=0) {
			System.out.println("입금은 500원 단위의 양수만 가능합니다.");
		}
		else {
			for (Account acc : accountset) {
				if (acc.getAccountNumber().equals(accNum)) {
					acc.plusAccMoney(money);
					System.out.println("입금이 완료되었습니다.");
					return;
				}		
			}	
			System.out.println("존재하지 않는 계좌번호입니다.");					
		}
	}

	
	public void withdrawMoney(){//출금 
		System.out.println("------------------------------------------<출 금>---------------------------------------------");
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
			for(Account acc : accountset) {
					if(acc.getAccountNumber().equals(accNum)) {
						if(minusmoney <= acc.getBalance()) {
							acc.minusAccMoney(minusmoney);
							System.out.println("출금이 완료되었습니다.");
							break;	
						}
						else {
							System.out.println("잔고가 부족합니다.");
							System.out.println("금액 전체를 출금할까요? (Y/N)" );
							char yn = scan.next().charAt(0);
							switch(yn) {
							case 'Y' : case 'y':
								System.out.println(acc.getBalance()+"원을 전부 출금했습니다.");
								acc.setBalance(0);
								break;
							case 'N' : case 'n':
								System.out.println("출금이 취소되었습니다.");
								return;
							default : System.out.println("문자 Y 또는 N만 입력 가능합니다. ");
							
							}
							return;
							
						}
					}
					else {
						System.out.println("입력하신 계좌가 없습니다.");
					
					}
				}
					
			}
		}

	
	public void saveInfo() {
		System.out.println("-----------------------------------------<저장옵션>--------------------------------------------");
		System.out.println("1.자동저장 On, 2.자동저장 Off");
		int choiceSave = scan.nextInt();
		scan.nextLine();
	
		
		switch(choiceSave) {
		case 1:
			if(saver != null && saver.isAlive()) {
				System.out.println("이미 자동저장이 실행 중입니다.");
				return;
			}
			saver = new AutoSaver(this);
			saver.setDaemon(true);
			saver.start();
			System.out.println("자동저장이 시작됐습니다.");
			break;
		case 2:
			if(saver != null && saver.isAlive()) {
				saver.interrupt();
				System.out.println("자동저장이 종료되었습니다.");
			}
			else
				System.out.println("자동저장 실행 중이 아닙니다. ");
			break;
		}
	}
	
	public void delectInfo(){//계좌정보삭제
		System.out.println("----------------------------------------<계좌정보삭제>------------------------------------------");
		System.out.println("삭제할 계좌번호를 입력하세요.");
		System.out.print("계좌번호:");
		String accNum = scan.nextLine();
	
		
		for(Account acc : accountset) {
			if(acc.getAccountNumber().equals(accNum)) {
				accountset.remove(acc);
				System.out.println("삭제되었습니다.");
			}
			else {
				System.out.println("존재하지않는 계좌번호입니다.");
			}	
		}
	}


	public void showAccInfo() {// 전체계좌정보출력
		System.out.println("----------------------------------------<계좌정보출력>------------------------------------------");
	
		for(Account acc : accountset) {
			acc.accountInfo();
		}
		
		System.out.println("전체 계좌 정보 출력이 완료되었습니다.");
	}
	
	//컬렉션 불러오기 
	public void objectInput() {
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/banking6/AccountInfo.obj"));
			accountset = (Set<Account>)in.readObject();
			in.close();
			
		}
		catch(ClassNotFoundException e) {
			System.out.println();
		}
		catch(IOException e){
			System.out.println("없다.");
			
		}	
	}
	//저장하기 
	public void objectOutput() {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/banking6/AccountInfo.obj"));
			
//			for(Account acc :accountset) {
//				out.writeObject(acc);
//			}
			out.writeObject(accountset);
			out.close();
			System.out.println("저장이 완료되었습니다.");
		}
		
		catch(FileNotFoundException e) {
			System.out.println("파일 없다 ");
		}
		catch(IOException e) {
			System.out.println("없다");
			e.printStackTrace();
		}
		
	}

	
	

}
