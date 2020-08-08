package ecommerce.hybrid.beans;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import ecommerce.hybrid.actions.Capabilities;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class LoginPOM{
	
	public static AndroidDriver <AndroidElement> driver=null;
		
	public LoginPOM(AndroidDriver <AndroidElement> driver) throws MalformedURLException {

		this.driver=driver;
	}
	
	public WebElement sendCountry(String country) {

		driver.findElementById("com.androidsample.generalstore:id/spinnerCountry").click();
		WebElement c=driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+country+"\"))");
		
		return c;
	}

	public WebElement sendName() {
		
		return driver.findElementById("com.androidsample.generalstore:id/nameField");
	}
	
	public WebElement sendGender() {
			
			return 	driver.findElementById("com.androidsample.generalstores:id/radioFemale");
		}
	public WebElement sendButton() {
		
		return 	driver.findElementById("com.androidsample.generalstore:id/btnLetsShop");
	}
	
}