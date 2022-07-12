package GeneralStoreApp.GeneralStoreApp_Appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Appium8_HandlingMobileChromeBrowser {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		/*More than 50% of the traffic is coming from mobile browser than web browser
		 *That's why it's testing is important
		 *
		 *Points to Keep in Mind
		 * Point 1: Desired Capabilities for Mobile Browsers
		 * Point 2: How to Inspect and Grab Mobile Browser Locators
		 * Point 3: Understand how to Scroll in Mobile Browsers.
		 * 
		 * -- Touch and Tap gestures will not work for Browsers, only Scroll will work
		 */
				
		DesiredCapabilities caps = new DesiredCapabilities();
				
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "SM-G973F");
		caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome"); //Point 1
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(url, caps);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		/* Point 2: To check how your web page will look in mobile browser you can user Chrome browser inspect element. 
		 * And there you can render the browser to mobile view. From top you can select mobile type as well
		 * You can user normal inspection of browser as you do for laptop. You can write objects now
		 * Sometimes web view for website is different on laptop and mobile. Ex: crickbuzz.com
		 * In this case you need to choose another mobile url Ex: m.crickbuzz.com
		 */
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.cssSelector(".navbar-toggler-icon")).click(); // Point 2: Click on Hamburger Menu
		driver.findElement(By.cssSelector("a[href*='products']")).click();	// Click on Products	
		
		/* Sometimes you might run into issues of Chrome Browser Compatibility
		 * "Error: No ChromeDriver found that can automate Chrome '83.0.4103"
		 * In this case: Chrome Browser is not compatible with driver which you have in appium. It's a mismatch.
		 * You have to update Chrome Driver in your Appium
		 * Download and replace the driver in your appium folder structure // Read logs and go to the path
		 */
		
		// For Scrolling In Web Browser We Will Be Using JavaScriptExecutor.
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)","");
		
		// Click on some product now
		String checkText = driver.findElement(By.xpath("(//li[@class='list-group-item'])[3]/div//div/a")).getText();
		Assert.assertEquals(checkText,"Devops");
		// Rest all is done as done in selenium 
	}

}
