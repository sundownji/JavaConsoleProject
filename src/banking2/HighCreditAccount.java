package banking2;

import banking2.Account;

/*상속(Inheritance): 기존에 정의된 클래스에 메서드와 변수를 추가하여 새로운 클래스를
정의하는 것을 말한다. 부모 클래스를 자식 클래스가 상속할 때는 extends 키워드를 사용한다. */
public class HighCreditAccount extends Account {
	//하이크레딧어카운트(자식)에서 확장된 멤버변수 기본이자, 신용등급
	private String highcredit;
	private double inter;

	//생성자
	//super를 통해 부모 먼저 호출
	
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
	/*오버라이딩(Overriding)
	 :클래스가 상속관계에 있을 때 하위클래스에서 상위클래스의 멤버메서드와 완전히 동일한
	 모양으로 메서드를 재정의 하는 것을 말한다.
	 
	 하위클래스에서 오버라이딩한 메서드는 상위클래스의 메서드를 가리게 되므로
	 항상 하위 클래스에서 오버라이딩한 메서드가 호출된다. */
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
