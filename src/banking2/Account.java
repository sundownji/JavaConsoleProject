package banking2;

import java.io.Serializable;
import java.util.Scanner;

//메뉴 따로 빼기. -> menu로 이름 바꾸기
//account, normal,high -> 
//계좌정보, 계좌주 이름 
/*질문 多 */
//hashset -> 중복계좌 웅앵
//thread -> 자동저장
public class Account{
	
	private String accountNumber; //계좌번호(String형)
	private String name; //이름(String형)
	int balance; //잔액(int형)

		
	public Account(String accountNumber,String name, int balance) {
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
	
	}
	
	public void accountInfo() {
	System.out.println("계좌번호 >"+accountNumber);
	System.out.println("고객이름 >"+name);
	System.out.println("잔고    >"+balance);
	

	}
	
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public boolean plusAccMoney(int money) {
		balance += money;
		return true;
		
	}
	public boolean minusAccMoney(int money) {
		balance -= money;
		return true;
	}


	
	
	}


	



	
		
		
		
		
		
		
	


