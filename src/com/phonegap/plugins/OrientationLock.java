package com.phonegap.plugins;

import org.json.JSONArray;
import org.json.JSONException;

import android.content.pm.ActivityInfo;

import org.apache.cordova.*;
import org.apache.cordova.api.Plugin;
import org.apache.cordova.api.PluginResult;
/**
 * 
 * Android Phonegap Plugin for locking/unlocking the orientation from JS code
 *
 */
public class OrientationLock extends Plugin {

	private static final String LANSCAPE = "landscape";
	private static final String PORTRAIT = "portrait";
	
	public OrientationLock() {
    }

    public void unlock() {
    	((DroidGap)this.ctx).setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
    }
    
    public void lock(String orientation) {
    	if (orientation.equals(PORTRAIT))
    		((DroidGap)this.ctx).setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    	else
    		((DroidGap)this.ctx).setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

	    
	
	@Override
	public PluginResult execute(String action, JSONArray arguments, String callbackId) {
		if (action.equals("lock")) {
			
			try {
				String orientation = arguments.getString(0);
				
				if (orientation!=null && (orientation.equals(LANSCAPE) ||  orientation.equals(PORTRAIT))) {
					this.lock(orientation);
					return new PluginResult(PluginResult.Status.OK);
				}
				else{
					return new PluginResult(PluginResult.Status.INVALID_ACTION);
				}
				
			} catch (JSONException e) {
				return new PluginResult(PluginResult.Status.JSON_EXCEPTION);
			}
			
		} 
        else if (action.equals("unlock")) {
            this.unlock();
            return new PluginResult(PluginResult.Status.OK);
        }
		else {
			return new PluginResult(PluginResult.Status.INVALID_ACTION);
		}
	}
}

