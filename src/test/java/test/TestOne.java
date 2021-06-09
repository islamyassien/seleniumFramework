package test;

import org.testng.annotations.Test;
import org.testng.Assert;

import pages.CongPage;
import pages.LogoutPage;
import pages.RegisterPage;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

public class TestOne {
	
	RegisterPage rp;
	
	
	
	@DataProvider(name="testData")
	public static Object[][] userData()
	{
		return new Object[][] {
			{"islam" , "omar","testnew19142@gmail.com","01151722172","123456test","123456test","0","1"},
			{"malek" , "saad","testnew19152@gmail.com","01151722172","12345test","12345test","0","1"},
			{"hany" , "mos","testnew19162@gmail.com","01151722172","12345test","12345test","0","1"}
		
		};
	}
	
	
 @Test(dataProvider="testData")
  public void register(String fname, String lname , String email , String mob ,String pass ,String conpass,String news ,String policy ) throws InterruptedException {
	 
	
	  rp.getElements();
	  rp.setFirstName(fname);
	  rp.setLastName(lname );
	  rp.setEmail(email);
	  rp.setMobile(mob);
	  rp.setPass(pass );
	  rp.setConPass(conpass);
	  rp.checkNews(news);
	  rp.checkPolicy(policy);
	  rp.clickBtn();
	  
	 
	  
	  CongPage cp= new CongPage();
	  String result = cp.verfiyConMess();
	  Assert.assertEquals(result, "Congratulations! Your new account has been successfully created!");
	  cp.logOut();
	  
	  LogoutPage lop = new LogoutPage();
	  lop.clickRegister();
	
  }
  
  
  
	@Parameters("browser")
	@BeforeClass
	public void beforeTest(String browser) throws Exception {
		

		 rp = new RegisterPage(browser);
		

	}

}
