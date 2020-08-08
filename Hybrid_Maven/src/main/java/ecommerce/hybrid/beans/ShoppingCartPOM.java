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

public class ShoppingCartPOM{
	
	public static AndroidDriver <AndroidElement> driver=null;
	
	public ShoppingCartPOM(AndroidDriver <AndroidElement> driver) throws MalformedURLException {

		this.driver=driver;
	}

		

	public List<Float> validatePurchase() {
		
		float sum=0;
		float p=0,screenS=0;
		String  price=null,screenSum=null;
		List<Float> list=new ArrayList<Float>();
		int count=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
		System.out.println("No. of Products :"+count);
		
		for (int i = 0; i < count; i++) {
			
			price=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(i).getText();
			price=price.substring(1);
			p=Float.parseFloat(price);
			sum=sum+p;
		}
		
		screenSum=driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		screenSum=screenSum.substring(1);
		screenS=Float.parseFloat(screenSum);
		
		list.add(screenS);
		list.add(sum);
		
		return list;
	}



}