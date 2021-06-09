package pages;

import org.openqa.selenium.WebElement;

import Driver.Driver;
import Utils.ConfigFileReader;

public class LoginPage extends Driver {
	
	
	
	String configFilePath = ".\\src\\main\\java\\configs/LoginPageObjects.properties";
	ConfigFileReader reader = new ConfigFileReader(configFilePath);

	WebElement email;
	WebElement pass;
	WebElement loginBtn;

	
	public LoginPage() {

		email =findByXpath(reader.getPropertyValue("Email"));
		pass= findByXpath(reader.getPropertyValue("Pass"));
		loginBtn =findByXpath(reader.getPropertyValue("LoginBtn"));
		
	}
	
	public void Login(String mail , String password)
	{

		timeOut(10);
		setText(email,mail);
		setText(pass,password);
		loginBtn.click();
		
	}
	
	
	
}
