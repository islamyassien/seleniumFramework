package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import Driver.Driver;
import Utils.ConfigFileReader;
import constants.Constants;

public class RegisterPage extends Driver {


	WebElement firstName;
	WebElement lastName;
	WebElement email;
	WebElement mob;
	WebElement pass;
	WebElement conPass;
	WebElement newsYes;
	WebElement newsNo;
	WebElement policy;
	WebElement btn;

	String configFilePath = ".\\src\\main\\java\\configs/RegisterPageObjects.properties";
	ConfigFileReader reader = new ConfigFileReader(configFilePath);


	// Driver and Web Controls 

	public RegisterPage(String browser) throws Exception{

		getDriver(browser, Constants.URL1);
		
		getElements();



	}
	
	public void getElements()
	{    
		timeOut(10);
		firstName=  findByID(reader.getPropertyValue("FirstName"));
		lastName=  findByID(reader.getPropertyValue("LastName"));
		email=  findByID(reader.getPropertyValue("Email"));
		mob=  findByID(reader.getPropertyValue("Mobile"));
		pass=  findByID(reader.getPropertyValue("Password"));
		conPass=  findByID(reader.getPropertyValue("ConPass"));

		newsYes = findByXpath(reader.getPropertyValue("NewsYes"));
		newsNo = findByXpath(reader.getPropertyValue("NewsNo"));
		policy = findByXpath(reader.getPropertyValue("Policy"));
		btn = findByXpath(reader.getPropertyValue("BTN"));  

		System.out.print("ok");
		
		
	}

	public void setFirstName(String text) {

		setText(firstName,text);

	}
	public void setLastName(String text) {

		setText(lastName,text);

	}
	public void setMobile(String text) {

		setText(mob,text);

	}
	public void setEmail(String text) {

		setText(email,text);

	}
	public void setPass(String text) {

		setText(pass,text);

	}
	public void setConPass(String text) {

		setText(conPass,text);

	}
	public void clickBtn() {

		timeOut(5);
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+btn.getLocation().x+")");
		btn.click();

	}

	public void checkPolicy(String option) {

		setChecked(policy, option);
		
	}
	
	
	public void checkNews(String option) {
		
		setChecked(newsYes, option);
		
		
	}


}
