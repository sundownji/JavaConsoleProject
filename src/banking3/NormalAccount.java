package banking3;

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
	public boolean plusAccMoney(int money) {
		super.balance = (int)(super.balance + (super.balance * inter)+money);
		return true;
	}
	
	@Override
	public void accountInfo() {
		System.out.println("----------------------------");
		super.accountInfo();
		System.out.println("기본이자>"+(int)(inter*100)+"%");
	
	}
	
	


	public static void main(String[] args) {

	}

}
