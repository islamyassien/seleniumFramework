package pages;

import org.openqa.selenium.WebElement;

import Driver.Driver;
import Utils.ConfigFileReader;

public class AccountPage extends Driver{
	
	
	String configFilePath = ".\\src\\main\\java\\configs/AccountPageObjects.properties";
	ConfigFileReader reader = new ConfigFileReader(configFilePath);

	WebElement loginMessage;
	
	public AccountPage() {

		loginMessage =findByXpath(reader.getPropertyValue("LoginMessage"));
		
	}
	
	public String verfiyLinMess() throws InterruptedException {

		String text = getText(loginMessage);

		return text;
	}
	
	
	

}
