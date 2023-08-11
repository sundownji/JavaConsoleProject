package banking6;

public abstract class HighCreditAccount extends Account {
	//기본이자, 신용등급
	private String highcredit;
	private double inter;
	

	//생성자
	public HighCreditAccount(String accountNumber,String name, int balance, int inter, String highcredit) {
		super(accountNumber,name,balance);
		this.inter=inter / 100.0;
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
	public void plusAccMoney(int money) {
		switch(highcredit) {
		case "A": case "a":
		super.setBalance((int)(super.getBalance() + (super.getBalance() * inter)+ (super.getBalance() * 0.07)+ money));
		break;
		case "B": case "b":
		super.setBalance((int)(super.getBalance() + (super.getBalance() * inter)+ (super.getBalance() * 0.04)+ money));
		break;
		case "C": case "c":
		super.setBalance((int)(super.getBalance() + (super.getBalance() * inter)+ (super.getBalance() * 0.04)+ money));
		break;
	}
	
	}
	@Override
	public void accountInfo() {
		super.accountInfo();
		System.out.println("기본이자>"+(int)(inter*100)+"%");
		System.out.println("신용등급>"+highcredit);
	}
	
	@Override
	public String toString() {
		String str = String.format("[신계좌], %s, %s, %d, %d", getAccountNumber(), getName(), getBalance(), (int)(inter*100),highcredit);
		return null;
	}
	


}
