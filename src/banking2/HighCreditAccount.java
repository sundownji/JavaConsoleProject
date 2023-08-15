package banking2;

import banking2.Account;

public class HighCreditAccount extends Account {
	//기본이자, 신용등급
	private String highcredit;
	private double inter;

	//생성자
	public HighCreditAccount(String accountNumber,String name, int balance, int inter, String highcredit) {
		super(accountNumber,name,balance);
		this.inter=inter/100.0;
		this.highcredit=highcredit;
	}
	
	public String getHighcredit() {
		return highcredit;
	}


	public void setHighcredit(String highcredit) {
		this.highcredit = highcredit;
	}


	public double getNomalNum() {
		return inter;
	}


	public void setNomalNum(int nomalNum) {
		this.inter = inter;
	}
	
	@Override
	public boolean plusAccMoney(int money) {
		switch(highcredit) {
		case "A": case "a":
		super.balance=(int)(super.balance + (super.balance * inter)+ (super.balance * 0.07)+ money);
		break;
		case "B": case "b":
		super.balance=(int)(super.balance + (super.balance * inter)+ (super.balance * 0.04)+ money);
		break;
		case "C": case "c":
		super.balance=(int)(super.balance + (super.balance * inter)+ (super.balance * 0.04)+ money);
		break;
	}
	return true;
	}
	@Override
	public void accountInfo() {
		super.accountInfo();
		System.out.println("기본이자 >"+(int)(inter*100)+"%");
		System.out.println("신용등급 >"+highcredit);
		System.out.println(" ");
	}
	


}
