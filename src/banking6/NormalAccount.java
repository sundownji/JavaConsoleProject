package banking6;

import java.util.Scanner;

public abstract class NormalAccount extends Account{
	//기본이자 변수
	double inter;
	
	//생성자
	public NormalAccount (String accountNumber,String name, int balance, int inter ) {
		//Account에서 상속받은 것 먼저 작성
		super(accountNumber,name,balance);
		this.inter= inter/100.0;
	}
	
	public double getNomalNum() {
		return inter;
	}
	
	public void setNormalNum(int inter) {
		this.inter = inter;
	}
	
	@Override
	public void plusAccMoney(int money) {
		super.setBalance((int)(super.getBalance() + (super.getBalance() * inter)+money));
	
	}
	
	@Override
	public void accountInfo() {
		System.out.println("----------------------------");
		super.accountInfo();
		System.out.println("기본이자>"+(int)(inter*100)+"%");
	
	}
	@Override
	public String toString() {
		String str = String.format(getAccountNumber(), getAccountNumber(), getName(), getBalance(), (int)(inter*100));
	}
	


}