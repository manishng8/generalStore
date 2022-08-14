package Demo_Practice;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static java.time.Duration.ofSeconds;

public class AndroidScrolling_LongPress_Swipping_Tap {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		caps.setCapability(MobileCapabilityType.APP, "Path of application");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "SM-G3975");
		caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(url, caps);
		
		driver.findElementByAndroidUIAutomator("text(\"Manish\")").click();
		driver.findElementByAndroidUIAutomator("new UiSelector.clickable(true)").click();		

		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Nagle\"));");
		
		MobileElement e = driver.findElementById("start");
		MobileElement c = driver.findElementById("end");
		
		TouchAction t = new TouchAction(driver);
		t.longPress(longPressOptions().withElement(element(e)).withDuration(ofSeconds(2))).release().perform();
		
		//Swipping
		t.longPress(longPressOptions().withElement(element(e)).withDuration(ofSeconds(4))).moveTo(element(c)).release().perform();
		
		// Tap
		
		t.tap(tapOptions().withElement(element(e))).perform();
		
		//Drag and Drop
		t.longPress(longPressOptions().withElement(element(c))).moveTo(element(e)).release().perform();
//		
//		JavascriptExecutor js =(JavascriptExecutor)driver;
//		js.executeScript("window.scrollBy(0,1000)", "");
//		js.executeScript("argument[0].scrollIntoView();", "ELement");
//		js.executeScript("window.scrollTo(0,document_body_scrollHeight)", "");

		Set<String> contexts = driver.getContextHandles();
		
		for(String contextName : contexts)
		{
			
			System.out.println(contextName);
		}
		
		driver.context("WebContext");		
		/*Selenium Code for Mobile Web Browser View*/
		driver.context("Native_App");
		driver.quit();
	}

}
