package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Driver.Driver;
import Utils.ConfigFileReader;

public class LogoutPage extends Driver {
	

	String configFilePath = ".\\src\\main\\java\\configs/LogoutPageObjects.properties";
	ConfigFileReader reader = new ConfigFileReader(configFilePath);

	WebElement logoutText;
	WebElement accountItem;
	WebElement accountList;
	
	public LogoutPage() {

		logoutText = findByXpath(reader.getPropertyValue("LogoutMessage"));
		accountItem=findByXpath(reader.getPropertyValue("AccountItem"));

	}
	
	
	public String verfiylogoutMess() throws InterruptedException {

		String text = getText(logoutText);

		return text;
	}
	
	public void clickLogin()
	{
		

		accountItem.click();

		timeOut(10);
        
		
		accountList = findByXpath(reader.getPropertyValue("AccountList")); 
		List <WebElement> items = accountList.findElements(By.tagName("li"));

		String val = "Login";
		String res=null;
		
		for( WebElement i: items){
			
			res=i.getText();
			
			if(val.equals(res))
			{   
				
				i.click();
				break;
			}
		}

	}
	
	
	public void clickRegister()
	{
		

		accountItem.click();

		timeOut(10);
        
		
		accountList = findByXpath(reader.getPropertyValue("AccountList")); 
		List <WebElement> items = accountList.findElements(By.tagName("li"));

		String val = "Register";
		String res=null;
		
		for( WebElement i: items){
			
			res=i.getText();
			
			if(val.equals(res))
			{   
				
				i.click();
				break;
			}
		}

	}
	
	

}
