import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class SikuliWithCK {

	public static void main(String[] args) throws InterruptedException {
		
		Screen screen= new Screen();
		
		Pattern emailText=new Pattern("E:\\Learnings\\Sikuli\\Image\\EmailText.png");
		Pattern passwordText=new Pattern("E:\\Learnings\\Sikuli\\Image\\NewPassword.png");
		//Pattern cancel=new Pattern("E:\\Learnings\\Sikuli\\Image\\Cancel.png");
		Pattern agree=new Pattern("E:\\Learnings\\Sikuli\\Image\\IAgree.png");
		Pattern dropDown=new Pattern("E:\\Learnings\\Sikuli\\Image\\Gender.png");
		Pattern dropDownMale=new Pattern("E:\\Learnings\\Sikuli\\Image\\MaleGender.png");
		//Pattern scrollBar=new Pattern("E:\\Learnings\\Sikuli\\Image\\Scrollbar.png");
		
		
		WebDriver driver=new FirefoxDriver();
		driver.get("https://uk.calvinklein.com/store/UserRegistrationForm?new=Y&catalogId=10051&myAcctMain=&langId=-1&storeId=10152");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		try {
			screen.click(agree);
			Thread.sleep(2000);
			screen.type(emailText, "testemail@yopmail.com");
			
			
			screen.type(passwordText, "12334");
			//screen.capture();
			//screen.type(passwordText, "passw0rd");
			//screen.click(scrollBar);
			Thread.sleep(2000);
			screen.find(dropDown);
			screen.click(dropDown);
			Thread.sleep(1000);
			screen.click(dropDownMale);
			screen.text().compareTo("");
		
			
			
		} catch (FindFailed e) {
			System.out.println("Not found");
		}
		Thread.sleep(3000);
		driver.close();

	}


}
