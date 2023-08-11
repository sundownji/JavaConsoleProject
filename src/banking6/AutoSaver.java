package banking6;

public class AutoSaver extends Thread {

		
	@Override
	public void run() {
	
		while(true) {
			try {
				sleep(5000);
				System.out.println("자동저장 됐습니다.");
			}
			catch(InterruptedException e) {
				break;
			}
		}
	}
}
