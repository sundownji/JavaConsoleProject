package banking2;

import java.util.Scanner;

public class NormalAccount extends Account{
	//노멀어카운트(자식)에서 확장된 멤버변수 기본이자
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
	
	//오버라이딩
	/*오버라이딩(Overriding)
	 :클래스가 상속관계에 있을 때 하위클래스에서 상위클래스의 멤버메서드와 완전히 동일한
	 모양으로 메서드를 재정의 하는 것을 말한다.
	 
	 하위클래스에서 오버라이딩한 메서드는 상위클래스의 메서드를 가리게 되므로
	 항상 하위 클래스에서 오버라이딩한 메서드가 호출된다. */
	@Override
	public boolean plusAccMoney(int money) {
		super.balance = (int)(super.balance + (super.balance * inter)+money);
		return true;
	}


	@Override
	public void accountInfo() {
		super.accountInfo();
		System.out.println("기본이자 >"+(int)(inter*100)+"%");
		System.out.println("-----------------------------");
		System.out.println(" ");
	
	}
	
	


	public static void main(String[] args) {

	}

}
