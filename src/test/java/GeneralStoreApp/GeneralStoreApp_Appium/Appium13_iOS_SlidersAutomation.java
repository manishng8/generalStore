package GeneralStoreApp.GeneralStoreApp_Appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Appium13_iOS_SlidersAutomation {

	public static void main(String[] args) throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14.2");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 12 Pro"); //Case Sensitive	
		caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
		caps.setCapability(IOSMobileCapabilityType.LAUNCH_TIMEOUT, 50000); // iOS Specific
		caps.setCapability("commandTimeouts", "12000");
		caps.setCapability(MobileCapabilityType.APP, "Users/mnagle/Desktop/UIKitCatalog.app"); // Path of .app file
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		IOSDriver driver = new IOSDriver<>(url,caps);
		
		/*********** Sliders Automation*******************/		
		driver.findElementByAccessibilityId("Sliders").click();
		
		// SLider value is set to some default let's suppose 42% and we are trying to move it to 0 %
		// iOS support a slider object, so we will cast code with IOSElement
		IOSElement slider = (IOSElement)driver.findElementByXPath("//XCUIElementTypeSlider");
		
		slider.setValue("0%");
		slider.setValue("0.34%"); 
		// set value takes value from 0 to 1, so suppose 34% u need to give 0.34%, for 100% give 1%
		Assert.assertEquals("34%",slider.getAttribute("value"));

	}

}
