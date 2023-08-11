package banking6;


import java.io.Serializable;


import java.util.Scanner;

public abstract class Account implements Serializable{
	
	private String accountNumber; //계좌번호(String형)
	private String name; //이름(String형)
	private int balance; //잔액(int형)

	//생성
	public Account(String accountNumber,String name, int balance) {
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
	
	}
	
	//계좌정보메소드
	public void accountInfo() {
	System.out.println("계좌번호 >"+accountNumber);
	System.out.println("고객이름 >"+name);
	System.out.println("잔고 >"+balance);

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
	
	public void plusAccMoney(int money) {
		balance += money;
		
		
	}
	public void minusAccMoney(int money) {
		balance -= money;
		
		
	}
	
	@Override
	public abstract String toString();

}
	


	



	
		
		
		
		
		
		
	


