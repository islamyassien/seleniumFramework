package Driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

import constants.Constants;

public class Driver {

	static public WebDriver driver;


	public static WebElement findByXpath(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}
	public static WebElement findByID(String ID) {
		return driver.findElement(By.id(ID));
	}
	public static WebElement findByClass(String Class) {
		return driver.findElement(By.className(Class));
	}
	public static void selectValue(WebElement elem, String value) {
		Select selem = new Select(elem);
		selem.selectByVisibleText(value);

	}
	public static String getAttributeValue(WebElement elem, String attrName) {
		return elem.getAttribute(attrName);
	}
	public static void navigateBack() {
		driver.navigate().back();
	}

	public static void setChecked(WebElement elem, String status) {
		if(status.equalsIgnoreCase("1")) {
			if(! elem.isSelected())
				elem.click();
		}
		else {
			if(elem.isSelected())
				elem.click();
		}
	}


	public static void setText(WebElement elem, String value) {

		//elem.sendKeys(Keys.chord(Keys.CONTROL, "a"), value);
		elem.clear();
		elem.sendKeys(value);
	}

	public static String getText(WebElement elem) {
		return elem.getText();
	}


	public static void press(WebElement elem) {
		elem.submit();
	}

	public static void timeOut(int sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);        
	}


	public static void getDriver(String browser, String URL) {


		if (browser.equalsIgnoreCase("ie")) {
			//DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
			//cap.setBrowserName("internet explorer");
			System.setProperty("webdriver.ie.driver", Constants.IEDriverPath);

			driver=new InternetExplorerDriver();

			timeOut(10);

			// Launch website
			driver.navigate().to(URL);
			driver.manage().window().maximize();
		}
		else if (browser.equalsIgnoreCase("firefox")) {
			//DesiredCapabilities cap = DesiredCapabilities.firefox();
			//cap.setBrowserName("firefox");
			System.setProperty("webdriver.gecko.driver", Constants.FFDriverPath);
			driver=new FirefoxDriver();

			timeOut(10);

			// Launch website
			driver.navigate().to(URL);
			driver.manage().window().maximize();

		}
		else if (browser.equalsIgnoreCase("chrome")) {
			//DesiredCapabilities cap = DesiredCapabilities.chrome();
			//cap.setBrowserName("chrome");
			System.setProperty("webdriver.chrome.driver", Constants.ChromeDriverPath);

			driver=new ChromeDriver();
			timeOut(10);

			// Launch website
			driver.navigate().to(URL);
			driver.manage().window().maximize();

		}	


		//Headless testing

		else if (browser.equalsIgnoreCase("headless"))
		{
			DesiredCapabilities cap =new DesiredCapabilities();
			cap.setJavascriptEnabled(true);
			cap.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, Constants.PhantomjsDriverPath);
			String[] phantomJsArgs = {"--web-security=no","--ignore-ssl-errors=yes"};
			cap.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomJsArgs);
			driver = new PhantomJSDriver(cap);

		}



		timeOut(10);

	}


	public static void closeDriver() {
		driver.close();
	}


}
