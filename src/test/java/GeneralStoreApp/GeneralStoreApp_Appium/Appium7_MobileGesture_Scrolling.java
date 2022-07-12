package GeneralStoreApp.GeneralStoreApp_Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Appium7_MobileGesture_Scrolling {

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
		
		/******************* SCROLLING IN ANDROID **********************/
		TouchAction t = new TouchAction(driver);
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		
		
		// Scrolling Syntax Using Android Methods
		// Appium does not support any method for scrolling
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));");
	}

}
