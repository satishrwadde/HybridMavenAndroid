package ecommerce.hybrid.testrunner;

import org.testng.annotations.Test;

import ecommerce.hybrid.actions.Capabilities;
import ecommerce.hybrid.beans.LoginPOM;
import ecommerce.hybrid.beans.ProductsPOM;
import ecommerce.hybrid.beans.ShoppingCartPOM;
import ecommerce.hybrid.utils.Ecommerce_Utils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import org.testng.Assert;


import java.net.MalformedURLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class HybridTestRunner extends Capabilities{
  
	public static LoginPOM loginPom=null;
	public static ProductsPOM productsPom=null;
	public static ShoppingCartPOM shoppingCartPom=null;
	public static AndroidDriver <AndroidElement> driver=null;
	public static Ecommerce_Utils eUtils=null;
	
	@BeforeMethod
	public void beforeTest() throws MalformedURLException {
		
		System.out.println("*****************  In BeforeTest *************");
		driver=Capabilities.capability();		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		eUtils=new Ecommerce_Utils(driver);
		loginPom=new LoginPOM(driver);
		productsPom=new ProductsPOM(driver);
		shoppingCartPom=new ShoppingCartPOM(driver);
	}
	
  @Test
  public void TC01() throws InterruptedException {
	  
	  String product="Air Jordan 9 Retro";	
	  loginPom.sendCountry("Angola").click();
	  loginPom.sendName().sendKeys("Satish Wadde");
	  loginPom.sendGender().click();
	  loginPom.sendButton().click();
	  productsPom.scrollToProduct(product);
	  String Actual=productsPom.sendAddToCart(product);
	  Assert.assertEquals(Actual, "ADDED TO CART");
      productsPom.sendCartButton().click();
	}
  
  
  @Test
  public void TC03() throws InterruptedException {
	  	
	  loginPom.sendCountry("Angola").click();
	  loginPom.sendName().sendKeys("Satish Wadde");
	  loginPom.sendGender().click();
	  loginPom.sendButton().click();
	  productsPom.sendAddToCart2Products();
	  productsPom.sendCartButton().click();
	  List<Float> list=shoppingCartPom.validatePurchase();
	  System.out.println("Final price on screen : "+list.get(0)+" Sum of price of products : "+list.get(1));
	  Assert.assertEquals(list.get(0), list.get(1));
	  eUtils.tapElement();
	//eUtils.longPressElement();
}
  
  
	
  @Test
  public void TC02() {

	  	loginPom.sendCountry("Bhutan").click();
	  	loginPom.sendGender().click();
	  	loginPom.sendButton().click();
		String error=productsPom.sendAndroidWidget(1).getAttribute("name");
		System.out.println(error);
		Assert.assertEquals(error,"Please enter your name");
	 }


  
  @AfterMethod
  public void afterTest() {
  
		System.out.println("*****************  In AfterTest *************");
  }

}
