package test;

import org.testng.annotations.Test;

import pages.AccountPage;
import pages.CongPage;
import pages.LoginPage;
import pages.LogoutPage;
import pages.RegisterPage;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class TestTwo {
	RegisterPage rp;
	
	
  @Test
  public void reglog() throws InterruptedException {
	  
	  
	  rp.setFirstName("islam");
	  rp.setLastName("yassien");
	  rp.setEmail("islamyassien901@gmail.com");
	  rp.setMobile("01151722172");
	  rp.setPass("123456test");
	  rp.setConPass("123456test");
	  rp.checkNews("0");
	  rp.checkPolicy("1");
	  rp.clickBtn();
	  
	  CongPage cp= new CongPage();
	  String conResult = cp.verfiyConMess();
	  Assert.assertEquals(conResult, "Congratulations! Your new account has been successfully created!");
	  cp.logOut();
	  
	  LogoutPage lop = new LogoutPage();
	  String logoutResult = lop.verfiylogoutMess();
	  Assert.assertEquals(logoutResult, "You have been logged off your account. It is now safe to leave the computer.");
	  lop.clickLogin();
	  
		
	  
	  LoginPage lip = new LoginPage();
	  lip.Login("islamyassien901@gmail.com", "123456test");
	  
	  AccountPage acc = new AccountPage();
	  String linResult = acc.verfiyLinMess();
	  Assert.assertEquals(linResult, "My Account");
	 
	  
  }
  
  @Parameters("browser")
  @BeforeClass
  public void beforeTest(String browser) throws Exception {
		

		 rp = new RegisterPage(browser);
		

	}

}
