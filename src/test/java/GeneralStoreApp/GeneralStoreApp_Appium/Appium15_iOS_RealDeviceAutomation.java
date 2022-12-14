package GeneralStoreApp.GeneralStoreApp_Appium;

public class Appium15_iOS_RealDeviceAutomation {

	public static void main(String[] args) {
		
		/* LITTLE TRICKY TO AUTOMATE REAL IOS DEVICES
		 * Due To More Security :(
		 * For this require some XCode Knowledge
		 * Appium support real device iOS 9.3 and above
		 * xcode version 8+ is required
		 * 
		 * First: Install Few Software Before Working On Real Device Automation
		 * --------------------------------------------------------------------
		 * Install below softwares:
		 * 1. brew install libimobiledevice
		 * 		brew command not comes directly, you need to install brew first with mentioned command on 3rd number.
		 * 2. brew install ios-deploy	
		 * 3. /usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
		 * -----------------------------------------------------------------------------------------------------------
		 * 
		 * Second: Four new capabilities are required to run test on real devices apart from previously used caps:
		 * 1. d.setCapability("xcodeOrgId","xxxxxxxx");
		 * 2. d.setCapability("xcodeSigningId","iPhone Developer");
	     * 3. d.setCapability("udid","xxxxxxxx");
		 * 4. d.setCapability("updateWDABundleId","xxxxxxx");
		 * 
		 * xcodeOrgId: Basically it is a team id generated by apple, 
		 * 			   Sign in to developer.apple.com/account and click Membership in the sidebar
		 * 			   You will find your xcodeOrgID in the form of Team ID there
		 * 			   When you are working in a team, this will be provided by your team.
		 * 
		 * xcodeSigningId: This is by default iPhone Developer
		 * udid: 		   UDID you can get after connecting your device to mac on iTunes
		 * 			       https://www.wikihow.com/Obtain-the-Identifier-Number-(UDID)-for-an-iPhone,-iPod-or-iPad
		 * updateWDABundleId:
		 * 				Often we need provisioning profile from Apple to run the apps on Real Devices.
		 * 				And this Provisioning Profile generates Bundle ID, we need to provide this bundle ID.
		 * 				And we need to Sign the App to run on the device using Bundle id.
		 * 				Ask Your Team for This Ideally
		 * 
		 * 				Provisioning Profile can be created through xcode
		 */

	}

}
