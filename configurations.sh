#!/bin/bash
echo *************Starting Script************************
CD "$PROJECT_DIR"
echo Done


export DEFAULTPROFILE=$SINGLETHREAD

if [$PROFILE == $MULTITHREAD]
then 
	export DEFAULTPROFILE=$MULTITHREAD
    echo **************MULTITHREAD EXECUTION************************ 
elif [$PROFILE == $SINGLETHREAD]
then 
	export DEFAULTPROFILE=$SINGLETHREAD
    echo **************SINGLETHREAD EXECUTION************************ 
elif [$PROFILE == $PARALLEL]
then 
    export DEFAULTPROFILE=$PARALLEL
    echo **************PARALLEL EXECUTION************************
else 
    echo ******Configuration Not FOUND************************
    echo ****** Using default profile: "%DEFAULTPROFILE%"
fi  
echo *************Running in $DEFAULTPROFILE mode************************

echo Cleaning...
mvn clean  
echo *************Cleaning Done************************
echo *************************************
echo Compiling...
mvn compile  
echo *************Compilation Done************************
echo *************************************
echo **************Starting Execution************************

if [ $PLATFORM == BROWSERSTACK ] 
then
echo *****************************************
echo BROWSERSTACK EXECUTION
echo *****************************************

mvn verify -P $DEFAULTPROFILE -Dmetafilter=$META_FILTER -Dplatform=$PLATFORM -Dbrowserstack.os=$BROWSERSTACK_OS -Dbrowserstack.os.version=$BROWSERSTACK_OS_VERSION -Dbrowserstack.browser=$BROWSER -Dbrowserstack.browser.version=$BROWSER_VERSION -Dbrowserstack.url="$BROWSERSTACK_URL" -Dwebdriver.base.url="$BASE_URL"
elif [ $PLATFORM == DESKTOP ]
then

echo *****************************************
echo DESTOP EXECUTION
echo *****************************************

mvn verify -P $DEFAULTPROFILE -Dmetafilter=$META_FILTER  -Dwebdriver.driver=$BROWSER -Dwebdriver.base.url="$BASE_URL" -Dplatform=$PLATFORM

elif [ $PLATFORM == SAUCELABS ]
then
echo *****************************************
echo SAUCELAB EXECUTION
echo *****************************************

mvn verify -Dsaucelabs.target.platform=XP -Dwebdriver.driver=chrome -Dsaucelabs.driver.version=26 -Dsaucelabs.url=http://<my_id>:<my_API Key>@ondemand.saucelabs.com:80/wd/hub -Dsaucelabs.access.key=<My_API_Key> -Dsaucelabs.user.id=<my_id> -Dwebdriver.base.url=https://www.website.com -Dmaven.test.failure.ignore=true

elif [ $PLATFORM == MOBILE ]
then

echo *****************************************
echo MOBILE EXECUTION
echo *****************************************

mvn verify -P $DEFAULTPROFILE -Dplatform=$PLATFORM -Dappium.hub=$AppiumHub -Dmetafilter=$META_FILTER  -Dwebdriver.driver=appium -Dwebdriver.base.url="$BASE_URL" -Dappium.platformName=$AppiumPlatformName -Dappium.browserName=$AppiumBrowserName -Dappium.deviceName="$AppiumDeviceName" -DisDeviceTab=$IsDeviceTab -Dappium.automationName=$automationName -Dappium.udid=$iOSDeviceUDID 
osascript -e 'tell app "Terminal"
    do script "killall -9 ios_webkit_debug_proxy"
    end tell'
fi

osascript -e 'tell app "Terminal"
    do script "killall node"
    end tell'
echo Done
