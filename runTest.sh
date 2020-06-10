#mvn clean install -P runner -Dwebdriver.base.url=https://www.busonlineticket.com/booking/bus-tickets.aspx -Dmetafilter="+smoke"

#mvn -P runner serenity:aggregate

!#/bin/bash
echo pwd: $(pwd)
export PROJECT_DIR=$(pwd)
# include or exclude test scenarios and/or story files (e.g. "-skip,+smoke")
# To exclude use: - (minus sign)
# To include use: +(plus sign)
export PARAM="-skip,+smoke"

# MAVEN EXECUTION PROFILE
export SINGLETHREAD=singlethread
export PARALLEL=parallel
export MULTITHREAD=multithread
# set profile for building
export PROFILE=$SINGLETHREAD


# Setting browser for execution on Desktop(USE CHROME,FIREFOX ,SAFARI,APPIUM,PROVIDED in case of Custom Driver)
export BROWSER=CHROME

# Setting platform for execution(Use DESKTOP for DESKTOP, MOBILE for mobile devices, BROWSERSTACK for browserstack, SAUCELAB for saucelab)

export PLATFORM=DESKTOP

#Browserstack setting

export BROWSERSTACK_UserName=UserName
export BROWSERSTACK_AccessKey=AccessKey
export BROWSERSTACK_OS=OS_Name
export BROWSERSTACK_OS_VERSION=OS_Version
export BROWSERSTACK_URL=https://$BROWSERSTACK_UserName:$BROWSERSTACK_AccessKey@hub-cloud.browserstack.com/wd/hub


# Mobile Settings for Appium
export AppiumHub=http://127.0.0.1:4723/wd/hub
export AppiumPlatformName=deviceOS 
#(Android/iOS)
export AppiumBrowserName=deviceBrowser
export AppiumDeviceName=deviceName
export iOSDeviceUDID=deviceID
export automationName=deviceAutomationSupport
#(Use XCUITest for IOS, UI Autoamtor for Android)
 
# Set this to true if device is a TAB else false
 export IsDeviceTab=false
 
#if [ $PLATFORM == MOBILE ]
#then
#echo MOBILE EXECUTION
#osascript -e 'tell app "Terminal"
    #do script "ios_webkit_debug_proxy -c <deviceID>:27753"  
#end tell'
# use above for iOS only
#osascript -e 'tell app "Terminal"
    #do script "appium &"
#end tell'
#fi

export BASE_URL=https://www.busonlineticket.com/booking/bus-tickets.aspx
export META_FILTER=$PARAM
echo --- calling configurations.sh file...
sh ./configurations.sh
echo $PROJECT_DIR
