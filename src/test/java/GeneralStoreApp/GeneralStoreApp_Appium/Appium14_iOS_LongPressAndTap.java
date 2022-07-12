package GeneralStoreApp.GeneralStoreApp_Appium;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSTouchAction;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class Appium14_iOS_LongPressAndTap {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14.2");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 12 Pro"); //Case Sensitive	
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
		caps.setCapability(IOSMobileCapabilityType.LAUNCH_TIMEOUT, 50000); // iOS Specific
		caps.setCapability("commandTimeouts", "12000");
		caps.setCapability(MobileCapabilityType.APP, "Users/mnagle/Desktop/LongTap.app"); // Path of .app file
																		 //Get this app from Rahul Shetty Acad.
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		IOSDriver driver = new IOSDriver<>(url,caps);
		
		/*********** LONG PRESS *******************/		
		MobileElement e = (MobileElement)driver.findElementByName("Long tap");
		//If you want to long press on any element, and since this element is specific to mobile, so for that element
		//TypeCase your locator to MobileELement as shown above.
		
		IOSTouchAction touch = new IOSTouchAction(driver); 
		// For touch events in iOS we have to use IOSTouchACtion class.
		touch.longPress(longPressOptions().withElement(element(e)).withDuration(ofSeconds(2))).release().perform();
		
		/* Note: Eclipse by default won't give suggestions for import of static classes.
		 * So you need to remember their imports
		 * LongPressOptions.longPressOptions, ElementOption.element, Duration.ofSeconds, TapOptions.tapOptions
		 */
		
		/*********** TAPPING *******************/	
		// Generally there are toggle button in iOS for which we need to use Tap
		MobileElement tap = (MobileElement)driver.findElementByXPath("//XCUIElementTypeSwitch[1]");
		touch.tap(tapOptions().withElement(element(tap))).perform();
	}

}
