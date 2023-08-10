package banking5;

import java.util.Scanner;

public class NormalAccount extends Account{
	//기본이자 변수
	double inter;
	
	//생성자
	public NormalAccount (String accountNumber,String name, int balance, int inter ) {
		//Account에서 상속받은 것 먼저 작성
		super(accountNumber,name,balance);
		this.inter= inter/100.0;
	}
	
	//겟터
	public double getNomalNum() {
		return inter;
	}
	//세터
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
	


}
