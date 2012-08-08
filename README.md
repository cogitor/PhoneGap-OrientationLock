# OrientationLock - Android PhoneGap Plugin for locking/unlocking the screen orientation from JS #

## Calling the plugin ##

From your JavaScript code call window.plugins.OrientationLock.unlock() to unlock orientation, <br/>
window.plugins.Orientation.lock("portrait") or window.plugins.OrientationLock.lock("landscape") to lock your screen to the specified orientation.

To start your PhoneGap/Cordova application pre-locked place 
<pre>setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);</pre> or 
<pre>setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);</pre> in the onCreate() of your DroidGap activity.

Once unlocked, you can track orientation changes with the regular 'orientationchange' event:
window.addEventListener("orientationchange", dojo.hitch(this, function() {
  alert(window.orientation);
}, false);

## Adding the Plugin to your project ##

Using this plugin requires [Android PhoneGap](http://github.com/phonegap/phonegap-android).

To enable it put the orientationLock.js in the www/ directory of your PhoneGap project, <br/>
The OrientationLock.java in src/com/phonegap/plugins/ and add the following line in your res/plugins.xml:
<br/>
&lt;plugin name="OrientationLock" value="com.phonegap.plugins.OrientationLock"/&gt;
