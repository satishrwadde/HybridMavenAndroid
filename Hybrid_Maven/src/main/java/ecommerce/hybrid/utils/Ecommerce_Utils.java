package ecommerce.hybrid.utils;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import static java.time.Duration.ofSeconds;

public class Ecommerce_Utils {
	
	public static AndroidDriver <AndroidElement> driver=null;
	
	public Ecommerce_Utils(AndroidDriver <AndroidElement> driver){
		
		this.driver=driver;
	}
	
	public void tapElement() throws InterruptedException {
		
//		WebElement ele=driver.findElementByClassName("android.widget.CheckBox");
//		TouchAction tact = new TouchAction(driver);
//		tact.tap(tapOptions().withElement(element(ele))).perform();
		
		WebElement ele = driver.findElement(MobileBy.AndroidUIAutomator("UiSelector().text(\"Send me e-mails on discounts related to selected products in future\")"));
        TouchAction t = new TouchAction(driver);
        t.tap(tapOptions().withElement(element(ele))).perform();
        // For Long press
        WebElement ele1 = driver.findElement(MobileBy.id("com.androidsample.generalstore:id/termsButton"));
        System.out.println("ele1"+ele1);
     //   t.longPress(longPressOptions().withElement(element(ele1)).withDuration(ofSeconds(2))).release().perform();
        //Thread.sleep(3000);
        System.out.println("After long press");
      //  driver.findElement(MobileBy.id("android:id/button1")).click();
      //  Thread.sleep(1000);
        driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnProceed")).click();
        System.out.println("End NATIVE_APP_VIEW !");
        
        
        Set<String> contextNames=driver.getContextHandles();
        for(String contextName : contextNames)
        	System.out.println("Contexts :=>" + contextName);
        
        Thread.sleep(5000);
        driver.context("WEBVIEW_com.androidsample.generalstore");
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("Selenium");
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys(Keys.ENTER);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.context("NATIVE_APP");
	}
	
	/*public void longPressElement() throws InterruptedException {
			
			//WebElement ele= driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Please read our terms of conditions\")");

//			WebElement ele=driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
			
			
	        WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
	        System.out.println("Element to longPress : "+ele);										 
			TouchAction tact = new TouchAction(driver);
	        tact.longPress(longPressOptions().withElement(element(ele)).withDuration(ofSeconds(2))).release().perform();
	        driver.findElement(By.id("android:id/button1")).click();
	        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
	        
			//tact.longPress(longPressOptions().withElement(element(ele)).withDuration(ofSeconds(2))).perform();
			//System.out.println("release() : "+tact.longPress(longPressOptions().withElement(element(ele)).withDuration(ofSeconds(2))).release());
			
			//tact.press(ElementOption.element(ele)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).release().perform(); 

	        Thread.sleep(8000);

	}*/

}
