package GeneralStoreApp.GeneralStoreApp_Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Appium3_androidUIAutomatorForLocator {
	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		File appDir = new File("src/test/java");
		File file = new File(appDir,"ApiDemos-debug.apk");
		
		DesiredCapabilities caps = new DesiredCapabilities();
				
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "SM-G973F");
		caps.setCapability(MobileCapabilityType.APP, file.getAbsolutePath());
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(url, caps);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// In Mobile we mostly use XPATH, ID, CLassName, AndroidUIAutomator

		//driver.findElementByAndroidUIAutomator("attribute("value")");
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		driver.findElementByAndroidUIAutomator("text(\"Animation\")").click();
		
		/*If You are using any property from DOM then user below syntax with androidUiAutomator*/
		//driver.findElementByAndroidUIAutomator("new UiSelector().property(value)");
		int num = driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size();
		System.out.println(num);
		
		driver.quit();
	}
}
