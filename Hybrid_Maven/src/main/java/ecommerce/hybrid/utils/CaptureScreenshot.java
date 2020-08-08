package ecommerce.hybrid.utils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;


public class CaptureScreenshot {

		
		public static String path="C:\\Users\\SatishWadde\\git\\repository3\\Hybrid_Maven\\test-output\\Screenshots\\";
				
		public static AndroidDriver <AndroidElement> driver=null;
		
		public CaptureScreenshot(AndroidDriver <AndroidElement> driver){

			this.driver=driver;
		}		

		
		public void screenshot() {
			
			String fileName="";
			System.out.println(path);
			GregorianCalendar calendar=new GregorianCalendar();
			int date=calendar.get(calendar.DATE);
			int minute=calendar.get(calendar.MINUTE);
			int seconds=calendar.get(calendar.SECOND);
			
			
			fileName=Integer.toString(date) + "-" +
							Integer.toString(minute)+ "-" +
							Integer.toString(seconds)+".png";
			
			TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
			
		//	System.out.println("takesScreenshot =>"+takesScreenshot);
			File file=takesScreenshot.getScreenshotAs(OutputType.FILE); //this gives raw file.
	//		System.out.println("file =>"+file);
			//now we have to copy this raw file into secondary storage using commons-io
			
			try {

				FileUtils.copyFile(file, new File(path+fileName));
	//			System.out.println("Inside copyFile from raw to secondary storage*********");

			} catch (IOException e) {

				e.printStackTrace();
			}
			
		}

		public void screenshot(String fileName) {
			
			TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
			
			File file=takesScreenshot.getScreenshotAs(OutputType.FILE); //this gives raw file.
			
			//now we have to copy this raw file into secondary storage using commons-io
			
			try {
				FileUtils.copyFile(file, new File(path + fileName + ".png"));
			} catch (IOException e) {

				e.printStackTrace();
			}
			
			
		}
}


