package GeneralStoreApp.GeneralStoreApp_Appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class Appium11_iOS_Scroll {

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
		
		/*********** SCROLL CODE*******************/
		HashMap<String,Object> scrollObject = new HashMap<>();
		scrollObject.put("direction", "down");
		scrollObject.put("name", "Web View"); // Scroll up to this element (we provided attribute)
			
		driver.executeScript("mobile:scroll", scrollObject);
		// This method will support your java script code.
		// Second argument takes HashMap as an Input
		
		driver.findElementByAccessibilityId("Web View").click();

	}

}
