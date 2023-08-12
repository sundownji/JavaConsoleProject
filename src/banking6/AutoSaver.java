package banking6;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;



public class AutoSaver extends Thread {

	AccountManager am;
	
	public AutoSaver(AccountManager am) {
		super();
		this.am = am;
	}

		
	@Override
	public void run() {
	
		while(true) {
			try {
				sleep(5000);
				PrintWriter out = new PrintWriter(new FileWriter("src/banking6/AutoSaveAccount.txt"));
				for(Account acc : am.getAccountset()){
					out.printf("%s\n",acc.toString());
				}
				System.out.println("자동저장 됐습니다.");
			}
			catch(InterruptedException e) {
				break;
			}
			catch(FileNotFoundException e) {
				break;
			}
			catch(IOException e) {
				break;
			}
		}
	}
}
