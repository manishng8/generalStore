package GeneralStoreApp.GeneralStoreApp_Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class Appium5_MobileGesture_Swipping {

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
		
		// In Mobile we mostly use XPATH, ID, CLassName, AndroidUIAutomator
		TouchAction t = new TouchAction(driver);
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Date Widgets']")).click();
		driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();
		
		WebElement first = driver.findElement(By.xpath("//*[@content-desc='15']"));
		WebElement second = driver.findElement(By.xpath("//*[@content-desc='45']"));
		// Now Swipping
		driver.findElementByXPath("//*[@content-desc='9']").click();
		t.longPress(longPressOptions().withElement(element(first)).withDuration(ofSeconds(2))).moveTo(element(second)).release().perform();

	}

}
