package banking3;

public class MenuSelectException extends Exception{

	public MenuSelectException()  {
		super("지정된 정수 이외의 숫자를 입력하셨습니다.");
	}

}
