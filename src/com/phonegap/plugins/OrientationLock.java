package com.phonegap.plugins;

import org.apache.cordova.api.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.pm.ActivityInfo;
import android.util.Log;

import org.apache.cordova.*;
import org.apache.cordova.api.CordovaPlugin;
import org.apache.cordova.api.PluginResult;
/**
 * 
 * Android Phonegap Plugin for locking/unlocking the orientation from JS code
 *
 */
public class OrientationLock extends CordovaPlugin {

	private static final String LANSCAPE = "landscape";
	private static final String PORTRAIT = "portrait";
    private CallbackContext callbackContext;
	
	public OrientationLock() {
    }

    public void unlock() {
    	((DroidGap)this.cordova.getActivity()).setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
    }

    public void lock(String orientation) {

    	if (orientation.equals(PORTRAIT))
    		((DroidGap)this.cordova.getActivity()).setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    	else
    		((DroidGap)this.cordova.getActivity()).setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    public boolean execute(String action, JSONArray arguments, CallbackContext callbackContext) throws JSONException {

        if (action.equals("lock")) {
            this.callbackContext = callbackContext;
            try {
                String orientation = arguments.getString(0);

                if (orientation!=null && (orientation.equals(LANSCAPE) ||  orientation.equals(PORTRAIT))) {
                    this.lock(orientation);
                    //return new PluginResult(PluginResult.Status.OK);
                    PluginResult pluginResult = new PluginResult(PluginResult.Status.OK);
                    pluginResult.setKeepCallback(true);
                    callbackContext.sendPluginResult(pluginResult);
                    return true;

                }
                else{
                    //return new PluginResult(PluginResult.Status.INVALID_ACTION);
                    PluginResult pluginResult = new PluginResult(PluginResult.Status.INVALID_ACTION);
                    pluginResult.setKeepCallback(true);
                    callbackContext.sendPluginResult(pluginResult);
                    return false;
                }

            } catch (JSONException e) {
                //return new PluginResult(PluginResult.Status.JSON_EXCEPTION);
                PluginResult pluginResult = new PluginResult(PluginResult.Status.JSON_EXCEPTION);
                pluginResult.setKeepCallback(true);
                callbackContext.sendPluginResult(pluginResult);
                return false;
            }

        }
        else if (action.equals("unlock")) {
            this.unlock();
            //return new PluginResult(PluginResult.Status.OK);
            PluginResult pluginResult = new PluginResult(PluginResult.Status.OK);
            pluginResult.setKeepCallback(true);
            callbackContext.sendPluginResult(pluginResult);
            return true;
        }
        else {
            //return new PluginResult(PluginResult.Status.INVALID_ACTION);
            PluginResult pluginResult = new PluginResult(PluginResult.Status.INVALID_ACTION);
            pluginResult.setKeepCallback(true);
            callbackContext.sendPluginResult(pluginResult);
            return false;
        }
    }


}

