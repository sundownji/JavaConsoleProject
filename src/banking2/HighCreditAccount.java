package banking2;

public class HighCreditAccount extends Account {
	//기본이자, 신용등급
	String highcredit;
	int inter;

	//생성자
	public HighCreditAccount(String accountNumber,String name, int balance, int inter, String highcredit) {
		super(accountNumber,name,balance);
		this.inter=inter;
		this.highcredit=highcredit;
	}
	
	public String getHighcredit() {
		return highcredit;
	}


	public void setHighcredit(String highcredit) {
		this.highcredit = highcredit;
	}


	public int getNomalNum() {
		return inter;
	}


	public void setNomalNum(int nomalNum) {
		this.inter = inter;
	}
	
	
	@Override
	public void accountInfo() {
		super.accountInfo();
		System.out.println("기본이자>"+inter);
		System.out.println("신용등급>"+highcredit);
	}
	



	
	public static void main(String[] args) {
	
	

	}

}
