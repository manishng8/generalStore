package GeneralStoreApp.GeneralStoreApp_Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.TouchAction;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class Appium4_MobileGesture1_LongPress {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
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
		
		/************* TAPPING AND LONG PRESS ************************/
		TouchAction t = new TouchAction(driver);
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		Thread.sleep(3000);
		WebElement expandList = driver.findElementByXPath("//android.widget.TextView[@text=\"Expandable Lists\"]");
		
		//Tapping
		t.tap(tapOptions().withElement(element(expandList))).perform();
		
		//LongPress
		t.longPress(longPressOptions().withElement(element(expandList)).withDuration(ofSeconds(2))).release().perform();
	
		Thread.sleep(3000);
		driver.quit();
	}

}
