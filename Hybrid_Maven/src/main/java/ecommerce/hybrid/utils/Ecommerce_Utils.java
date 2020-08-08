package ecommerce.hybrid.utils;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.time.Duration;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Ecommerce_Utils {
	
	public static AndroidDriver <AndroidElement> driver=null;
	
	public Ecommerce_Utils(AndroidDriver <AndroidElement> driver){
		
		this.driver=driver;
	}
	
	public void tapElement() {
		
		WebElement ele=driver.findElementByClassName("android.widget.CheckBox");
		TouchAction tact = new TouchAction(driver);
		tact.tap(tapOptions().withElement(element(ele))).perform();
	}
	
	public void longPressElement() throws InterruptedException {
			
			WebElement ele= driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Please read our terms of conditions\")");

//			WebElement ele=driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
			System.out.println("Element to longPress : "+ele);										 
			TouchAction tact = new TouchAction(driver);
			//tact.longPress(longPressOptions().withElement(element(ele)).withDuration(ofSeconds(2))).perform();
			//System.out.println("release() : "+tact.longPress(longPressOptions().withElement(element(ele)).withDuration(ofSeconds(2))).release());
			
			//tact.press(ElementOption.element(ele)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).release().perform(); 
			
			System.out.println("perform() : "+tact.longPress(longPressOptions().withElement(element(ele)).withDuration(Duration.ofMillis(3000))).release().perform());
			Thread.sleep(5000);
			//.perform();
			//release().perform();

	}

}
