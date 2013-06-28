# OrientationLock - Android PhoneGap/Cordova Plugin for locking/unlocking the screen orientation from JS #

</br>
</br>

## Calling the plugin ##

From your JavaScript code call <pre>window.plugins.OrientationLock.unlock()</pre> to unlock orientation, <br/>
<pre>window.plugins.OrientationLock.lock("portrait")</pre> or <pre>window.plugins.OrientationLock.lock("landscape")</pre> 
to lock your screen to the specified orientation. </br></br>

To start your PhoneGap/Cordova application pre-locked place 
<pre>setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);</pre> or 
<pre>setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);</pre> 
in the onCreate() of your DroidGap activity. </br>

Once unlocked, you can track orientation changes with the regular 'orientationchange' event:
<pre>window.addEventListener("orientationchange", dojo.hitch(this, function() {
  alert(window.orientation);
}, false);</pre>

## Adding the Plugin to your project ##

Using this plugin requires [Android PhoneGap](http://github.com/phonegap/phonegap-android).

To enable it..<br>
1) Put the orientationLock.js in the www/ directory of your PhoneGap project and reference it from your HTML. <br/>
2) Put the OrientationLock.java in src/com/phonegap/plugins/ and add the following line in your res/xml/config.xml:
<br/>
`<plugin name="OrientationLock" value="com.phonegap.plugins.OrientationLock"/>`
