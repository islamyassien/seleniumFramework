package pages;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertEquals;
import org.apache.logging.log4j.core.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Driver.Driver;
import Utils.ConfigFileReader;
import java.util.List;
public class CongPage extends Driver{


	String configFilePath = ".\\src\\main\\java\\configs/CongratulationsPageObjects.properties";
	ConfigFileReader reader = new ConfigFileReader(configFilePath);

	WebElement congText;
	WebElement accountItem;
	WebElement accountList;

	public CongPage() {

		congText = findByXpath(reader.getPropertyValue("CongMessage"));
		accountItem=findByXpath(reader.getPropertyValue("AccountItem"));

	}


	public String verfiyConMess() throws InterruptedException {

		String text = getText(congText);
		//System.out.print(text);

		return text;
	}

	public void logOut()
	{
		accountItem.click();

		timeOut(10);
        
		
		accountList = findByXpath(reader.getPropertyValue("AccountList")); 
		List <WebElement> items = accountList.findElements(By.tagName("li"));

		String val = "Logout";
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
