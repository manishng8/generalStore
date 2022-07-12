package GeneralStoreApp.GeneralStoreApp_Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Appium2_locators {

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
		driver.findElement(By.xpath("//android.widget.TextView[@text=\"Preference\"]")).click();
		driver.findElementByXPath("//android.widget.TextView[text()=\"3. Preference dependencies\"]").click();
		driver.findElementById("android:id/checkbox").click();
		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		driver.findElementByClassName("android.widget.EditText").sendKeys("Mak 42 Wifi Configuration");

		driver.findElementsByClassName("android.widget.Button").get(1).click();
		
		driver.quit();
	}

}
