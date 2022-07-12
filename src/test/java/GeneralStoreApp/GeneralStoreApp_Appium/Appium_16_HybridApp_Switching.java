package GeneralStoreApp.GeneralStoreApp_Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;

public class Appium_16_HybridApp_Switching {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		File appDir = new File("src/test/java");
		File file = new File(appDir,"ApiDemos-debug.apk");
		DesiredCapabilities caps = new DesiredCapabilities();	
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "SM-G973F");
		caps.setCapability(MobileCapabilityType.APP, file.getAbsolutePath());
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(url, caps);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Preference\"]")).click();
		
		// Suppose after clicking on Preference Button Web View "https://google.com is getting opened"
		/******************* Handling Web View *******************************/
		
		Set<String> contexts = driver.getContextHandles();
		Thread.sleep(7000);
		for(String contextName: contexts)
		{
			System.out.println(contextName);
		}
		driver.context("WEBVIEW_com.androidsample.api-demos"); // this we have got from above loop
															   // command is provided to selenium 
		// Now you can grab the objects from your web browsers
		driver.findElement(By.name("q")).sendKeys("Hello");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		/************************ How to Come Back to Mobile App Appium **************/
		driver.pressKey(new KeyEvent(AndroidKey.BACK)); // It will take you back to mobile app
		driver.context("NATIVE_APP"); // Now command is provided to appium 
	}

}
