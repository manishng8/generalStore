package GeneralStoreApp.GeneralStoreApp_Appium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Appium12_iOS_PickerWheel {

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
		
		/*********** PICKER WHEEL CODE*******************/		
		driver.findElementByAccessibilityId("Picker View").click();
		
		//  For Picker Wheel SendKeys Method Will Work Fine
		driver.findElementByAccessibilityId("Date Component Value").sendKeys("16");
		driver.findElementByAccessibilityId("Month Component Value").sendKeys("May");
		driver.findElementByAccessibilityId("Year Component Value").sendKeys("1995");

	}

}
