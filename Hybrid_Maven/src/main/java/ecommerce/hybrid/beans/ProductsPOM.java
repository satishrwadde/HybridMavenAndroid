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

public class ProductsPOM{
	
	public static AndroidDriver <AndroidElement> driver=null;
	
	public ProductsPOM(AndroidDriver <AndroidElement> driver) throws MalformedURLException {

		this.driver=driver;
	}
	
	public WebElement scrollToProduct(String productName) {
		
		return driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\""+productName+"\").instance(0))"));
	}
	
	
	public WebElement sendAndroidWidget(int index) {
		return driver.findElement(By.xpath("//android.widget.Toast["+index+"]"));
	}

	public String sendAddToCart(String productName) throws InterruptedException {
		
		WebElement ee=null;
		String str=null;
		int count=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		System.out.println(count);
		for (int i = 0; i < count; i++) {
			String prodName=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			
			if(prodName.equalsIgnoreCase(productName)) {
			
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
				Thread.sleep(2);
				str=driver.findElement(By.id("com.androidsample.generalstore:id/productAddCart")).getText();
				System.out.println("In sendAddToCart()"+ str);
				break;
			}
			
		}
		return str;
	}
	
	public WebElement sendCartButton() {
		
		return driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart");
	}
	
	
	public void sendAddToCart2Products() {
		
		WebElement ee=null;
		int count=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		System.out.println(count);
		for (int i = 0; i < count; i++) {
			String productName=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
		}
	}

	
}