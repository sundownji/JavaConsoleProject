package banking3;

public class MenuSelectException extends Exception{

	public MenuSelectException()  {
		super();
	}
	
	public void SelectException() {
	System.out.println("지정된 정수 숫자외의 숫자를 입력해주세요.");
	}

}
