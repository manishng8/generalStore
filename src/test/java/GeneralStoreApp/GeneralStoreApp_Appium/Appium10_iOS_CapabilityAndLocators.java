package GeneralStoreApp.GeneralStoreApp_Appium;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Appium10_iOS_CapabilityAndLocators {

	public static void main(String[] args) throws MalformedURLException {
	
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14.2");
		/* How to get iOS Version -- Open Terminal 
		 * Install carthage first (Highly Suggested) - brew install carthage
		 * Now for Version - 'instruments -s devices' - Tell What all simulators you have in your system.
		 * For your mobile simulator, whatever you are using you can check Bundle ID and iOS versions
		 */
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 12 Pro"); //Case Sensitive	
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
		caps.setCapability(IOSMobileCapabilityType.LAUNCH_TIMEOUT, 500000); // iOS Specific 
		// Time Provided to get app launched and only after that perform next step.
		caps.setCapability(IOSMobileCapabilityType.LAUNCH_TIMEOUT, 50000); // iOS Specific
		caps.setCapability("commandTimeouts", "12000");
		// For scrolling when it is performed need some time to perform next scroll
		//, otherwise it will be performed without waiting
		caps.setCapability(MobileCapabilityType.APP, "Users/mnagle/Desktop/UIKitCatalog.app"); // Path of .app file
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		IOSDriver driver = new IOSDriver<>(url,caps);
		
		/*********** INSPECT IOS OBJECTS*******************/
		// Try to use either xpath or accessibility id
		driver.findElementByAccessibilityId("Alert Views").click();
		driver.findElementByXPath("//XCUIElementTypeStaticText[@name='Text Entry']").click();
		driver.findElementByXPath("//XCUIElementTypeCell").sendKeys("Hello");
		driver.findElementByAccessibilityId("OK").click();
	}

}
